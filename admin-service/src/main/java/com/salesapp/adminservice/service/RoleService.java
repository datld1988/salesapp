package com.salesapp.adminservice.service;

import com.salesapp.adminservice.models.AssignUserRoleRequest;
import com.salesapp.adminservice.models.SaveRoleRequest;
import com.salesapp.common.dto.Response;

public interface RoleService {
    Response searchRole(String keySearch);

    Response insertRole(SaveRoleRequest request);

    Response updateRole(SaveRoleRequest request);

    Response deleteRole(String id);

    Response assignUserRole(AssignUserRoleRequest request);
}
