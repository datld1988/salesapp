package com.salesapp.adminservice.controller;

import com.salesapp.adminservice.domain.AdUser;
import com.salesapp.adminservice.dto.AdUserForm;
import com.salesapp.adminservice.dto.DataResponse;
import com.salesapp.adminservice.dto.ResponseStatus;
import com.salesapp.adminservice.dto.UserDto;
import com.salesapp.adminservice.models.ApiResultResponse;
import com.salesapp.adminservice.repository.AdUserRepository;
import com.salesapp.adminservice.service.UserService;
import com.uniform.common.dto.Response;
import com.uniform.common.utils.ErrorCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.security.Principal;

@RestController
@RequestMapping("/api/adUser")
@Api(tags="Người dùng")
public class AdUserController {
    @Autowired
    private EntityManager em;
    @Autowired
    private AdUserRepository repository;

    @Autowired
    private  UserService userService;

    @GetMapping
    @ApiOperation(value = "Danh sách Người dùng")
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
    @ApiOperation(value = "Thêm mới Người dùng")
    public DataResponse create(@RequestBody AdUserForm form) {
        DataResponse dataModel = new DataResponse();
        try {
            AdUser bo = new AdUser();
            BeanUtils.copyProperties(form, bo);
            repository.save(bo);
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultSuccess("thêm mới thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultFailed(e));
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
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultSuccess("cập nhật thành công"));
        } catch (Exception e) {
            dataModel.setResponseStatus(com.salesapp.adminservice.dto.ResponseStatus.defaultFailed(e));
        }
        return dataModel;
    }

    @DeleteMapping
    @ApiOperation(value = "Xóa Người dùng")
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

    /**
     * author: dungtq
     * create date : 27/11/2020
     * lấy thông tin user login
     * @param principal -- token
     * @return thông tin user
     */
    @GetMapping("getInfo")
    @ApiOperation(value = "Lấy thông tin người dùng")
    public Response getUserInfo(Principal principal) {
        UserDto result = userService.getUser(principal.getName());
        if(result.getId() == null)
            return  Response.error(ErrorCode.SERVICE_ERROR, "Không tìm thấy thông tin người dùng");
        return Response.success(result);

    }
}