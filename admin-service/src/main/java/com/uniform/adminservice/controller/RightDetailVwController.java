package com.uniform.adminservice.controller;

import com.uniform.adminservice.domain.RightDetailVw;
import com.uniform.adminservice.dto.RightDetailVwForm;
import com.uniform.adminservice.dto.DataResponse;
import com.uniform.adminservice.dto.ResponseStatus;
import com.uniform.adminservice.repository.RightDetailVwRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/rightDetailVw")
@Api(tags="Danh sách chức năng trong quyền")
public class RightDetailVwController {
    @Autowired
    private EntityManager em;
    @Autowired
    private RightDetailVwRepository repository;

    @GetMapping
    @ApiOperation(value = "Danh sách Danh sách chức năng trong quyền")
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