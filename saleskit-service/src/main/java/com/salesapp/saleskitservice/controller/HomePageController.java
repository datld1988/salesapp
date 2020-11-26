package com.salesapp.saleskitservice.controller;


import com.salesapp.saleskitservice.dto.HomePageMobileDto;

import com.salesapp.saleskitservice.model.ApiResultResponse;

import com.salesapp.saleskitservice.service.HomePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "dashbroad")
public class HomePageController {

    private final Logger log = LoggerFactory.getLogger(HomePageController.class);
    @Autowired
    private HomePageService homePageService;


    @GetMapping("/test")
    public ResponseEntity<Object> ping() {
        return new ResponseEntity<>("ping success", HttpStatus.OK);
    }

    @RequestMapping(path = "info", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse getInfoHomePageMobile (Principal pri) {
        ApiResultResponse<HomePageMobileDto> response = new ApiResultResponse<>();
        response.setResponseCode("00");
        response.setResponseMessage("Success");
        response.setData(homePageService.getInfoForHome(pri.getName()));
        return response;
    }
}
