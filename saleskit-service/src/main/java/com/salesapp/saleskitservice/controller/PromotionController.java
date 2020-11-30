package com.salesapp.saleskitservice.controller;

import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import com.uniform.common.dto.Response;
import com.salesapp.saleskitservice.model.*;
import com.salesapp.saleskitservice.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @RequestMapping(path = "list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<PromotionListResponse> getPromotionList(@RequestBody PromotionListRequest request) {
        ApiResultResponse<PromotionListResponse> response = new ApiResultResponse<>();
        PromotionListResponse data = new PromotionListResponse();
        if(request.getIdSP() == -1){
            Page<PromotionDto> pagePromotion = promotionService.listAllPromotion(request);
            data.setPromotionList(pagePromotion.getContent());
            data.setIsNextPage(pagePromotion.getNumber() +1 < pagePromotion.getTotalPages());
        }
        else{
            Page<PromotionDto> pagePromotion = promotionService.filterPromotion(request);
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
    @RequestMapping(path = "detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<PromotionDto> getPromotionByID(@RequestParam("id") Integer promotionId) {
        ApiResultResponse<PromotionDto> response = new ApiResultResponse<>();
        PromotionDto promotionDetail = promotionService.getPromotionByID(promotionId);
        if (promotionDetail == null){
            response.setResponseCode("000");
            response.setResponseMessage("Failed");
        }
        else {
            response.setResponseCode("000");
            response.setResponseMessage("Success");
            response.setData(promotionDetail);
        }
        return response;
    }
}
