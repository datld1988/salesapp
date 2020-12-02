package com.salesapp.saleskitservice.model;

import com.salesapp.saleskitservice.dto.BusinessDto;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilterProductResponse {
    private List<ProductMenuDto> productList;
    private List<BusinessDto> businessList;
    private Boolean isHasNextPage;
}
