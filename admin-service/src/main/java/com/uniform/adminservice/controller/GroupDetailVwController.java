package com.uniform.adminservice.controller;

import com.uniform.adminservice.domain.GroupDetailVw;
import com.uniform.adminservice.dto.GroupDetailVwForm;
import com.uniform.adminservice.dto.DataResponse;
import com.uniform.adminservice.dto.ResponseStatus;
import com.uniform.adminservice.repository.GroupDetailVwRepository;
import org.springframework.beans.BeanUtils;
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
            model.setResponseStatus(ResponseStatus.defaultSuccess(""));
        } catch (Exception e) {
            model.setResponseStatus(ResponseStatus.defaultFailed(e));
        }
        return model;
    }
}