package com.salesapp.adminservice.service.impl;

import com.salesapp.adminservice.constant.UserPortalConstant;
import com.salesapp.adminservice.domain.AdBranchUser;
import com.salesapp.adminservice.domain.AdUserPortal;
import com.salesapp.adminservice.domain.SAppTagsUserPortal;
import com.salesapp.adminservice.dto.AdBranchUserDto;
import com.salesapp.adminservice.dto.AdUserPortalDto;
import com.salesapp.adminservice.dto.SAppTagsUserPortalDto;
import com.salesapp.adminservice.models.*;
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
    @Transactional
    @Override
    public Response createAdUserPortal(CreateUserPortalRequest request) {
        AdUserPortal adUserPortal = new AdUserPortal();
        boolean passwordIsNull = false;
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            Optional<AdUserPortal> checkUser = adUserPortalRepository.findById(request.getUserPortal().getUserId());
            if (!checkUser.isPresent()){
                adUserPortal.setUserId(request.getUserPortal().getUserId());
                if (request.getUserPortal().getPassword()== null || request.getUserPortal().getPassword().isEmpty() ||
                        request.getUserPortal().getPassword().contains(" ")){
                    passwordIsNull = true;
                }
                else {
                    //encrypt password with md5
                    byte[] messageDigest  = md.digest(request.getUserPortal().getPassword().getBytes());
                    BigInteger bigInt  = new BigInteger(1, messageDigest);
                    String hashtext = bigInt.toString(16);
                    while (hashtext.length() < 32) {
                        hashtext = "0" + hashtext;
                    }
                    adUserPortal.setPassword(hashtext);
                }
                if (!passwordIsNull){
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
                    return Response.error(ErrorCode.BAD_REQUEST,"password can't be blank, null or contain space");
                }
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
    public Response filterUserPortal(FilterUserPortalRequest request) {
        try{
            List<AdUserPortalDto> adUserPortalDtoList = adUserPortalRepository.filterUserPortal(
                    request.getKeyword(), request.getRole(), request.getStatus());
            List<FilterUserPortalResponse> allUserResponseList = new ArrayList<>();
            if (adUserPortalDtoList.size() >=1){
                for (AdUserPortalDto adUserPortalDto : adUserPortalDtoList){
                    FilterUserPortalResponse filterUserPortalResponse = new FilterUserPortalResponse();
                    List<AdBranchUserDto> branchUserDtoList =
                            adBranchUserRepository.getBranchOfUser(adUserPortalDto.getUserId());
                    filterUserPortalResponse.setListBranch(branchUserDtoList);
                    filterUserPortalResponse.setUserPortal(adUserPortalDto);
                    allUserResponseList.add(filterUserPortalResponse);
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
    public Response updateUserPortal(UpdateUserPortalRequest request) {
        AdUserPortal adUserPortal = new AdUserPortal();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean passwordIsNull = false;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            Optional<AdUserPortal> checkUser = adUserPortalRepository.findById(request.getUserPortal().getUserId());
            if (checkUser.isPresent()){
                adUserPortal.setUserId(request.getUserPortal().getUserId());
                adUserPortal.setPassword(checkUser.get().getPassword());
                if (request.getIsChangePassword()==1){
                    if (request.getUserPortal().getPassword()== null || request.getUserPortal().getPassword().isEmpty() ||
                     request.getUserPortal().getPassword().contains(" ")){
                        passwordIsNull = true;
                    }
                    else {
                        //encrypt password with md5
                        byte[] messageDigest  = md.digest(request.getUserPortal().getPassword().getBytes());
                        BigInteger bigInt  = new BigInteger(1, messageDigest);
                        String hashtext = bigInt.toString(16);
                        while (hashtext.length() < 32) {
                            hashtext = "0" + hashtext;
                        }
                        adUserPortal.setPassword(hashtext);
                    }
                }
            if (!passwordIsNull){
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
                        adBranchUser.setModifiedBy(user);
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
                        appTagsUserPortal.setModifyBy(user);
                        appTagsUserPortal.setModifyDate(new Date());
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
                        appTagsUserPortal.setModifyBy(user);
                        appTagsUserPortal.setModifyDate(new Date());
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
                        appTagsUserPortal.setModifyBy(user);
                        appTagsUserPortal.setModifyDate(new Date());
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
                        appTagsUserPortal.setModifyBy(user);
                        appTagsUserPortal.setModifyDate(new Date());
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
                return Response.error(ErrorCode.BAD_REQUEST,"password can't be blank, null or contain space");
            }
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
    /**
     * author: anhld
     * date: 9/12/2020
     * lấy thông tin chi tiết của user portal
     * @param id: id của user portal
     * @return: thông tin chi tiết của user portal
     */
    @Override
    public Response getUserPortalDetail(String id) {
        try{
            Optional<AdUserPortal> checkUser = adUserPortalRepository.findById(id);
            if (checkUser.isPresent()){

                GetUserPortalDetailResponse getUserPortalDetailResponse= new GetUserPortalDetailResponse();
                AdUserPortalDto adUserPortalDto = new AdUserPortalDto();

                adUserPortalDto.setFullName(checkUser.get().getFullNamel());
                adUserPortalDto.setEmail(checkUser.get().getEmail());
                adUserPortalDto.setUserId(checkUser.get().getUserId());
                adUserPortalDto.setRole(checkUser.get().getRole());
                adUserPortalDto.setStatus(checkUser.get().getStatus());
                adUserPortalDto.setPhone(checkUser.get().getPhone());
                adUserPortalDto.setPosition(checkUser.get().getPosition());

                List<SAppTagsUserPortalDto> listTagsOfUser= sAppTagsUserPortalRepository.findTagsUserPortalByUserId(checkUser.get().getUserId());
                List<SAppTagsUserPortalDto> listTagQnA = new ArrayList<>();
                List<SAppTagsUserPortalDto> listTagNews = new ArrayList<>();
                List<SAppTagsUserPortalDto> listTagKPI = new ArrayList<>();
                List<SAppTagsUserPortalDto> listTagTool = new ArrayList<>();

                if (listTagsOfUser.size()>=1){
                    for (SAppTagsUserPortalDto tagsUserPortalDto : listTagsOfUser){
                        if (tagsUserPortalDto.getTagType().equals("NEWS")){
                            listTagNews.add(tagsUserPortalDto);
                        }
                        else if (tagsUserPortalDto.getTagType().equals("TOOL")){
                            listTagTool.add(tagsUserPortalDto);
                        }
                        else if (tagsUserPortalDto.getTagType().equals("QNA")){
                            listTagQnA.add(tagsUserPortalDto);
                        }
                        else if (tagsUserPortalDto.getTagType().equals("KPI")){
                            listTagKPI.add(tagsUserPortalDto);
                        }
                    }
                }

                getUserPortalDetailResponse.setUserPortal(adUserPortalDto);
                getUserPortalDetailResponse.setUserBranchList(adBranchUserRepository.getBranchOfUser(id));
                getUserPortalDetailResponse.setListTagKPI(listTagKPI);
                getUserPortalDetailResponse.setListTagNews(listTagNews);
                getUserPortalDetailResponse.setListTagQnA(listTagQnA);
                getUserPortalDetailResponse.setListTagTool(listTagTool);

                return Response.success(getUserPortalDetailResponse);
            }
            else {
                return Response.error(ErrorCode.NOT_FOUND_RECORDS,"user portal is not existed");
            }
        }
        catch (Exception e){
            log.error("getUserPortalDetail Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }

}
