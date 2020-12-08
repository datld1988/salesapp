package com.salesapp.adminservice.service.impl;

import com.salesapp.adminservice.dto.AdBranchDto;
import com.salesapp.adminservice.repository.AdBranchRepository;
import com.salesapp.adminservice.repository.AdUserPortalRepository;
import com.salesapp.adminservice.service.AdBranchService;
import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdBranchServiceImpl implements AdBranchService {
    private final Logger log = LoggerFactory.getLogger(AdBranchServiceImpl.class);
    @Autowired
    private AdBranchRepository adBranchRepository;
    @Override
    public Response getAllBranch() {
        try{
            List<AdBranchDto> listBranch= adBranchRepository.getBranchList();
            if (listBranch.size()>=1){
                return Response.success(listBranch);
            }
            else {
                return Response.error(ErrorCode.NOT_FOUND_RECORDS, "no record found");
            }
        }
        catch (Exception e){
            log.error("getAllBranch Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }
}
