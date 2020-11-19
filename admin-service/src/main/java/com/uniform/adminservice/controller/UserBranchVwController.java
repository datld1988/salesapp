package com.uniform.adminservice.controller;

import com.uniform.adminservice.domain.UserBranchVw;
import com.uniform.adminservice.dto.UserBranchVwForm;
import com.uniform.adminservice.dto.DataResponse;
import com.uniform.adminservice.dto.ResponseStatus;
import com.uniform.adminservice.repository.UserBranchVwRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/userBranchVw")
@Api(tags="Danh sách chi nhánh của người dùng")
public class UserBranchVwController {
    @Autowired
    private EntityManager em;
    @Autowired
    private UserBranchVwRepository repository;

    @GetMapping
    @ApiOperation(value = "Danh sách Danh sách chi nhánh của người dùng")
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