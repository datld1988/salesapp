package com.salesapp.saleskitservice.service;

import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import com.salesapp.saleskitservice.model.FilterQuestionAndAnswerRequest;
import org.springframework.data.domain.Page;

public interface QuestionAndAnswerService {
    Page<QuestionAndAnswerDto> filterQuestionAndAnswer(FilterQuestionAndAnswerRequest request);

}
