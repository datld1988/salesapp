package com.salesapp.adminservice.service;


import com.salesapp.adminservice.domain.AdUser;
import com.salesapp.adminservice.dto.UserDto;
import com.salesapp.adminservice.dto.UserRegistrationDto;
import com.salesapp.adminservice.repository.AdUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private AdUserRepository adUserRepository;

    public void saveUser(UserRegistrationDto user) {
        log.info(String.format("create a user %s successfully", user.getUsername()));
    }

    public UserDto getUser(String userName) {
        log.info("----> call get all users method");
        List<AdUser> lst = adUserRepository.findAdUserByUserNameAndStatusCode(userName, "1");

        log.info("---------------------------> DUNGTQ "+lst.size());
        UserDto userDto = new UserDto();
        // có thông tin user
        if(lst.size() >= 1) {
            userDto.setId(userName);
            userDto.setUsername(lst.get(0).getUserName());
            userDto.setPhone(lst.get(0).getPhone());
            userDto.setAvatar(lst.get(0).getAvatar());
            userDto.setFullName(lst.get(0).getFullName());
            return userDto;
        }
        return null;

    }
}
