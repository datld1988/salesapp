package com.salesapp.saleskitservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterProductRequest {
    private String fromDate;
    private String toDate;
    private Integer menuId;
    private Integer page;
    private Integer pageSize;
}
