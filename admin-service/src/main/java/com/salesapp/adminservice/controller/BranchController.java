package com.salesapp.adminservice.controller;

import com.salesapp.adminservice.service.AdBranchService;
import com.salesapp.adminservice.service.AdUserPortalService;
import com.salesapp.common.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "branch")
public class BranchController {
    @Autowired
    AdBranchService adBranchService;
    /**
     * author: anhld
     * date: 8/12/2020
     * lấy danh sách tất cả các chi nhánh
     * @param
     * @return: danh sách các chi nhánh
     */
    @RequestMapping(path = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getAllBranch() {
        return adBranchService.getAllBranch();
    }
}
