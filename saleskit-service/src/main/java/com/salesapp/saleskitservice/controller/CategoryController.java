package com.salesapp.saleskitservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("/test")
    public ResponseEntity<Object> ping() {
        return new ResponseEntity<>("ping success", HttpStatus.OK);
    }

}
