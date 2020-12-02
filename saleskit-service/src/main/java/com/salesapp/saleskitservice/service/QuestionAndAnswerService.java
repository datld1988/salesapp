package com.salesapp.saleskitservice.service;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import com.salesapp.saleskitservice.model.FilterQuestionAndAnswerRequest;
import com.salesapp.saleskitservice.model.FilterQuestionAndAnswerResponse;
import org.springframework.data.domain.Page;

public interface QuestionAndAnswerService {
    Response<FilterQuestionAndAnswerResponse> filterQuestionAndAnswer(FilterQuestionAndAnswerRequest request);

}
