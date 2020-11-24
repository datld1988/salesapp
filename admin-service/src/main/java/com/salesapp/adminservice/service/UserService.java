package com.salesapp.adminservice.service;


import com.salesapp.adminservice.dto.UserDto;
import com.salesapp.adminservice.dto.UserRegistrationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
