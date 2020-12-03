package com.salesapp.saleskitservice.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewsDto {
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
    private UserNewsViewDto userNewsViewDto;
}
