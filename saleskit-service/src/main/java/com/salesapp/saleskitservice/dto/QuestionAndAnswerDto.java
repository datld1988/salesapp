package com.salesapp.saleskitservice.dto;

import com.salesapp.saleskitservice.domain.QuestionAndAnswer;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionAndAnswerDto {
    private Integer id;
    private Integer idSP;
    private String ndCauHoi;
    private String ndCauTraLoi;


    public static QuestionAndAnswerDto fromRoot(QuestionAndAnswer questionAndAnswer){
        QuestionAndAnswerDto questionAndAnswerDto = new QuestionAndAnswerDto();
        questionAndAnswerDto.setId(questionAndAnswer.getId());
        questionAndAnswerDto.setIdSP(questionAndAnswer.getIdSP());
        questionAndAnswerDto.setNdCauHoi(questionAndAnswer.getNdCauHoi());
        questionAndAnswerDto.setNdCauTraLoi(questionAndAnswer.getNdCauTraLoi());
        return  questionAndAnswerDto;
    }
}
