package com.salesapp.saleskitservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchProductRequest {
    private String keySearch;
    private Boolean isProduct;
    private Boolean isPromotion;
    private Boolean isMajor;
    private Integer page;
    private Integer pageSize;
}
