package com.salesapp.saleskitservice.model;

import com.salesapp.saleskitservice.dto.BusinessDto;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.PromotionDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchProductResponse {
    private List<ProductMenuDto> productList;
    private List<PromotionDto> promotionList;
    private List<BusinessDto> businessList;
    private Boolean isHasNextProduct;
    private Boolean isHasNextPromotion;
    private Boolean isHasNextBusiness;
}
