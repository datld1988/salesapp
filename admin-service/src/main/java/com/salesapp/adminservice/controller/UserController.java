package com.salesapp.adminservice.controller;


import com.salesapp.adminservice.dto.UserRegistrationDto;
import com.salesapp.adminservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
//    @PreAuthorize("hasAuthority('create_profile')")
    public ResponseEntity<Object> createUser(@RequestBody UserRegistrationDto user) {
        log.debug("REST request to create admin : {}", user);
        userService.saveUser(user);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @GetMapping("/get")
//    @PreAuthorize("hasAuthority('read_profile')")
    public ResponseEntity<Object> getUser() {
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }

}
