package com.salesapp.adminservice.controller;

import com.salesapp.adminservice.models.AssignUserRoleRequest;
import com.salesapp.adminservice.models.SaveRoleRequest;
import com.salesapp.adminservice.service.RoleService;
import com.salesapp.adminservice.service.UserService;
import com.salesapp.common.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "role")
public class RoleController {

    private final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * authen: AnhLD
     * date: 3/12/2020
     * @param keySearch : tìm kiếm role theo description, roleName, id
     * @return
     */
    @RequestMapping(path = "search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response searchRole(@RequestParam String keySearch) {
        return roleService.searchRole(keySearch);
    }

    /**
     * authen: Anhld
     * date: 3/12/2020
     * @param request thông tin insert role (roleInfo, list AdRoleMenuDto, list AdRoleRightDto)
     * @return success / fail
     */
    @RequestMapping(path = "insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response insertRole(@RequestBody SaveRoleRequest request) {
        return roleService.insertRole(request);
    }

    /**
     * authen :Anhld
     * @param request thông tin update role
     * @return
     */
    @RequestMapping(path = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response updateRole(@RequestBody SaveRoleRequest request) {
        return roleService.updateRole(request);
    }

    @RequestMapping(path = "delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response deleteRole(@RequestParam String deleteId) {
        return roleService.deleteRole(deleteId);
    }

    @RequestMapping(path = "assignRole", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response assignUserRole(@RequestBody AssignUserRoleRequest request) {
        return roleService.assignUserRole(request);
    }
}
