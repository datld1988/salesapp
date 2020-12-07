package com.salesapp.adminservice.controller;

import com.salesapp.adminservice.models.CreateAdUserPortalRequest;
import com.salesapp.adminservice.models.GetAllUserRequest;
import com.salesapp.adminservice.service.AdUserPortalService;
import com.salesapp.common.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "userPortal")
public class UserPortalController {
    @Autowired
    AdUserPortalService adUserPortalService;
    /**
     * author: anhld
     * date: 8/12/2020
     * lấy danh sách tất cả các user portal
     * @param
     * @return: danh sách các user portal
     */
    @RequestMapping(path = "list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getAllUserPortal(@RequestBody GetAllUserRequest getAllUserRequest) {
        return adUserPortalService.getAllUserPortal(getAllUserRequest);
    }
    /**
     * author: anhld
     * date: 8/12/2020
     * lấy danh sách các user portal
     * @param
     * @return: danh sách các user portal
     */
    @RequestMapping(path = "add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response insertUserPortal(@RequestBody CreateAdUserPortalRequest request) {
        return adUserPortalService.createUserPortal(request);
    }
}
