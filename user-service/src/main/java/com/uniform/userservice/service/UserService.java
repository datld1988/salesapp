package com.uniform.userservice.service;


import com.uniform.userservice.dto.UserDto;
import com.uniform.userservice.dto.UserRegistrationDto;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);

    public void saveUser(UserRegistrationDto user) {
        log.info(String.format("create a user %s successfully", user.getUsername()));
    }

    public UserDto getUser() {
        log.info("----> call get all users method");
        UserDto userDto = new UserDto();
        userDto.setUsername("TEST call rest template");
        return userDto;
    }
}
