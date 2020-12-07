package com.salesapp.adminservice.service.impl;

import com.salesapp.adminservice.constant.UserPortalConstant;
import com.salesapp.adminservice.domain.AdBranchUser;
import com.salesapp.adminservice.domain.AdRole;
import com.salesapp.adminservice.domain.AdRoleMenu;
import com.salesapp.adminservice.domain.AdUserPortal;
import com.salesapp.adminservice.dto.AdBranchUserDto;
import com.salesapp.adminservice.dto.AdUserPortalDto;
import com.salesapp.adminservice.models.CreateAdUserPortalRequest;
import com.salesapp.adminservice.models.GetAllUserRequest;
import com.salesapp.adminservice.models.GetAllUserResponse;
import com.salesapp.adminservice.repository.AdBranchRepository;
import com.salesapp.adminservice.repository.AdBranchUserRepository;
import com.salesapp.adminservice.repository.AdUserPortalRepository;
import com.salesapp.adminservice.service.AdUserPortalService;
import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdUserPortalServiceImpl implements AdUserPortalService {
    private final Logger log = LoggerFactory.getLogger(AdUserPortalServiceImpl.class);
    @Autowired
    private AdUserPortalRepository adUserPortalRepository;
    @Autowired
    private AdBranchUserRepository adBranchUserRepository;

    /**
     * author: anhld
     * date: 8/12/2020
     * thêm mới user portal
     * @return: kết quả của việc thêm mới
     */
    @Override
    public Response createUserPortal(CreateAdUserPortalRequest request) {
        AdUserPortal adUserPortal = new AdUserPortal();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            Optional<AdUserPortal> checkUser = adUserPortalRepository.findById(request.getUserPortal().getUserId());
            if (!checkUser.isPresent()){
                adUserPortal.setUserId(request.getUserPortal().getUserId());
                adUserPortal.setPassword(request.getUserPortal().getPassword());
                adUserPortal.setFullNamel(request.getUserPortal().getFullName());
                adUserPortal.setPhone(request.getUserPortal().getPhone());
                adUserPortal.setEmail(request.getUserPortal().getEmail());
                adUserPortal.setRole(request.getUserPortal().getRole());
                adUserPortal.setStatus(UserPortalConstant.STATUS_ACTIVE);
                adUserPortal.setPosition(request.getUserPortal().getPosition());
                adUserPortal.setCreateBy(user);
                adUserPortal.setCreateDate(new Date());
                AdUserPortal addedUser = adUserPortalRepository.save(adUserPortal);
                if (request.getUserBranchList().size() >=1){
                    List<AdBranchUser> adBranchUserList = new ArrayList<>();
                    for (AdBranchUserDto adBranchUserDto : request.getUserBranchList()){
                        AdBranchUser adBranchUser = new AdBranchUser();
                        adBranchUser.setBranchId(adBranchUserDto.getBranchId());
                        adBranchUser.setUserId(addedUser.getUserId());
                        adBranchUser.setCreatedDate(new Date());
                        adBranchUser.setCreatedBy(user);
                        adBranchUserList.add(adBranchUser);
                    }
                    adBranchUserRepository.saveAll(adBranchUserList);
                }
                return Response.success("Add successful");
            }
            else {
                return Response.error("408","user portal existed");
            }
        }
        catch (Exception e){
            log.error("createUserPortal Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }
    /**
     * author: anhld
     * date: 8/12/2020
     * lấy danh sách các user portal
     * @return: danh sách các user portal
     */
    @Override
    public Response getAllUserPortal(GetAllUserRequest request) {
        try{
            Page<AdUserPortalDto> adUserPortalDtoList = adUserPortalRepository.getAllUser(
                    PageRequest.of(request.getPage(), request.getPerPage()));
            List<GetAllUserResponse> allUserResponseList = new ArrayList<>();
            if (adUserPortalDtoList.getSize() >=1){
                for (AdUserPortalDto adUserPortalDto : adUserPortalDtoList){
                    GetAllUserResponse getAllUserResponse = new GetAllUserResponse();
                    List<AdBranchUserDto> branchUserDtoList =
                            adBranchUserRepository.getBranchOfUser(adUserPortalDto.getUserId());
                    getAllUserResponse.setListBranch(branchUserDtoList);
                    getAllUserResponse.setUserPortal(adUserPortalDto);
                    allUserResponseList.add(getAllUserResponse);
                }

                return Response.success(allUserResponseList);
            }
            else {
                return Response.error(ErrorCode.NOT_FOUND_RECORDS, "no record found");
            }
        }
        catch (Exception e){
            log.error("getAllUserPortal Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }
}
