package com.cts.project.flightReservation.service;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.project.flightReservation.model.AuthenticationResponse;
import com.cts.project.flightReservation.model.PassengerDetails;
import com.cts.project.flightReservation.model.Token;
import com.cts.project.flightReservation.repository.PassengerDetailsRepository;
import com.cts.project.flightReservation.repository.TokenRepository;

@Service
public class AuthenticationService {
 
    private final PassengerDetailsRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
 
    private final TokenRepository tokenRepository;
 
    private final AuthenticationManager authenticationManager;
 
    public AuthenticationService(PassengerDetailsRepository repository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 TokenRepository tokenRepository,
                                 AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenRepository = tokenRepository;
        this.authenticationManager = authenticationManager;
    }
 
    public AuthenticationResponse register(PassengerDetails request) {
 
        // check if user already exist. if exist than authenticate the user
        if(repository.findByEmail(request.getUsername()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist", null);
        }
 
        PassengerDetails user = new PassengerDetails();
        user.setAddress(request.getAddress());
        user.setAge(request.getAge());
        user.setBirthDate(request.getBirthDate());
        user.setEmail(request.getUsername());
        user.setMobileNo(request.getMobileNo());
        user.setGender(request.getGender());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUserName(request.getUserName());
        user.setRole("USER");
 
        user = repository.save(user);
 
        String jwt = jwtService.generateToken(user);
 
        saveUserToken(jwt, user);
 
        return new AuthenticationResponse(jwt, "User registration was successful", user);
 
    }
 
    public AuthenticationResponse authenticate(PassengerDetails request) {
    	try {
	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        request.getUsername(),
	                        request.getPassword()
	                )
	        );
    	}
    	catch(AuthenticationException e) {
    		return new AuthenticationResponse(null, "Invalid Login",null);
    	}
 
        PassengerDetails user = repository.findByEmail(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);
 
        revokeAllTokenByUser(user);
        saveUserToken(jwt, user);
 
        return new AuthenticationResponse(jwt, "User login was successful",user);
 
    }
    private void revokeAllTokenByUser(PassengerDetails user) {
        List<Token> validTokens = tokenRepository.findAllTokensByUser(user.getId());
        if(validTokens.isEmpty()) {
            return;
        }
 
        validTokens.forEach(t-> {
            t.setLoggedOut(true);
        });
 
        tokenRepository.saveAll(validTokens);
    }
    private void saveUserToken(String jwt, PassengerDetails user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setUser(user);
        tokenRepository.save(token);
    }
}
