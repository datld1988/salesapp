package com.salesapp.saleskitservice.model;

import lombok.*;

import javax.validation.constraints.Min;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchNewsRequest {
    private String fromDate;
    private String toDate;
    private String priority;
    private List<String> tagsList;
    @Min(value = 0, message="Page index have to bigger than 0")
    private Integer page;
    @Min(value = 1, message="Page size have to bigger than 1")
    private Integer pageSize;
}
