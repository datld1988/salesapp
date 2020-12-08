package com.salesapp.adminservice.controller;

import com.salesapp.adminservice.models.CreateAdUserPortalRequest;
import com.salesapp.adminservice.service.AdUserPortalService;
import com.salesapp.common.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "userPortal")
public class UserPortalController {

    @Autowired
    AdUserPortalService adUserPortalService;
    /**
     * author: anhld
     * date: 8/12/2020
     * lấy danh sách tất cả các user portal
     * @param
     * @return: danh sách các user portal
     */
    @RequestMapping(path = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getAllUserPortal() {
        return adUserPortalService.getAllUserPortal();
    }
    /**
     * author: anhld
     * date: 8/12/2020
     * thêm mới user portal
     * @param
     * @return: kết quả việc thêm mới
     */
    @RequestMapping(path = "add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response insertUserPortal(@RequestBody CreateAdUserPortalRequest request) {
        return adUserPortalService.createAdUserPortal(request);
    }
    /**
     * author: anhld
     * date: 8/12/2020
     * xóa user portal
     * @param
     * @return: kết quả của việc xóa
     */
    @RequestMapping(path = "delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response deleteUserPortal(@RequestParam("userId") String userId) {
        return adUserPortalService.deleteUserPortal(userId);
    }

    /**
     * author: anhld
     * date: 8/12/2020
     * update user portal
     * @param
     * @return: kết quả của việc cập nhật
     */

    @RequestMapping(path = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response updateUserPortal(@RequestBody CreateAdUserPortalRequest request) {
        return adUserPortalService.updateUserPortal(request);
    }
}
