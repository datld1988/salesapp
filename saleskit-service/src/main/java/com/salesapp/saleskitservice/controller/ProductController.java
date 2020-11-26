package com.salesapp.saleskitservice.controller;

import com.salesapp.saleskitservice.domain.Product;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.ProductPropertiesDto;
import com.salesapp.saleskitservice.model.ProductPropertiesModel;
import com.salesapp.saleskitservice.model.ApiResultResponse;
import com.salesapp.saleskitservice.model.FilterProductRequest;
import com.salesapp.saleskitservice.model.FilterProductResponse;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import com.salesapp.saleskitservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "menu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<List<ProductMenuDto>> getProductMenu(@RequestParam("idParent") Integer idParent, @RequestParam("prodType") String prodType) {
        ApiResultResponse<List<ProductMenuDto>> response = new ApiResultResponse<>();
        response.setResponseCode("00");
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
        response.setResponseCode("00");
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
        response.setResponseCode("00");
        response.setResponseMessage("Success");
        data.setProductList(pageProduct);
        data.setIsHasNextPage(false);
        response.setData(data);
        return response;
    }

    @RequestMapping(path = "search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<FilterProductResponse> searchProduct(@RequestBody SearchProductRequest request) {
        ApiResultResponse<FilterProductResponse> response = new ApiResultResponse<>();
        FilterProductResponse data = new FilterProductResponse();
        Page<ProductMenuDto> pageProduct = productService.search(request);
        response.setResponseCode("00");
        response.setResponseMessage("Success");
        data.setProductList(pageProduct.getContent());
        data.setIsHasNextPage(pageProduct.getNumber() + 1 < pageProduct.getTotalPages());
        response.setData(data);
        return response;
    }

    @RequestMapping(path = "info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<List<ProductPropertiesDto>> getProductInfo(@RequestParam("product_id") Integer productId) {
        ApiResultResponse<List<ProductPropertiesDto>> response = new ApiResultResponse<>();
        response.setResponseCode("00");
        response.setResponseMessage("Success");
        response.setData(productService.getProductInfo(productId));
        return response;
    }
}
