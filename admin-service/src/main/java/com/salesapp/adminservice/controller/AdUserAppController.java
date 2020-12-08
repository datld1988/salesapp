package com.salesapp.adminservice.controller;

import com.salesapp.adminservice.service.UserService;
import com.salesapp.common.dto.Response;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/adUserApp")
@Api(tags="Gắn người dùng vào ứng dụng")

public class AdUserAppController {
    private final Logger log = LoggerFactory.getLogger(AdUserAppController.class);

    @Autowired
    private UserService userService;

    /**
     * author: dungtq
     * create : 26/11/2020
     * method : lấy thông tin userlogin
     * @param principal
     * @return
     */
    @GetMapping("getInfo")
//    @PreAuthorize("hasAuthority('read_profile')")
    public Response getUserInfo(Principal principal) {
        return userService.getUserInfo(principal.getName());
    }

}
