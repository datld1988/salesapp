package com.salesapp.adminservice.service;

import com.salesapp.adminservice.models.CreateAdUserPortalRequest;
import com.salesapp.adminservice.models.GetAllUserRequest;
import com.salesapp.common.dto.Response;

public interface AdUserPortalService {
    /**
     * author: anhld
     * date: 8/12/2020
     * thêm mới user portal
     * @param
     * @return: kết quả của việc thêm mới
     */
    Response createUserPortal(CreateAdUserPortalRequest request);
    /**
     * author: anhld
     * date: 8/12/2020
     * lấy danh sách các user portal
     * @param
     * @return: danh sách các user portal
     */
    Response getAllUserPortal(GetAllUserRequest request);
}
