package com.cts.project.flightReservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.project.flightReservation.service.FlightService;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FlightReservationApplicationTests {
	
	
    @Autowired
    FlightService Fs;

    @Test
    void contextLoads() {
    }
    
    
    @Test
    void testGetFlights() {
    	assertNotNull(Fs.findByid(1));
    }
    
    @Test
    void testGetAllFlights() {
    	assertNotNull(Fs.findall());
    }

}















































































































//package com.cts.project.flightReservation;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//class FlightReservationApplicationTests {
//
//
//    @Test
//    void contextLoads() {
//    }
//    
//    
//
//    
//}




































































































//package com.cts.project.flightReservation;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class FlightReservationApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}
