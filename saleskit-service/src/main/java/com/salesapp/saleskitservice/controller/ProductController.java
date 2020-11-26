package com.salesapp.saleskitservice.controller;

import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.ProductPropertiesDto;
import com.salesapp.saleskitservice.model.ProductPropertiesModel;
import com.salesapp.saleskitservice.model.ApiResultResponse;
import com.salesapp.saleskitservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "menu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<List<ProductMenuDto>> getProductMenu(@RequestParam("prodType") String prodType) {
        ApiResultResponse<List<ProductMenuDto>> response = new ApiResultResponse<>();
        response.setResponseCode("00");
        response.setResponseMessage("Success");
        response.setData(productService.getProductMenu(prodType));
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
