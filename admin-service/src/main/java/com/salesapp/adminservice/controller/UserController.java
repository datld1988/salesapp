package com.salesapp.adminservice.controller;


import com.salesapp.adminservice.dto.UserDto;
import com.salesapp.adminservice.dto.UserRegistrationDto;

import com.salesapp.adminservice.service.UserService;
import com.salesapp.common.dto.Message;
import com.salesapp.common.dto.Request;
import com.salesapp.common.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<Response<UserDto>> createUser(@Valid @RequestBody Request<UserRegistrationDto> request) {
//        log.debug("REST request to create admin : {}", request.getE());
        userService.saveUser(request);
        Response<UserDto> response = new Response<>();
        //set message
        response.setMessage(new Message("404", "Not found!"));
        //set data
        List<UserDto> userDtos = new ArrayList<>();
        UserDto userDto = new UserDto();
        userDto.setId("1");
        userDto.setUsername("AAA");
        userDtos.add(userDto);
        userDto = new UserDto();
        userDto.setId("2");
        userDto.setUsername("BBB");
        userDtos.add(userDto);
        response.setData(userDtos);


        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
