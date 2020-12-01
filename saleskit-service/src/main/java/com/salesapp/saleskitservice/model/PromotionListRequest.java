package com.salesapp.saleskitservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PromotionListRequest {
    private Integer idSP;
    private Integer page;
    private Integer perPage;
}
