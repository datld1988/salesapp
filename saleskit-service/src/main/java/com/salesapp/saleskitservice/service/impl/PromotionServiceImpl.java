package com.salesapp.saleskitservice.service.impl;

import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import com.salesapp.saleskitservice.constant.ProductConst;
import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.model.ApiResultResponse;
import com.salesapp.saleskitservice.model.PromotionListRequest;
import com.salesapp.saleskitservice.model.PromotionListResponse;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import com.salesapp.saleskitservice.repository.PromotionRepository;
import com.salesapp.saleskitservice.repository.QuestionAndAnswerRepository;
import com.salesapp.saleskitservice.service.PromotionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {
    private final Logger log = LoggerFactory.getLogger(PromotionServiceImpl.class);
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
     * @param :
     * @return : danh sách các chương trình khuyến mại
     */
    @Override
    public Response<PromotionListResponse> filterPromotion(PromotionListRequest request){
        PromotionListResponse data = new PromotionListResponse();
        Page<PromotionDto> pagePromotion;
        try{
            if(request.getIdSP() == -1){
                pagePromotion = promotionRepository.listAllPromotion(PageRequest.of(request.getPage(),
                        request.getPerPage()), 1);
            }
            else{
                pagePromotion = promotionRepository.filterPromotion(PageRequest.of(request.getPage(),
                        request.getPerPage()), request.getIdSP(), 1);
            }
            data.setPromotionList(pagePromotion.getContent());
            data.setIsNextPage(pagePromotion.getNumber() +1 < pagePromotion.getTotalPages());
            if (data.getPromotionList().isEmpty()){
                return Response.error(ErrorCode.NOT_FOUND_RECORDS, "No record was found");
            }
            else {
                return  Response.success(data);
            }

        }
        catch (Exception e){
            log.error("filterPromotion Exception : "+e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }

    }
    /**
     * author: anhld
     * chi tiết chương trình khuyến mại theo id
     * @param id : id của chương trình khuyến mại
     * @return : chương trình khuyến mại
     */
    @Override
    public Response<PromotionDto> getPromotionByID(Integer id){
        try{
            PromotionDto promotionDetail = promotionRepository.getPromotionByID(id);
            return  Response.success(promotionDetail);
        }
        catch (Exception e){
            log.error("getPromotionByID Exception : "+e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }

    }

}
