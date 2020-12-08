package com.salesapp.adminservice.service.impl;

import com.salesapp.adminservice.constant.UserPortalConstant;
import com.salesapp.adminservice.domain.AdBranchUser;
import com.salesapp.adminservice.domain.AdUserPortal;
import com.salesapp.adminservice.domain.SAppTagsUserPortal;
import com.salesapp.adminservice.dto.AdBranchUserDto;
import com.salesapp.adminservice.dto.AdUserPortalDto;
import com.salesapp.adminservice.dto.SAppTagsUserPortalDto;
import com.salesapp.adminservice.models.CreateAdUserPortalRequest;
import com.salesapp.adminservice.models.FilterUserRequest;
import com.salesapp.adminservice.models.GetAllUserResponse;
import com.salesapp.adminservice.repository.AdBranchUserRepository;
import com.salesapp.adminservice.repository.AdUserPortalRepository;
import com.salesapp.adminservice.repository.SAppTagsUserPortalRepository;
import com.salesapp.adminservice.service.AdUserPortalService;
import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

@Service
public class AdUserPortalServiceImpl implements AdUserPortalService {
    private final Logger log = LoggerFactory.getLogger(AdUserPortalServiceImpl.class);
    @Autowired
    private AdUserPortalRepository adUserPortalRepository;
    @Autowired
    private AdBranchUserRepository adBranchUserRepository;
    @Autowired
    private SAppTagsUserPortalRepository sAppTagsUserPortalRepository;

    /**
     * author: anhld
     * date: 8/12/2020
     * thêm mới user portal
     * @return: kết quả của việc thêm mới
     */
    @Override
    public Response createAdUserPortal(CreateAdUserPortalRequest request) {
        AdUserPortal adUserPortal = new AdUserPortal();

        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            Optional<AdUserPortal> checkUser = adUserPortalRepository.findById(request.getUserPortal().getUserId());
            if (!checkUser.isPresent()){
                adUserPortal.setUserId(request.getUserPortal().getUserId());
                //encrypt password with md5
                byte[] messageDigest  = md.digest(request.getUserPortal().getPassword().getBytes());
                BigInteger bigInt  = new BigInteger(1, messageDigest);
                String hashtext = bigInt.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                adUserPortal.setPassword(hashtext);
                adUserPortal.setFullNamel(request.getUserPortal().getFullName());
                adUserPortal.setPhone(request.getUserPortal().getPhone());
                adUserPortal.setEmail(request.getUserPortal().getEmail());
                adUserPortal.setRole(request.getUserPortal().getRole());
                adUserPortal.setStatus(request.getUserPortal().getStatus());
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
                List<SAppTagsUserPortal> sAppTagsUserPortalList = new ArrayList<>();
                if (request.getListTagQnA().size() >=1){
                    for (SAppTagsUserPortalDto sAppTagsUserPortalDto :request.getListTagQnA()){
                        SAppTagsUserPortal appTagsUserPortal = new SAppTagsUserPortal();

                        appTagsUserPortal.setTagId(sAppTagsUserPortalDto.getTagId());
                        appTagsUserPortal.setUserPortalId(addedUser.getUserId());
                        appTagsUserPortal.setCreateBy(user);
                        appTagsUserPortal.setCreateDate(new Date());
                        appTagsUserPortal.setTagType(UserPortalConstant.TAG_TYPE_QNA);
                        appTagsUserPortal.setStatus(UserPortalConstant.STATUS_ACTIVE);

                        sAppTagsUserPortalList.add(appTagsUserPortal);
                    }
                }
                if (request.getListTagNews().size() >=1){
                    for (SAppTagsUserPortalDto sAppTagsUserPortalDto :request.getListTagNews()){
                        SAppTagsUserPortal appTagsUserPortal = new SAppTagsUserPortal();

                        appTagsUserPortal.setTagId(sAppTagsUserPortalDto.getTagId());
                        appTagsUserPortal.setUserPortalId(addedUser.getUserId());
                        appTagsUserPortal.setCreateBy(user);
                        appTagsUserPortal.setCreateDate(new Date());
                        appTagsUserPortal.setTagType(UserPortalConstant.TAG_TYPE_NEWS);
                        appTagsUserPortal.setStatus(UserPortalConstant.STATUS_ACTIVE);

                        sAppTagsUserPortalList.add(appTagsUserPortal);
                    }
                }
                if (request.getListTagKPI().size() >=1){
                    for (SAppTagsUserPortalDto sAppTagsUserPortalDto :request.getListTagKPI()){
                        SAppTagsUserPortal appTagsUserPortal = new SAppTagsUserPortal();

                        appTagsUserPortal.setTagId(sAppTagsUserPortalDto.getTagId());
                        appTagsUserPortal.setUserPortalId(addedUser.getUserId());
                        appTagsUserPortal.setCreateBy(user);
                        appTagsUserPortal.setCreateDate(new Date());
                        appTagsUserPortal.setTagType(UserPortalConstant.TAG_TYPE_KPI);
                        appTagsUserPortal.setStatus(UserPortalConstant.STATUS_ACTIVE);

                        sAppTagsUserPortalList.add(appTagsUserPortal);
                    }
                }
                if (request.getListTagTool().size() >=1){
                    for (SAppTagsUserPortalDto sAppTagsUserPortalDto :request.getListTagTool()){
                        SAppTagsUserPortal appTagsUserPortal = new SAppTagsUserPortal();

                        appTagsUserPortal.setTagId(sAppTagsUserPortalDto.getTagId());
                        appTagsUserPortal.setUserPortalId(addedUser.getUserId());
                        appTagsUserPortal.setCreateBy(user);
                        appTagsUserPortal.setCreateDate(new Date());
                        appTagsUserPortal.setTagType(UserPortalConstant.TAG_TYPE_TOOL);
                        appTagsUserPortal.setStatus(UserPortalConstant.STATUS_ACTIVE);

                        sAppTagsUserPortalList.add(appTagsUserPortal);
                    }
                }
                sAppTagsUserPortalRepository.saveAll(sAppTagsUserPortalList);
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
    public Response getAllUserPortal() {
        try{
            List<AdUserPortalDto> adUserPortalDtoList = adUserPortalRepository.getAllUser();
            List<GetAllUserResponse> allUserResponseList = new ArrayList<>();
            if (adUserPortalDtoList.size() >=1){
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
    /**
     * author: anhld
     * date: 8/12/2020
     * lấy danh sách các user portal
     * @return: danh sách các user portal
     */
    @Transactional
    @Override
    public Response deleteUserPortal(String userId) {
        try {
            Optional<AdUserPortal> checkUser= adUserPortalRepository.findById(userId);
            if (checkUser.isPresent()){
                adUserPortalRepository.deactiveUserPortal(userId, UserPortalConstant.STATUS_INACTIVE);
                return Response.success("Delete successful");
            }
            else {
                return Response.error(ErrorCode.NOT_FOUND_RECORDS,"record not existed");
            }
        }
        catch (Exception e){
            log.error("deleteUserPortal Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }
    /**
     * author: anhld
     * date: 8/12/2020
     * update user portal
     * @return: kết quả việc update user portal
     */
    @Transactional
    @Override
    public Response updateUserPortal(CreateAdUserPortalRequest request) {
        AdUserPortal adUserPortal = new AdUserPortal();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            Optional<AdUserPortal> checkUser = adUserPortalRepository.findById(request.getUserPortal().getUserId());
            if (checkUser.isPresent()){
                adUserPortal.setUserId(request.getUserPortal().getUserId());
                adUserPortal.setPassword(checkUser.get().getPassword());
                if (!request.getUserPortal().getPassword().isEmpty()){
                    //encrypt password with md5
                    byte[] messageDigest  = md.digest(request.getUserPortal().getPassword().getBytes());
                    BigInteger bigInt  = new BigInteger(1, messageDigest);
                    String hashtext = bigInt.toString(16);
                    while (hashtext.length() < 32) {
                        hashtext = "0" + hashtext;
                    }
                    adUserPortal.setPassword(hashtext);
                }
                adUserPortal.setFullNamel(request.getUserPortal().getFullName());
                adUserPortal.setPhone(request.getUserPortal().getPhone());
                adUserPortal.setEmail(request.getUserPortal().getEmail());
                adUserPortal.setRole(request.getUserPortal().getRole());
                adUserPortal.setStatus(request.getUserPortal().getStatus());
                adUserPortal.setPosition(request.getUserPortal().getPosition());
                adUserPortal.setModifyBy(user);
                adUserPortal.setModifyDate(new Date());

                AdUserPortal addedUser = adUserPortalRepository.save(adUserPortal);
                if (request.getUserBranchList().size() >=1){
                    List<AdBranchUser> adBranchUserList = new ArrayList<>();
                    for (AdBranchUserDto adBranchUserDto : request.getUserBranchList()){
                        AdBranchUser adBranchUser = new AdBranchUser();
                        adBranchUser.setBranchId(adBranchUserDto.getBranchId());
                        adBranchUser.setUserId(addedUser.getUserId());
                        adBranchUser.setModifiedDate(new Date());
                        adBranchUser.setCreatedBy(user);
                        adBranchUserList.add(adBranchUser);
                    }
                    adBranchUserRepository.deleteByUserId(request.getUserPortal().getUserId());
                    adBranchUserRepository.saveAll(adBranchUserList);
                }
                List<SAppTagsUserPortal> sAppTagsUserPortalList = new ArrayList<>();
                if (request.getListTagQnA().size() >=1){
                    for (SAppTagsUserPortalDto sAppTagsUserPortalDto :request.getListTagQnA()){
                        SAppTagsUserPortal appTagsUserPortal = new SAppTagsUserPortal();

                        appTagsUserPortal.setTagId(sAppTagsUserPortalDto.getTagId());
                        appTagsUserPortal.setUserPortalId(addedUser.getUserId());
                        appTagsUserPortal.setCreateBy(user);
                        appTagsUserPortal.setCreateDate(new Date());
                        appTagsUserPortal.setTagType(UserPortalConstant.TAG_TYPE_QNA);
                        appTagsUserPortal.setStatus(UserPortalConstant.STATUS_ACTIVE);

                        sAppTagsUserPortalList.add(appTagsUserPortal);
                    }
                }
                if (request.getListTagNews().size() >=1){
                    for (SAppTagsUserPortalDto sAppTagsUserPortalDto :request.getListTagNews()){
                        SAppTagsUserPortal appTagsUserPortal = new SAppTagsUserPortal();

                        appTagsUserPortal.setTagId(sAppTagsUserPortalDto.getTagId());
                        appTagsUserPortal.setUserPortalId(addedUser.getUserId());
                        appTagsUserPortal.setCreateBy(user);
                        appTagsUserPortal.setCreateDate(new Date());
                        appTagsUserPortal.setTagType(UserPortalConstant.TAG_TYPE_NEWS);
                        appTagsUserPortal.setStatus(UserPortalConstant.STATUS_ACTIVE);

                        sAppTagsUserPortalList.add(appTagsUserPortal);
                    }
                }
                if (request.getListTagKPI().size() >=1){
                    for (SAppTagsUserPortalDto sAppTagsUserPortalDto :request.getListTagKPI()){
                        SAppTagsUserPortal appTagsUserPortal = new SAppTagsUserPortal();

                        appTagsUserPortal.setTagId(sAppTagsUserPortalDto.getTagId());
                        appTagsUserPortal.setUserPortalId(addedUser.getUserId());
                        appTagsUserPortal.setCreateBy(user);
                        appTagsUserPortal.setCreateDate(new Date());
                        appTagsUserPortal.setTagType(UserPortalConstant.TAG_TYPE_KPI);
                        appTagsUserPortal.setStatus(UserPortalConstant.STATUS_ACTIVE);

                        sAppTagsUserPortalList.add(appTagsUserPortal);
                    }
                }
                if (request.getListTagTool().size() >=1){
                    for (SAppTagsUserPortalDto sAppTagsUserPortalDto :request.getListTagTool()){
                        SAppTagsUserPortal appTagsUserPortal = new SAppTagsUserPortal();

                        appTagsUserPortal.setTagId(sAppTagsUserPortalDto.getTagId());
                        appTagsUserPortal.setUserPortalId(addedUser.getUserId());
                        appTagsUserPortal.setCreateBy(user);
                        appTagsUserPortal.setCreateDate(new Date());
                        appTagsUserPortal.setTagType(UserPortalConstant.TAG_TYPE_TOOL);
                        appTagsUserPortal.setStatus(UserPortalConstant.STATUS_ACTIVE);

                        sAppTagsUserPortalList.add(appTagsUserPortal);
                    }
                }
                sAppTagsUserPortalRepository.deleteByUserId(addedUser.getUserId());
                sAppTagsUserPortalRepository.saveAll(sAppTagsUserPortalList);
                return Response.success("update successful");
            }
            else {
                return Response.error(ErrorCode.NOT_FOUND_RECORDS,"user portal is not existed");
            }
        }
        catch (Exception e){
            log.error("updateUserPortal Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }

}
