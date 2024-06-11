package com.cts.project.flightReservation.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.project.flightReservation.model.PassengerDetails;

@Repository
public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails,Integer>{
	  @Query(value="select * from passenger where email=:email and password=:password",nativeQuery=true)
	  PassengerDetails findUserByCred(String email,String password);
	  
	  
	  Optional<PassengerDetails> findByEmail(String email);
}
