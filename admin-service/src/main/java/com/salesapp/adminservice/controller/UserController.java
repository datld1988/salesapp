package com.salesapp.adminservice.controller;


import com.salesapp.adminservice.dto.UserDto;
import com.salesapp.adminservice.dto.UserRegistrationDto;
import com.salesapp.adminservice.models.ApiResultResponse;
import com.salesapp.adminservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "user")
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

    @GetMapping("get")
//    @PreAuthorize("hasAuthority('read_profile')")
    public ApiResultResponse getUser(Principal principal) {

        ApiResultResponse<UserDto> response = new ApiResultResponse<>();
        response.setResponseCode("00");
        response.setResponseMessage("Success");
        response.setData(userService.getUser(principal.getName()));
        return response;
    }

    @GetMapping("test")
//    @PreAuthorize("hasAuthority('read_profile')")
    public ApiResultResponse testUser(Principal principal) {

        ApiResultResponse<UserDto> response = new ApiResultResponse<>();
        response.setResponseCode("01");
        response.setResponseMessage("Unsuccess");
        try {
            UserDto result = userService.getUser(principal.getName());
            if(result != null) {
                response.setResponseCode("00");
                response.setResponseMessage("Success");
                response.setData(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseMessage(e.toString());
        }
        return response;
    }

}
