package com.salesapp.saleskitservice.service.impl;

import com.salesapp.saleskitservice.constant.ProductConst;
import com.salesapp.saleskitservice.dto.BusinessDto;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import com.salesapp.saleskitservice.repository.BusinessRepository;
import com.salesapp.saleskitservice.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessRepository businessRepository;

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
}
