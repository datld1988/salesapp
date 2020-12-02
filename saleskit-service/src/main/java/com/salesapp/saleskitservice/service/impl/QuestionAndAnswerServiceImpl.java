package com.salesapp.saleskitservice.service.impl;

import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import com.salesapp.saleskitservice.model.FilterQuestionAndAnswerRequest;
import com.salesapp.saleskitservice.model.FilterQuestionAndAnswerResponse;
import com.salesapp.saleskitservice.repository.QuestionAndAnswerRepository;
import com.salesapp.saleskitservice.service.QuestionAndAnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {
    private final Logger log = LoggerFactory.getLogger(QuestionAndAnswerServiceImpl.class);
    @Autowired
        private QuestionAndAnswerRepository questionAndAnswerRepository;
    /**
     * author: anhld
     * date : 26/11/2020
     * @param
     * @return danh sách các câu hỏi và trả lời
     */
    @Override
    public Response<FilterQuestionAndAnswerResponse> filterQuestionAndAnswer(FilterQuestionAndAnswerRequest request) {
        try{
            Page<QuestionAndAnswerDto> listQuestionAndAnswer = questionAndAnswerRepository.filterQuestionAndAnswer(
                    PageRequest.of(request.getPage(), request.getPerPage()), request.getIdSP(), request.getKeyword());
        FilterQuestionAndAnswerResponse data = new FilterQuestionAndAnswerResponse();
        data.setQaList(listQuestionAndAnswer.getContent());
        data.setIsNextPage(listQuestionAndAnswer.getNumber() + 1 < listQuestionAndAnswer.getTotalPages());
        if(data.getQaList().isEmpty()){
            return Response.error(ErrorCode.NOT_FOUND_RECORDS, "No record was found");
        }
        else {
            return Response.success(data);
        }

        }
        catch (Exception e){
            log.error("filterQuestionAndAnswer Exception : "+e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }
}
