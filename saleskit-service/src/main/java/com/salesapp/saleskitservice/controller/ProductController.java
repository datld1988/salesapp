package com.salesapp.saleskitservice.controller;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.BusinessDto;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.ProductPropertiesDto;
import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.model.*;
import com.salesapp.saleskitservice.service.BusinessService;
import com.salesapp.saleskitservice.service.ProductService;
import com.salesapp.saleskitservice.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private BusinessService businessService;

    /**
     * author: truongnh
     * date: 26/11/2020
     * lấy thông tin category từng cấp
     * @param idParent : mã menu cha
     * @param prodType : nhóm sản phẩm
     * @return
     */
    @RequestMapping(path = "menu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getProductMenu(@RequestParam("idParent") Integer idParent, @RequestParam("prodType") String prodType) {
        return Response.success(productService.getProductMenu(idParent, prodType));
    }

    /**
     * author: truongnh
     * date: 26/11/2020
     * Loc danh sach san pham
     * @param request FilterProductRequest object
     * fromDate va toDate la tim kiem theo cot : thoi gian bat dau*/
    @RequestMapping(path = "filter", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response filterProduct(@RequestBody FilterProductRequest request) {
        ApiResultResponse<FilterProductResponse> response = new ApiResultResponse<>();
        FilterProductResponse data = new FilterProductResponse();
        Page<ProductMenuDto> pageProduct = productService.filterProduct(request);

        data.setProductList(pageProduct.getContent());
        data.setIsHasNextPage(pageProduct.getNumber() + 1 < pageProduct.getTotalPages());
        return Response.success(data);

    }

    /**
     * author : truongnh
     * date : 26/11/2020
     * goi y tim kiem san pham
     * @param keySearch gia tri can tim kiem
     * theo thu uu tien: product-promotion-business
     * so luong ban ghi goi y la : 10 ban ghi*/
    @RequestMapping(path = "suggest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response suggestSearch(@RequestParam String keySearch) {

        FilterProductResponse data = new FilterProductResponse();
        List<ProductMenuDto> productList = productService.getSuggestForSearch(keySearch, 10);

        if (productList.size() < 10) {
            List<PromotionDto> promotionList = promotionService.getSuggestForSearch(keySearch, 10 - productList.size());
            Stream<ProductMenuDto> toProduct = Optional.ofNullable(promotionList)
                    .orElseGet(Collections::emptyList)
                    .stream()
                    .filter(Objects::nonNull)
                    .map(promotion -> new ProductMenuDto(
                            promotion.getId(),
                            promotion.getTitle(),
                            null,
                            promotion.getImage(),
                            promotion.getTimeStart(),
                            promotion.getTimeEnd(),
                            null)
                    );
            productList = Stream.concat(productList.stream(), toProduct).collect(Collectors.toList());
        }
        if (productList.size() < 10) {
            List<BusinessDto> businessList = businessService.getSuggestForSearch(keySearch, 10 - productList.size());
            Stream<ProductMenuDto> toProduct = Optional.ofNullable(businessList)
                    .orElseGet(Collections::emptyList)
                    .stream()
                    .filter(Objects::nonNull)
                    .map(business -> new ProductMenuDto(
                            business.getId(),
                            business.getTitle(),
                            business.getIcon(),
                            business.getImage(),
                            business.getTimeStart(),
                            business.getTimeEnd(),
                            null
                    ));
            productList = Stream.concat(productList.stream(), toProduct).collect(Collectors.toList());
        }
        data.setProductList(productList);
        data.setIsHasNextPage(false);
        return Response.success(data);
    }

    /**
     * author : truongnh
     * date : 26/11/2020
     * tìm kiếm sản phẩm
     * @param request : params tìm kiếm
     * @return danh sách các sản phẩm theo tiêu chí tìm kiếm
     * có phân trang
     */
    @RequestMapping(path = "search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response searchProduct(@RequestBody SearchProductRequest request) {

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
        return Response.success(data);
    }

    /**
     * author: dungtq
     * date : 26/11/2020
     * lấy thông tin sản phẩm
     * @param productId : mã sản phẩm
     * @return thông tin sản phẩm
     */
    @RequestMapping(path = "info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getProductInfo(@RequestParam("product_id") Integer productId) {
        return productService.getProductInfo(productId);
    }

    /**
     * author: anhld
     * date : 26/11/2020
     * lấy ra danh sách các loại khách hàng
     * @param
     * @return: danh sách tất cả các loại khách hàng
     */
    @RequestMapping(path = "group", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResultResponse<List<ProductMenuDto>> getGroupOfProduct() {

        return productService.listGroupOfProduct();
    }
}
