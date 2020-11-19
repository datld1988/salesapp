package com.uniform.adminservice.controller;

import com.uniform.adminservice.domain.BranchUserVw;
import com.uniform.adminservice.dto.BranchUserVwForm;
import com.uniform.adminservice.dto.DataResponse;
import com.uniform.adminservice.dto.ResponseStatus;
import com.uniform.adminservice.repository.BranchUserVwRepository;
import org.springframework.beans.BeanUtils;
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
            model.setResponseStatus(ResponseStatus.defaultSuccess(""));
        } catch (Exception e) {
            model.setResponseStatus(ResponseStatus.defaultFailed(e));
        }
        return model;
    }
}