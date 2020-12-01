package com.salesapp.adminservice.service;


import com.salesapp.adminservice.domain.AdUser;
import com.salesapp.adminservice.dto.UserDto;
import com.salesapp.adminservice.dto.UserRegistrationDto;
import com.salesapp.adminservice.repository.AdUserRepository;
import com.salesapp.common.dto.Request;
import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private AdUserRepository adUserRepository;

    public void saveUser(Request<UserRegistrationDto> request) {
//        Converters.castToBoolean("db");
//        if (null == request || null == request.getE()) {
//            throw new SalesException("404", "Not found data!");
//        }
//        log.info(String.format("create a user %s successfully", request.getE().getUsername()));
    }

    /**
     * author: dungtq
     * create : 26/11/2020
     * method : lấy thông tin userlogin
     * @param userName -- username login
     * @return
     */
    public Response getUserInfo(String userName) {
        log.info("----> call get all users method");

        try {
            List<AdUser> lst = adUserRepository.findAdUserByUserNameAndStatusCode(userName, "1");

            log.info("---------------------------> DUNGTQ " + lst.size());

            // có thông tin user
            if (lst.size() >= 1) {
                UserDto userDto = new UserDto();
                userDto.setId(userName);
                userDto.setUsername(lst.get(0).getUserName());
                userDto.setPhone(lst.get(0).getPhone());
                userDto.setAvatar(lst.get(0).getAvatar());
                userDto.setFullName(lst.get(0).getFullName());

                return Response.success(userDto);

            } else {
                AdUser newUser = new AdUser();
                newUser.setId(userName);
                newUser.setUserName(userName);
                newUser.setCreatedDate(new Date());
                newUser.setCreatedBy("System");
                newUser.setAvatar("");
                newUser.setStatusCode("1");
              // đã xác thực + chưa tồn tại trong sales app thì insert default
                adUserRepository.save(newUser);

                return Response.success(newUser);
            }
        } catch (Exception e) {
            log.error("getUserInfo Exception : " + e.toString(), e);
            return Response.error(ErrorCode.SERVICE_ERROR, e.toString());
        }


        //return Response.error(ErrorCode.NOT_FOUND_RECORDS, "Không tìm thấy thông tin "+userName);
    }

}
