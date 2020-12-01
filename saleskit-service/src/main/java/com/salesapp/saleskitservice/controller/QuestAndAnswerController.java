package com.salesapp.saleskitservice.controller;

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

    @RequestMapping(path = "qna", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<FilterQuestionAndAnswerResponse> filterQuestionAndAnswer(@RequestBody FilterQuestionAndAnswerRequest request) {
        ApiResultResponse<FilterQuestionAndAnswerResponse> response = new ApiResultResponse<>();
        FilterQuestionAndAnswerResponse data = new FilterQuestionAndAnswerResponse();
        Page<QuestionAndAnswerDto> pageQuestionAndAnswer = questionAndAnswerService.filterQuestionAndAnswer(request);
        response.setResponseCode("000");
        response.setResponseMessage("Success");
        data.setQaList(pageQuestionAndAnswer.getContent());
        data.setIsNextPage(pageQuestionAndAnswer.getNumber() + 1 < pageQuestionAndAnswer.getTotalPages());
        response.setData(data);
        return response;
    }
}
