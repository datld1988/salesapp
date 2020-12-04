package com.salesapp.adminservice.service.impl;

import com.salesapp.adminservice.constant.RoleConstant;
import com.salesapp.adminservice.domain.*;
import com.salesapp.adminservice.dto.AdRoleDto;
import com.salesapp.adminservice.dto.AdRoleMenuDto;
import com.salesapp.adminservice.dto.AdRoleRightDto;
import com.salesapp.adminservice.models.AssignUserRoleRequest;
import com.salesapp.adminservice.models.SaveRoleRequest;
import com.salesapp.adminservice.repository.AdRoleMenuRepository;
import com.salesapp.adminservice.repository.AdRoleRepository;
import com.salesapp.adminservice.repository.AdRoleRightRepository;
import com.salesapp.adminservice.repository.AdUserRoleRepository;
import com.salesapp.adminservice.service.RoleService;
import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private AdRoleRepository adRoleRepository;

    @Autowired
    private AdRoleMenuRepository adRoleMenuRepository;

    @Autowired
    private AdRoleRightRepository adRoleRightRepository;

    @Autowired
    private AdUserRoleRepository adUserRoleRepository;

    @Override
    public Response searchRole(String keySearch) {
        try {
            List<AdRoleDto> listRole = adRoleRepository.searchRole(keySearch);
            if (!listRole.isEmpty()) {
                return Response.success(listRole);
            } else {
                return Response.error(ErrorCode.NOT_FOUND_RECORDS, "No record was found");
            }

        } catch (Exception e) {
            log.error("searchRole Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }


    }

    @Override
    @Transactional
    public Response insertRole(SaveRoleRequest request) {
        AdRole role = new AdRole();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            Optional<AdRole> checkRole = adRoleRepository.findById(request.getRoleInfo().getId());
            if (!checkRole.isPresent()) {
            role.setRoleName(request.getRoleInfo().getName());
            role.setDescription(request.getRoleInfo().getDescription());
            role.setId(request.getRoleInfo().getId());
            role.setStatusCode(RoleConstant.STRING_STATUS_ACTIVE);
            role.setCreatedDate(new Date());
            role.setCreatedBy(user);
            AdRole addedRole = adRoleRepository.save(role);
            if (request.getMenuList().size() >= 1) {
                List<AdRoleMenu> adRoleMenuList = new ArrayList<>();
                for (AdRoleMenuDto menu : request.getMenuList()) {
                    AdRoleMenu adRoleMenu = new AdRoleMenu();
                    adRoleMenu.setMenuId(menu.getMenuId());
                    adRoleMenu.setRoleId(addedRole.getId());
                    adRoleMenu.setStatus(RoleConstant.STRING_STATUS_ACTIVE);
                    adRoleMenu.setCreateDate(new Date());
                    adRoleMenu.setCreateBy(user);
                    adRoleMenuList.add(adRoleMenu);
                }
                adRoleMenuRepository.saveAll(adRoleMenuList);
            }
            if (request.getRightList().size() >= 1) {
                List<AdRoleRight> adRoleRightList = new ArrayList<>();
                for (AdRoleRightDto right : request.getRightList()) {
                    AdRoleRight adRoleRight = new AdRoleRight();
                    adRoleRight.setRightId(right.getRightId());
                    adRoleRight.setRoleId(addedRole.getId());
                    adRoleRight.setCreatedBy(user);
                    adRoleRight.setCreatedDate(new Date());
                    adRoleRightList.add(adRoleRight);
                }
                adRoleRightRepository.saveAll(adRoleRightList);
            }
            return Response.success("Add successful");
            }
            else {
                return Response.error("408", "Record existed");
            }
        } catch (Exception e) {
            log.error("insertRole Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }

    @Override
    @Transactional
    public Response updateRole(SaveRoleRequest request) {
        AdRole role = new AdRole();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            Optional<AdRole> checkRole = adRoleRepository.findById(request.getRoleInfo().getId());
            if (checkRole.isPresent()) {
                role.setRoleName(request.getRoleInfo().getName());
                role.setDescription(request.getRoleInfo().getDescription());
                role.setId(request.getRoleInfo().getId());
                role.setStatusCode(RoleConstant.STRING_STATUS_ACTIVE);
                role.setModifiedDate(new Date());
                role.setModifiedBy(user);
                AdRole addedRole = adRoleRepository.save(role);
                if (request.getMenuList().size() >= 1) {
                    List<AdRoleMenu> adRoleMenuList = new ArrayList<>();
                    for (AdRoleMenuDto menu : request.getMenuList()) {
                        AdRoleMenu adRoleMenu = new AdRoleMenu();
                        adRoleMenu.setMenuId(menu.getMenuId());
                        adRoleMenu.setRoleId(addedRole.getId());
                        adRoleMenu.setStatus(menu.getStatus());
                        AdRoleMenuId adRoleMenuId = new AdRoleMenuId();
                        adRoleMenuId.setRoleId(menu.getRoleId());
                        adRoleMenuId.setMenuId(menu.getMenuId());
                        Optional<AdRoleMenu> checkRoleMenu = adRoleMenuRepository.findById(adRoleMenuId);

                            adRoleMenu.setModifyDate(new Date());
                            adRoleMenu.setModifyBy(user);

                        adRoleMenuList.add(adRoleMenu);
                    }
                    adRoleMenuRepository.deleteByRoleKey(addedRole.getId());
                    adRoleMenuRepository.saveAll(adRoleMenuList);
                }
                if (request.getRightList().size() >= 1) {
                    List<AdRoleRight> adRoleRightList = new ArrayList<>();
                    for (AdRoleRightDto right : request.getRightList()) {
                        AdRoleRight adRoleRight = new AdRoleRight();
                        adRoleRight.setRightId(right.getRightId());
                        adRoleRight.setRoleId(addedRole.getId());
                        AdRoleRightId adRoleRightId = new AdRoleRightId();
                        adRoleRightId.setRightId(right.getRightId());
                        adRoleRightId.setRoleId(right.getRoleId());
                        Optional<AdRoleRight> checkRoleRight = adRoleRightRepository.findById(adRoleRightId);

                            adRoleRight.setModifiedBy(user);
                            adRoleRight.setModifiedDate(new Date());


                        adRoleRightList.add(adRoleRight);
                    }
                    adRoleRightRepository.deleteByRoleKey(addedRole.getId());
                    adRoleRightRepository.saveAll(adRoleRightList);
                }
                return Response.success("Update successful");
            } else {
                return Response.error(ErrorCode.NOT_FOUND_RECORDS, "Not found record");
            }

        } catch (Exception e) {
            log.error("updateRole Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }

    @Override
    @Transactional
    public Response deleteRole(String id) {
        try {
            Optional<AdRole> role = adRoleRepository.findById(id);
            if (role.isPresent()) {
                AdRole adRole = role.get();
                adRole.setStatusCode(RoleConstant.STRING_STATUS_INACTIVE);
                adRoleRepository.save(adRole);
                return Response.success("Delete Successful");
            } else {
                return Response.error(ErrorCode.NOT_FOUND_RECORDS, "Not found record");
            }

        } catch (Exception e) {
            log.error("deleteRole Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }

    @Override
    @Transactional
    public Response assignUserRole(AssignUserRoleRequest request) {
        try {
            String user = SecurityContextHolder.getContext().getAuthentication().getName();
            if (!request.getRoleList().isEmpty()) {
                List<AdUserRole> adUserRoleList = new ArrayList<>();
                for (AdRoleDto adRoleDto : request.getRoleList()) {
                    AdUserRole adUserRole = new AdUserRole();
                    adUserRole.setUserId(request.getUserInfo().getId());
                    adUserRole.setStatus(RoleConstant.INT_STATUS_ACTIVE);
                    adUserRole.setCreateDate(new Date());
                    adUserRole.setCreateBy(user);
                    adUserRole.setRoleId(adRoleDto.getId());
                    adUserRoleList.add(adUserRole);
                }
                adUserRoleRepository.deleteByUserId(request.getUserInfo().getId());
                adUserRoleRepository.saveAll(adUserRoleList);
                return Response.success("Assign successful");
            } else {
                return Response.error(ErrorCode.SERVICE_ERROR, "Assign failed");
            }

        } catch (Exception e) {
            log.error("assignUserRole Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }
}
