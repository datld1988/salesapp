package com.salesapp.adminservice.controller;

import com.salesapp.adminservice.dto.DataResponse;
import com.salesapp.adminservice.dto.ResponseStatus;
import com.salesapp.adminservice.repository.BranchUserVwRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/branchUserVw")
@Api(tags="Người dùng")
public class BranchUserVwController {
    @Autowired
    private EntityManager em;
    @Autowired
    private BranchUserVwRepository repository;

    @GetMapping
    @ApiOperation(value = "Danh sách Người dùng")
    public DataResponse list() {
        DataResponse model = new DataResponse();
        try {
            model.setItems(repository.findAll());
            model.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultSuccess(""));
        } catch (Exception e) {
            model.setResponseStatus(ResponseStatus.defaultFailed(e));
        }
        return model;
    }
}