package com.salesapp.saleskitservice.service.impl;

import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import com.salesapp.saleskitservice.model.FilterQuestionAndAnswerRequest;
import com.salesapp.saleskitservice.repository.QuestionAndAnswerRepository;
import com.salesapp.saleskitservice.service.QuestionAndAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {

    @Autowired
        private QuestionAndAnswerRepository questionAndAnswerRepository;

    @Override
    public Page<QuestionAndAnswerDto> filterQuestionAndAnswer(FilterQuestionAndAnswerRequest request) {
        Page<QuestionAndAnswerDto> listQuestionAndAnswer = questionAndAnswerRepository.filterQuestionAndAnswer(
                PageRequest.of(request.getPage(), request.getPerPage()), request.getIdSP(), request.getKeyword());
        return listQuestionAndAnswer;
    }
}
