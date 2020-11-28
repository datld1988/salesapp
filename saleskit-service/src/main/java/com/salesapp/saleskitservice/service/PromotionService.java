package com.salesapp.saleskitservice.service;

import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import org.springframework.data.domain.Page;

public interface PromotionService {
    Page<PromotionDto> search(SearchProductRequest request);
}
