package com.poc.banking.UserService.transfercontroller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.poc.banking.UserService.transfer.service.BeneficiaryPropertiesNottFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
//    @ExceptionHandler(BeneficiaryPropertiesNottFoundException.class)
//    public ResponseEntity<Object> handlBeneficiaryPropertiesNotFound(BeneficiaryPropertiesNottFoundException ex) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("timestamp", LocalDateTime.now());
//        body.put("error", "Some of mandatory properties are not provided");
//        body.put("message", ex.getMessage());
//        body.put("status", HttpStatus.NOT_FOUND.value());
//
//        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//    }

    // Optionally handle other exceptions here
}
