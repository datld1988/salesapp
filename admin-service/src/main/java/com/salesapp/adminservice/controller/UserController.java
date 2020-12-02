package com.salesapp.adminservice.controller;


import com.salesapp.adminservice.dto.UserDto;
import com.salesapp.adminservice.dto.UserRegistrationDto;
import com.salesapp.adminservice.service.UserService;
import com.salesapp.common.dto.Request;
import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



//    /**
//     * demo sử dụng Respone. Sử dụng kiểu trả về là ResponseEntity<Response<UserDto>>
//     * Uncomment class ở phần comment 2. Sử dụng cho kiểu trả về là ResponseEntity<Response<UserDto>>
//     */
//    @PostMapping("/createdemo1")
//    //@PreAuthorize("hasAuthority('create_profile')")
//    public ResponseEntity<Response<UserDto>> create1User(@Valid @RequestBody Request<UserRegistrationDto> request) {
//        userService.saveUser(request);
//
//        Response<UserDto> response = new Response<>();
//        response.success("Thêm mới user thành công!");
//
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

    /**
     * demo sử dụng Respone
     * @param request
     * @return
     */
    @PostMapping("/createdemo2")
    //@PreAuthorize("hasAuthority('create_profile')")
    public Response create2User(@Valid @RequestBody Request<UserRegistrationDto> request) {
        userService.saveUser(request);

        return Response.success("Thêm mới user thành công!");
    }

    /**
     * demo sử dụng Respone
     * @param request
     * @return
     */
    @GetMapping("/getdemo")
    //@PreAuthorize("hasAuthority('read_profile')")
    public Response getUser(@Valid @RequestBody Request<UserRegistrationDto> request) {
        if (null == request || null == request.getRequestData()) {
            return Response.error(ErrorCode.NOT_FOUND, "Request data is null!");
        }
        return Response.success(userService.getUser(request.getRequestData().getUsername()));
    }

    /**
     * demo sử dụng Respone
     * @param request
     * @return
     */
    @GetMapping("testdemo")
    //@PreAuthorize("hasAuthority('read_profile')")
    public Response testUser(@Valid @RequestBody Request<UserRegistrationDto> request) {
        if (null == request || null == request.getRequestData()) {
            return Response.error(ErrorCode.NOT_FOUND, "Request data is null!");
        }
        UserDto result = userService.getUser(request.getRequestData().getUsername());
        return Response.success(result);
    }

}
