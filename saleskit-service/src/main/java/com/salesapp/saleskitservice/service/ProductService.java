package com.salesapp.saleskitservice.service;

import com.salesapp.saleskitservice.dto.ProductMenuDto;

import java.util.List;

public interface ProductService {

    List<ProductMenuDto> getProductMenu(String prodType);

}
