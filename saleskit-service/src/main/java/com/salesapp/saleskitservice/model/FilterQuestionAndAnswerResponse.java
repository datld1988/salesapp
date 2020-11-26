package com.salesapp.saleskitservice.model;

import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterQuestionAndAnswerResponse {
    private List<QuestionAndAnswerDto> qaList;
    private Boolean isNextPage;
}
