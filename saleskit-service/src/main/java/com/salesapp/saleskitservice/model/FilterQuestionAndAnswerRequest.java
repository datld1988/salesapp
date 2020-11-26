package com.salesapp.saleskitservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterQuestionAndAnswerRequest {
    private String keyword;
    private Integer page;
    private Integer perPage;
}
