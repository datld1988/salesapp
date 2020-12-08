package com.salesapp.saleskitservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchTagRequest {
    private String searchValue;
    private Integer page;
    private Integer pageSize;
    private String sortOrder;
    private String sortBy;
}
