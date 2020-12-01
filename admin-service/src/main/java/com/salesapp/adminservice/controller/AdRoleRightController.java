package com.salesapp.adminservice.controller;

import com.salesapp.adminservice.domain.AdRoleRight;
import com.salesapp.adminservice.dto.AdRoleRightForm;
import com.salesapp.adminservice.dto.DataResponse;
import com.salesapp.adminservice.dto.ResponseStatus;
import com.salesapp.adminservice.repository.AdRoleRightRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/adRoleRight")
@Api(tags="Gắn chức năng vào quyền")
public class AdRoleRightController {
    @Autowired
    private EntityManager em;
    @Autowired
    private AdRoleRightRepository repository;

    @GetMapping
    @ApiOperation(value = "Danh sách Gắn chức năng vào quyền")
    public DataResponse list() {
        DataResponse model = new DataResponse();
        try {
            model.setItems(repository.findAll());
            model.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultSuccess(""));
        } catch (Exception e) {
            model.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultFailed(e));
        }
        return model;
    }

    @PostMapping
    @ApiOperation(value = "Thêm mới Gắn chức năng vào quyền")
    public DataResponse create(@RequestBody AdRoleRightForm form) {
        DataResponse dataModel = new DataResponse();
        try {
            AdRoleRight bo = new AdRoleRight();
            BeanUtils.copyProperties(form, bo);
            repository.save(bo);
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultSuccess("thêm mới thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultFailed(e));
        }
        return dataModel;
    }

    @PutMapping
    @ApiOperation(value = "Cập nhật Gắn chức năng vào quyền")
    public DataResponse update(@RequestBody AdRoleRightForm form) {
        DataResponse dataModel = new DataResponse();
        try {
            AdRoleRight dbo = repository.getOne(form.getId());
            BeanUtils.copyProperties(form, dbo, "id, created_date, created_by, modified_date, modified_by");
            repository.save(dbo);
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultSuccess("cập nhật thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultFailed(e));
        }
        return dataModel;
    }

    @DeleteMapping
    @ApiOperation(value = "Xóa Gắn chức năng vào quyền")
    public DataResponse delete(@PathVariable String id) {
        DataResponse dataModel = new DataResponse();
        try {
            repository.deleteById(id);
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultSuccess("xóa thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(ResponseStatus.defaultFailed(e));
        }
        return dataModel;
    }
}