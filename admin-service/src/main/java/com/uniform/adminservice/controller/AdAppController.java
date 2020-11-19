package com.uniform.adminservice.controller;

import com.uniform.adminservice.domain.AdApp;
import com.uniform.adminservice.dto.AdAppForm;
import com.uniform.adminservice.dto.DataResponse;
import com.uniform.adminservice.dto.ResponseStatus;
import com.uniform.adminservice.repository.AdAppRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/adApp")
@Api(tags="Ứng dụng")
public class AdAppController {
    @Autowired
    private EntityManager em;
    @Autowired
    private AdAppRepository repository;

    @GetMapping
    @ApiOperation(value = "Danh sách Ứng dụng")
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
    @ApiOperation(value = "Thêm mới Ứng dụng")
    public DataResponse create(@RequestBody AdAppForm form) {
        DataResponse dataModel = new DataResponse();
        try {
            AdApp bo = new AdApp();
            BeanUtils.copyProperties(form, bo);
            repository.save(bo);
            dataModel.setResponseStatus(ResponseStatus.defaultSuccess("thêm mới thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(ResponseStatus.defaultFailed(e));
        }
        return dataModel;
    }

    @PutMapping
    @ApiOperation(value = "Cập nhật Ứng dụng")
    public DataResponse update(@RequestBody AdAppForm form) {
        DataResponse dataModel = new DataResponse();
        try {
            AdApp dbo = repository.getOne(form.getId());
            BeanUtils.copyProperties(form, dbo, "id, created_date, created_by, modified_date, modified_by");
            repository.save(dbo);
            dataModel.setResponseStatus(ResponseStatus.defaultSuccess("cập nhật thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(ResponseStatus.defaultFailed(e));
        }
        return dataModel;
    }

    @DeleteMapping
    @ApiOperation(value = "Xóa Ứng dụng")
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