package com.salesapp.saleskitservice.model;

import com.salesapp.saleskitservice.dto.QuestionAndAnswerDto;
import com.salesapp.saleskitservice.dto.UserNewsViewDto;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewsDetailRequest {
    private Integer id;
    @NotNull(message = "Title {not.empty}")
    private String title;
    @NotNull(message = "Priority {not.empty}")
    private Integer priority;
    @NotNull(message = "PublishTime {not.empty}")
    private Date publishTime;
    @NotNull(message = "Content {not.empty}")
    private String content;
    @NotNull(message = "IDGroupProduct {not.empty}")
    private Integer idGroupProduct;
    @NotNull(message = "IDGroupCustomer {not.empty}")
    private Integer idGroupCustomer;
    private List<UserNewsViewDto> listViewer;
}
