package com.salesapp.saleskitservice.dto;

import com.salesapp.saleskitservice.model.ProductPropertiesModel;
import lombok.Data;

import java.util.List;

@Data
public class ProductPropertiesDto {
    private Integer productId;
    private String productName;
    private String image1;
    private String image2;
    private List<ProductPropertiesModel> lstProp;
}
