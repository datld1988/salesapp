package com.salesapp.saleskitservice.controller;

import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import com.salesapp.saleskitservice.model.*;

import com.salesapp.saleskitservice.service.QuestionAndAnswerService;

import com.uniform.common.dto.Response;
import com.uniform.common.utils.ErrorCode;
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
     * create date : 26/11/2020
     * lấy danh sách các câu hỏi, trả lời của câu hỏi đã chọn
     * @param
     * @return danh sách các câu hỏi, trả lời
     */
    @RequestMapping(path = "qna", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response<FilterQuestionAndAnswerResponse> filterQuestionAndAnswer(@RequestBody FilterQuestionAndAnswerRequest request) {
        FilterQuestionAndAnswerResponse data = new FilterQuestionAndAnswerResponse();
        Page<QuestionAndAnswerDto> pageQuestionAndAnswer = questionAndAnswerService.filterQuestionAndAnswer(request);
        data.setQaList(pageQuestionAndAnswer.getContent());
        data.setIsNextPage(pageQuestionAndAnswer.getNumber() + 1 < pageQuestionAndAnswer.getTotalPages());
        if(data.getQaList().size()==0){
            return  Response.error(ErrorCode.NOT_FOUND_RECORDS,"không tìm thấy câu hỏi");
        }
        else {
            return Response.success(data);
        }

    }
}
