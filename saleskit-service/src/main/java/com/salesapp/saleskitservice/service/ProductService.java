package com.salesapp.saleskitservice.service;

import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.ProductPropertiesDto;
import com.salesapp.saleskitservice.model.ProductPropertiesModel;

import java.util.List;

public interface ProductService {

    List<ProductMenuDto> getProductMenu(String prodType);
    List<ProductPropertiesDto> getProductInfo(Integer idSp);
}
