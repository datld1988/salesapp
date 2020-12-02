package com.salesapp.saleskitservice.service;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.model.ApiResultResponse;
import com.salesapp.saleskitservice.model.PromotionListRequest;
import com.salesapp.saleskitservice.model.PromotionListResponse;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PromotionService {
    Page<PromotionDto> search(SearchProductRequest request);

    List<PromotionDto> getSuggestForSearch(String keySearch, Integer size);
    /**
     * author: anhld
     * lấy ra các chương trình khuyến mại theo loại khách hàng đã chọn
     * @param
     *
     */
    Response<PromotionListResponse> filterPromotion(PromotionListRequest request);
    /**
     * author: anhld
     * lấy ra chi tiết chương trình khuyến mại theo id
     * @param
     *
     */
    Response<PromotionDto> getPromotionByID(Integer id);
}
