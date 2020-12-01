package com.salesapp.saleskitservice.service;

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
     * lấy ra tất cả các chương trình khuyến mại
     * @param
     *
     */
    Page<PromotionDto> listAllPromotion(PromotionListRequest request);
    /**
     * author: anhld
     * lấy ra các chương trình khuyến mại theo loại khách hàng đã chọn
     * @param
     *
     */
    Page<PromotionDto> filterPromotion(PromotionListRequest request);
    /**
     * author: anhld
     * lấy ra chương trình khuyến mại theo id
     * @param
     *
     */
    ApiResultResponse<PromotionDto> getPromotionByID(Integer id);
    /**
     * author: anhld
     * phân chức năng cho controller
     * @param
     *
     */
    ApiResultResponse<PromotionListResponse> getPromotion(PromotionListRequest request);
}
