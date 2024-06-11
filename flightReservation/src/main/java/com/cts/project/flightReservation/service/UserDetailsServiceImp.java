package com.cts.project.flightReservation.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.project.flightReservation.repository.PassengerDetailsRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final PassengerDetailsRepository repository;

    public UserDetailsServiceImp(PassengerDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
