package com.salesapp.saleskitservice.controller;

import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;

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

    /**
     * author: anhld
     * date : 28/11/2020
     * lấy danh sách khuyến mãi
     * @param
     * @return danh sách khuyến mãi
     */
    @RequestMapping(path = "list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<PromotionListResponse> getPromotionList(@RequestBody PromotionListRequest request) {
        return promotionService.getPromotion(request);
    }

    /**
     * author: anhld
     * date : 28/11/2020
     * lấy thông tin chi tiết của chương trình khuyến mãi
     * @param promotionId : mã chương trình khuyến mãi
     * @return thông tin chi tiết của chương trình khuyến mãi
     */
    @RequestMapping(path = "detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<PromotionDto> getPromotionByID(@RequestParam("id") Integer promotionId) {
        return promotionService.getPromotionByID(promotionId);
    }
}
