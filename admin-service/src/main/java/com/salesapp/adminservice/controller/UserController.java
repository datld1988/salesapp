package com.salesapp.adminservice.controller;


import com.salesapp.adminservice.dto.UserDto;
import com.salesapp.adminservice.dto.UserRegistrationDto;
import com.salesapp.adminservice.models.ApiResultResponse;
import com.salesapp.adminservice.service.UserService;
import com.uniform.common.dto.Message;
import com.uniform.common.dto.Request;
import com.uniform.common.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
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

    @GetMapping("get")
//    @PreAuthorize("hasAuthority('read_profile')")
    public ApiResultResponse testUser(Principal principal) {

        ApiResultResponse<UserDto> response = new ApiResultResponse<>();
        response.setResponseCode("01");
        response.setResponseMessage("Unsuccess");
        try {
            UserDto result = userService.getUser(principal.getName());
            if(result != null) {
                response.setResponseCode("000");
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
