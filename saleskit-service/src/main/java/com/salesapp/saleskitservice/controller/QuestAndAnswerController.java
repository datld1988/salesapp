package com.salesapp.saleskitservice.controller;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import com.salesapp.saleskitservice.model.*;

import com.salesapp.saleskitservice.service.QuestionAndAnswerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "qna")
public class QuestAndAnswerController {

    @Autowired
    private QuestionAndAnswerService questionAndAnswerService;
    /**
     * author: anhld
     * date : 26/11/2020
     * lấy danh sách QnA của sản phẩm đã chọn, bao gồm cả tìm kiếm
     * @param :
     * @return : danh sách QnA
     */
    @RequestMapping(path = "qna", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response<FilterQuestionAndAnswerResponse> filterQuestionAndAnswer(@RequestBody FilterQuestionAndAnswerRequest request) {
        return questionAndAnswerService.filterQuestionAndAnswer(request);
    }
}
