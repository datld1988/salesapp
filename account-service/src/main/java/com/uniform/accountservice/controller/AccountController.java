package com.uniform.accountservice.controller;

import com.uniform.accountservice.dto.UserRegistrationDto;
import com.uniform.accountservice.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final Logger log = LoggerFactory.getLogger(AccountController.class);

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
//    @PreAuthorize("hasAuthority('create_profile')")
    public ResponseEntity<Object> createAccount(@RequestBody UserRegistrationDto user) {
        log.debug("REST request to create admin : {}", user);
        log.info("REST request to create admin : {}", user);
        accountService.saveAccount(user);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

}
