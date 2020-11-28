package com.salesapp.saleskitservice.service;

import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.ProductPropertiesDto;
import com.salesapp.saleskitservice.model.FilterProductRequest;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    /**
     * author : dungtq
     * date : 26/11/2020
     * getProductInfo
     * @param idSp
     * @return
     */
    List<ProductPropertiesDto> getProductInfo(Integer idSp);
    List<ProductMenuDto> getProductMenu(Integer idParent, String prodType);

    Page<ProductMenuDto> filterProduct(FilterProductRequest request);

    List<ProductMenuDto> getSuggestForSearch(String keySearch);

    Page<ProductMenuDto> search(SearchProductRequest request);


}
