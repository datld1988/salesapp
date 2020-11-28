package com.salesapp.adminservice.controller;

import com.salesapp.adminservice.dto.DataResponse;
import com.salesapp.adminservice.dto.ResponseStatus;
import com.salesapp.adminservice.repository.GroupDetailVwRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/groupDetailVw")
@Api(tags="Danh sách nhóm của người dùng")
public class GroupDetailVwController {
    @Autowired
    private EntityManager em;
    @Autowired
    private GroupDetailVwRepository repository;

    @GetMapping
    @ApiOperation(value = "Danh sách Danh sách nhóm của người dùng")
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