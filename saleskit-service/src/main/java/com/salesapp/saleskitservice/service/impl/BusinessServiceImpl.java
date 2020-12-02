package com.salesapp.saleskitservice.service.impl;

import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import com.salesapp.saleskitservice.constant.ProductConst;
import com.salesapp.saleskitservice.domain.Business;
import com.salesapp.saleskitservice.dto.BusinessDto;
import com.salesapp.saleskitservice.dto.ProductPropertiesDto;
import com.salesapp.saleskitservice.model.FilterProductRequest;
import com.salesapp.saleskitservice.model.ProductPropertiesModel;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import com.salesapp.saleskitservice.repository.BusinessPropertiesRepository;
import com.salesapp.saleskitservice.repository.BusinessRepository;
import com.salesapp.saleskitservice.service.BusinessService;
import com.salesapp.saleskitservice.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusinessServiceImpl implements BusinessService {
    private final Logger log = LoggerFactory.getLogger(BusinessServiceImpl.class);

    @Autowired
    BusinessRepository businessRepository;

    @Autowired
    BusinessPropertiesRepository businessPropertiesRepository;

    @Override
    public Page<BusinessDto> search(SearchProductRequest request) {
        return businessRepository.searchBusiness(
                PageRequest.of(request.getPage(), request.getPageSize()),
                request.getKeySearch(), ProductConst.STATUS_ACTIVE
        );
    }

    @Override
    public List<BusinessDto> getSuggestForSearch(String keySearch, Integer size) {
        return businessRepository.searchByName(PageRequest.of(0, size), keySearch, ProductConst.STATUS_ACTIVE).getContent();
    }

    @Override
    public List<BusinessDto> getBusinessMenu(Integer idParent) {
        if (idParent == null || idParent <= 0) {
            idParent = null;
        }
        List<BusinessDto> businessList = businessRepository.findByBusinessParentAndStatusAndIsApprove(
                idParent, ProductConst.STATUS_ACTIVE, ProductConst.APPROVED
        ).stream().map(business -> {
            BusinessDto menu = BusinessDto.fromRoot(business);
            // if (business.getBusinessParent() != null) {
                List<BusinessDto> childes = getBusinessChild(business.getId());
                if (childes.size() > 0) {
                    if (childes.get(0).getChild() > 0) {
                        menu.setChild(1);
                    } else {
                        menu.setChild(0);
                    }
                } else {
                    menu.setChild(0);
                }
//            } else {
//                menu.setChild(1);
//            }
            return menu;
        }).collect(Collectors.toList());

        return businessList;
    }

    @Override
    public Response getBusinessInfo(Integer id) {
        List<ProductPropertiesDto> result = new ArrayList<ProductPropertiesDto>();
        try {
            Optional<Business> pro = businessRepository.findById(id);
            if(pro.isPresent()) {
                ProductPropertiesDto dto = new ProductPropertiesDto();
                dto.setProductId(pro.get().getId());
                dto.setProductName(pro.get().getName());
                dto.setImage1(pro.get().getImage1());
                dto.setImage2(pro.get().getImage2());
                List<ProductPropertiesModel> lstProp =  businessPropertiesRepository.getBusinessInfo(id, 1);
                dto.setLstProp(lstProp);
                result.add(dto);
            }

            return Response.success(result);
        } catch (Exception e) {
            log.error("getBusinessInfo Exception : "+e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }

    @Override
    public Page<BusinessDto> filterBusiness(FilterProductRequest request) {
        Date fromParse = StringUtil.convertStringToDate(request.getFromDate());
        Date toDate = StringUtil.convertStringToDate(request.getToDate());
        Page<BusinessDto> listBusinessPage = businessRepository.filterBusiness(
                PageRequest.of(request.getPage(), request.getPageSize())
                , fromParse, toDate, request.getMenuId(), ProductConst.STATUS_ACTIVE);
        return listBusinessPage;
    }

    private List<BusinessDto> getBusinessChild(Integer id) {
        return businessRepository.checkProductOnSearch(id, ProductConst.STATUS_ACTIVE, ProductConst.APPROVED);
    }
}
