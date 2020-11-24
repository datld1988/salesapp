package com.salesapp.adminservice.controller;

import com.salesapp.adminservice.dto.DataResponse;
import com.salesapp.adminservice.dto.ResponseStatus;
import com.salesapp.adminservice.repository.RoleDetailVwRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/roleDetailVw")
@Api(tags="Danh sách quyền trong nhóm")
public class RoleDetailVwController {
    @Autowired
    private EntityManager em;
    @Autowired
    private RoleDetailVwRepository repository;

    @GetMapping
    @ApiOperation(value = "Danh sách Danh sách quyền trong nhóm")
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