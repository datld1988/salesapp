package com.uniform.adminservice.controller;

import com.uniform.adminservice.domain.RoleDetailVw;
import com.uniform.adminservice.dto.RoleDetailVwForm;
import com.uniform.adminservice.dto.DataResponse;
import com.uniform.adminservice.dto.ResponseStatus;
import com.uniform.adminservice.repository.RoleDetailVwRepository;
import org.springframework.beans.BeanUtils;
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
            model.setResponseStatus(ResponseStatus.defaultSuccess(""));
        } catch (Exception e) {
            model.setResponseStatus(ResponseStatus.defaultFailed(e));
        }
        return model;
    }
}