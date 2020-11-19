package com.uniform.adminservice.controller;

import com.uniform.adminservice.domain.AdUser;
import com.uniform.adminservice.dto.AdUserForm;
import com.uniform.adminservice.dto.DataResponse;
import com.uniform.adminservice.dto.ResponseStatus;
import com.uniform.adminservice.repository.AdUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/adUser")
@Api(tags="Người dùng")
public class AdUserController {
    @Autowired
    private EntityManager em;
    @Autowired
    private AdUserRepository repository;

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

    @PostMapping
    @ApiOperation(value = "Thêm mới Người dùng")
    public DataResponse create(@RequestBody AdUserForm form) {
        DataResponse dataModel = new DataResponse();
        try {
            AdUser bo = new AdUser();
            BeanUtils.copyProperties(form, bo);
            repository.save(bo);
            dataModel.setResponseStatus(ResponseStatus.defaultSuccess("thêm mới thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(ResponseStatus.defaultFailed(e));
        }
        return dataModel;
    }

    @PutMapping
    @ApiOperation(value = "Cập nhật Người dùng")
    public DataResponse update(@RequestBody AdUserForm form) {
        DataResponse dataModel = new DataResponse();
        try {
            AdUser dbo = repository.getOne(form.getId());
            BeanUtils.copyProperties(form, dbo, "id, created_date, created_by, modified_date, modified_by");
            repository.save(dbo);
            dataModel.setResponseStatus(ResponseStatus.defaultSuccess("cập nhật thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(ResponseStatus.defaultFailed(e));
        }
        return dataModel;
    }

    @DeleteMapping
    @ApiOperation(value = "Xóa Người dùng")
    public DataResponse delete(@PathVariable String id) {
        DataResponse dataModel = new DataResponse();
        try {
            repository.deleteById(id);
            dataModel.setResponseStatus(ResponseStatus.defaultSuccess("xóa thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(ResponseStatus.defaultFailed(e));
        }
        return dataModel;
    }
}