package com.salesapp.saleskitservice.service;

import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import com.salesapp.saleskitservice.model.FilterQuestionAndAnswerRequest;
import org.springframework.data.domain.Page;

public interface QuestionAndAnswerService {
    /**
     * author : anhld
     * date : 26/11/2020
     * filterQuestionAndAnswer
     * @param request
     * @return
     */
    Page<QuestionAndAnswerDto> filterQuestionAndAnswer(FilterQuestionAndAnswerRequest request);

}
