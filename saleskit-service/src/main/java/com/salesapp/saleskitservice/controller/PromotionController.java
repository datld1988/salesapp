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

    /**
     * author: anhld
     * lấy ra danh sách chương trình khuyến mại theo yêu cầu của client
     * @param
     * return: danh sách các chương trình khuyến mại
     */
    @RequestMapping(path = "list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<PromotionListResponse> getPromotionList(@RequestBody PromotionListRequest request) {
        return promotionService.getPromotion(request);
    }

    /**
     * author: anhld
     * lấy ra chương trình khuyến mại theo id
     * @param
     * return: lấy ra chương trình khuyến mại theo id
     */
    @RequestMapping(path = "detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<PromotionDto> getPromotionByID(@RequestParam("id") Integer promotionId) {
        return promotionService.getPromotionByID(promotionId);
    }
}
