package com.salesapp.saleskitservice.service;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.ProductPropertiesDto;
import com.salesapp.saleskitservice.model.ApiResultResponse;
import com.salesapp.saleskitservice.model.FilterProductRequest;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    /**
     * author: dungtq
     * date : 26/11/2020
     * lấy thông tin sản phẩm
     * @param idSp : mã sản phẩm
     * @return thông tin sản phẩm
     */
    Response getProductInfo(Integer idSp);


    List<ProductMenuDto> getProductMenu(Integer idParent, String prodType);

    Page<ProductMenuDto> filterProduct(FilterProductRequest request);

    List<ProductMenuDto> getSuggestForSearch(String keySearch, Integer size);

    Page<ProductMenuDto> search(SearchProductRequest request);

    /**
     * author: anhld
     * date : 26/11/2020
     * lấy các loại khách hàng
     * @param
     * @return danh sách loại khách hàng
     */
    ApiResultResponse<List<ProductMenuDto>> listGroupOfProduct();
}
