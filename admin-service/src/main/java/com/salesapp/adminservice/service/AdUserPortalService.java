package com.salesapp.adminservice.service;

import com.salesapp.adminservice.models.CreateUserPortalRequest;
import com.salesapp.adminservice.models.UpdateUserPortalRequest;
import com.salesapp.common.dto.Response;

public interface AdUserPortalService {
    /**
     * author: anhld
     * date: 8/12/2020
     * thêm mới user portal
     * @param
     * @return: kết quả của việc thêm mới
     */
    Response createAdUserPortal(CreateUserPortalRequest request);
    /**
     * author: anhld
     * date: 8/12/2020
     * lấy danh sách các user portal
     * @param
     * @return: danh sách các user portal
     */
    Response getAllUserPortal();
    /**
     * author: anhld
     * date: 8/12/2020
     * xóa user portal(chuyển đổi trạng thái)
     * @param
     * @return: kết quả việc xóa portal
     */
    Response deleteUserPortal(String userId);
    /**
     * author: anhld
     * date: 8/12/2020
     * cập nhật user portal
     * @param
     * @return: kết quả của việc cập nhật
     */
    Response updateUserPortal(UpdateUserPortalRequest request);
    /**
     * author: anhld
     * date: 9/12/2020
     * lấy chi tiết của user portal
     * @param id: id của user portal
     * @return: chi tiết của user portal
     */
    Response getUserPortalDetail(String id);
}
