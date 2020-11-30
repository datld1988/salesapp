package com.salesapp.saleskitservice.model;

import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PromotionListResponse {
    private List<PromotionDto> promotionList;
    private Boolean isNextPage;
}
