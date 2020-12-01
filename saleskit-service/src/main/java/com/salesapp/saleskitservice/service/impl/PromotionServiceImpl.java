package com.salesapp.saleskitservice.service.impl;

import com.salesapp.saleskitservice.constant.ProductConst;
import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.model.ApiResultResponse;
import com.salesapp.saleskitservice.model.PromotionListRequest;
import com.salesapp.saleskitservice.model.PromotionListResponse;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import com.salesapp.saleskitservice.repository.PromotionRepository;
import com.salesapp.saleskitservice.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    PromotionRepository promotionRepository;

    @Override
    public Page<PromotionDto> search(SearchProductRequest request) {
        return promotionRepository.searchPromotion(
                PageRequest.of(request.getPage(), request.getPageSize()),
                request.getKeySearch(), ProductConst.STATUS_ACTIVE
        );
    }

    @Override
    public List<PromotionDto> getSuggestForSearch(String keySearch, Integer size) {
        return promotionRepository.searchByName(PageRequest.of(0, size), keySearch, ProductConst.STATUS_ACTIVE).getContent();
    }
    /**
     * author: anhld
     * lấy ra danh sách các chương trình khuyến mại của loại khách hàng đã chọn
     * @param
     * return: danh sách các chương trình khuyến mại của loại khách hàng đã chọn
     */
    @Override
    public Page<PromotionDto> filterPromotion(PromotionListRequest request){
        return  promotionRepository.filterPromotion(PageRequest.of(request.getPage(), request.getPerPage()), request.getIdSP(), 1);
    }
    /**
     * author: anhld
     * lấy ra danh sách tất cả chương trình khuyến mại
     * @param
     * return: danh sách tất cả các chương trình khuyến mại
     */
    @Override
    public Page<PromotionDto> listAllPromotion(PromotionListRequest request){
        return  promotionRepository.listAllPromotion(PageRequest.of(request.getPage(), request.getPerPage()), 1);
    }
    /**
     * author: anhld
     * tìm kiếm chương trình khuyến mại theo id
     * @param
     * return: chương trình khuyến mại
     */
    @Override
    public ApiResultResponse<PromotionDto> getPromotionByID(Integer id){
        ApiResultResponse<PromotionDto> response = new ApiResultResponse<>();
        PromotionDto promotionDetail = promotionRepository.getPromotionByID(id);
        if (promotionDetail == null){
            response.setResponseCode("000");
            response.setResponseMessage("Failed");
        }
        else {
            response.setResponseCode("000");
            response.setResponseMessage("Success");
            response.setData(promotionDetail);
        }

        return  response;
    }
    /**
     * author: anhld
     * phân luồng cho controller
     * @param
     * return: khối data tùy theo yêu cầu của client
     */
    @Override
    public ApiResultResponse<PromotionListResponse> getPromotion(PromotionListRequest request){
        ApiResultResponse<PromotionListResponse> response = new ApiResultResponse<>();
        PromotionListResponse data = new PromotionListResponse();
        if(request.getIdSP() == -1){
            Page<PromotionDto> pagePromotion = listAllPromotion(request);
            data.setPromotionList(pagePromotion.getContent());
            data.setIsNextPage(pagePromotion.getNumber() +1 < pagePromotion.getTotalPages());
        }
        else{
            Page<PromotionDto> pagePromotion = filterPromotion(request);
            data.setPromotionList(pagePromotion.getContent());
            data.setIsNextPage(pagePromotion.getNumber() +1 < pagePromotion.getTotalPages());
        }
        if (data.getPromotionList().isEmpty()){
            response.setResponseCode("000");
            response.setResponseMessage("Failed");
        }
        else {
            response.setResponseCode("000");
            response.setResponseMessage("Success");
            response.setData(data);
        }
        return response;
    }
}
