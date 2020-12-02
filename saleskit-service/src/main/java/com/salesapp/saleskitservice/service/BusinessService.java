package com.salesapp.saleskitservice.service;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.BusinessDto;
import com.salesapp.saleskitservice.model.FilterProductRequest;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BusinessService {
    Page<BusinessDto> search(SearchProductRequest request);

    List<BusinessDto> getSuggestForSearch(String keySearch, Integer size);

    List<BusinessDto> getBusinessMenu(Integer idParent);

    Response getBusinessInfo(Integer id);

    Response filterBusiness(FilterProductRequest request);
}
