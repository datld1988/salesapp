package com.salesapp.saleskitservice.controller;

import com.salesapp.saleskitservice.dto.BusinessDto;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.ProductPropertiesDto;
import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.model.*;
import com.salesapp.saleskitservice.service.BusinessService;
import com.salesapp.saleskitservice.service.ProductService;
import com.salesapp.saleskitservice.service.PromotionService;
import com.uniform.common.dto.Response;
import com.uniform.common.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private BusinessService businessService;

    @RequestMapping(path = "menu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<List<ProductMenuDto>> getProductMenu(@RequestParam("idParent") Integer idParent, @RequestParam("prodType") String prodType) {
        ApiResultResponse<List<ProductMenuDto>> response = new ApiResultResponse<>();
        response.setResponseCode("000");
        response.setResponseMessage("Success");
        response.setData(productService.getProductMenu(idParent, prodType));
        return response;
    }

    @RequestMapping(path = "filter", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<FilterProductResponse> filterProduct(@RequestBody FilterProductRequest request) {
        ApiResultResponse<FilterProductResponse> response = new ApiResultResponse<>();
        FilterProductResponse data = new FilterProductResponse();
        Page<ProductMenuDto> pageProduct = productService.filterProduct(request);
        response.setResponseCode("000");
        response.setResponseMessage("Success");
        data.setProductList(pageProduct.getContent());
        data.setIsHasNextPage(pageProduct.getNumber() + 1 < pageProduct.getTotalPages());
        response.setData(data);
        return response;
    }

    @RequestMapping(path = "suggest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<FilterProductResponse> suggestSearch(@RequestParam String keySearch) {
        ApiResultResponse<FilterProductResponse> response = new ApiResultResponse<>();
        FilterProductResponse data = new FilterProductResponse();
        List<ProductMenuDto> pageProduct = productService.getSuggestForSearch(keySearch);
        response.setResponseCode("000");
        response.setResponseMessage("Success");
        data.setProductList(pageProduct);
        data.setIsHasNextPage(false);
        response.setData(data);
        return response;
    }

    @RequestMapping(path = "search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<SearchProductResponse> searchProduct(@RequestBody SearchProductRequest request) {
        ApiResultResponse<SearchProductResponse> response = new ApiResultResponse<>();
        SearchProductResponse data = new SearchProductResponse();
        if (request.getIsProduct() == Boolean.TRUE) {
            Page<ProductMenuDto> pageProduct = productService.search(request);
            data.setProductList(pageProduct.getContent());
            data.setIsHasNextProduct(pageProduct.getNumber() + 1 < pageProduct.getTotalPages());
        } else {
            data.setProductList(Collections.EMPTY_LIST);
            data.setIsHasNextProduct(Boolean.FALSE);
        }

        if(request.getIsBusiness()) {
            Page<BusinessDto> pageBusiness = businessService.search(request);
            data.setBusinessList(pageBusiness.getContent());
            data.setIsHasNextBusiness(pageBusiness.getNumber() + 1 < pageBusiness.getTotalPages());
        } else {
            data.setBusinessList(Collections.EMPTY_LIST);
            data.setIsHasNextBusiness(Boolean.FALSE);
        }

        if (request.getIsPromotion()) {
            Page<PromotionDto> pagePromotion = promotionService.search(request);
            data.setPromotionList(pagePromotion.getContent());
            data.setIsHasNextPromotion(pagePromotion.getNumber() + 1 < pagePromotion.getTotalPages());
        } else {
            data.setPromotionList(Collections.EMPTY_LIST);
            data.setIsHasNextPromotion(Boolean.FALSE);
        }
        response.setData(data);
        response.setResponseCode("000");
        response.setResponseMessage("Success");
        return response;
    }

    /**
     * author: dungtq
     * create date : 26/11/2020
     * lấy thông tin sản phẩm
     * @param productId : mã sản phẩm
     * @return danh sách các thuộc tính sản phẩm
     */
    @RequestMapping(path = "info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getProductInfo(     @RequestParam("product_id")
                                        @NotNull(message = "product_id not null")
                                        @NotEmpty (message = "product_id not empty")
                                        @Valid
                                                   Integer productId) {

        List<ProductPropertiesDto> result  = productService.getProductInfo(productId);
        if (result.size() != 0)
            return Response.success(result);
        else
            return Response.error(ErrorCode.NOT_FOUND_RECORDS, "Không tìm thấy bản ghi thỏa mãn");
    }
}
