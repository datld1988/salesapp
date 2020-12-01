package com.salesapp.adminservice.controller;

import com.salesapp.adminservice.domain.AdGroupRole;
import com.salesapp.adminservice.dto.AdGroupRoleForm;
import com.salesapp.adminservice.dto.DataResponse;
import com.salesapp.adminservice.dto.ResponseStatus;
import com.salesapp.adminservice.repository.AdGroupRoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/adGroupRole")
@Api(tags="Gắn quyền vào nhóm")
public class AdGroupRoleController {
    @Autowired
    private EntityManager em;
    @Autowired
    private AdGroupRoleRepository repository;

    @GetMapping
    @ApiOperation(value = "Danh sách Gắn quyền vào nhóm")
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
    @ApiOperation(value = "Thêm mới Gắn quyền vào nhóm")
    public DataResponse create(@RequestBody AdGroupRoleForm form) {
        DataResponse dataModel = new DataResponse();
        try {
            AdGroupRole bo = new AdGroupRole();
            BeanUtils.copyProperties(form, bo);
            repository.save(bo);
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultSuccess("thêm mới thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultFailed(e));
        }
        return dataModel;
    }

    @PutMapping
    @ApiOperation(value = "Cập nhật Gắn quyền vào nhóm")
    public DataResponse update(@RequestBody AdGroupRoleForm form) {
        DataResponse dataModel = new DataResponse();
        try {
            AdGroupRole dbo = repository.getOne(form.getId());
            BeanUtils.copyProperties(form, dbo, "id, created_date, created_by, modified_date, modified_by");
            repository.save(dbo);
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultSuccess("cập nhật thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultFailed(e));
        }
        return dataModel;
    }

    @DeleteMapping
    @ApiOperation(value = "Xóa Gắn quyền vào nhóm")
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