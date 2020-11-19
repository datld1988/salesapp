package com.uniform.accountservice.service;

import com.uniform.accountservice.config.AccessToken;
import com.uniform.accountservice.dto.UserDto;
import com.uniform.accountservice.dto.UserRegistrationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class AccountService {
    private final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private RestTemplate restTemplate;

    public void saveAccount(UserRegistrationDto user) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<UserDto> customerHttpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<UserDto> responseEntity = restTemplate.exchange("http://localhost:8080/admin/get", HttpMethod.GET, customerHttpEntity, UserDto.class);
        log.info(responseEntity.getBody().getUsername());
        log.info(String.format("create a user %s successfully", user.getUsername()));
    }
}
