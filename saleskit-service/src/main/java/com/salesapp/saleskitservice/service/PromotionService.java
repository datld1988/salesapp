package com.salesapp.saleskitservice.service;

import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.model.PromotionListRequest;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PromotionService {
    Page<PromotionDto> search(SearchProductRequest request);

    List<PromotionDto> getSuggestForSearch(String keySearch, Integer size);

    Page<PromotionDto> listAllPromotion(PromotionListRequest request);

    Page<PromotionDto> filterPromotion(PromotionListRequest request);

    PromotionDto getPromotionByID(Integer id);
}
