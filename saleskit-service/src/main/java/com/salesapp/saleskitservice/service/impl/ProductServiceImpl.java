package com.salesapp.saleskitservice.service.impl;

import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import com.salesapp.saleskitservice.constant.ProductConst;
import com.salesapp.saleskitservice.model.ApiResultResponse;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import com.salesapp.saleskitservice.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.salesapp.saleskitservice.domain.Product;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.ProductPropertiesDto;
import com.salesapp.saleskitservice.model.ProductPropertiesModel;
import com.salesapp.saleskitservice.repository.ProductPropertiesRepository;
import com.salesapp.saleskitservice.model.FilterProductRequest;
import com.salesapp.saleskitservice.repository.ProductRepository;
import com.salesapp.saleskitservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPropertiesRepository propertiesRepository;

    @Override
    public List<ProductMenuDto> getProductMenu(Integer idParent, String prodType) {
        List<ProductMenuDto> productMenuDtoList = new ArrayList<>();
        if (idParent == null || idParent <= 0) {
            Optional<Product> productOp = productRepository.findTopByMaSP(prodType);
            if (productOp.isPresent()) {
                idParent = productOp.get().getId();
            }
        }
        productMenuDtoList = productRepository.findByMaSPChaAndLoaiSPAndTrangThaiAndDaDuyet(
                idParent, prodType, ProductConst.STATUS_ACTIVE, ProductConst.APPROVED)
        .stream().map(product -> {
            ProductMenuDto menu = ProductMenuDto.fromRoot(product);
            if (product.getMaSPCha() != null) {
                List<ProductMenuDto> childes = getProductChild(product.getId());
                if (childes.size() > 0) {
                    if (childes.get(0).getChild() > 0) {
                        menu.setChild(1);
                    } else {
                        menu.setChild(0);
                    }
                } else {
                    menu.setChild(0);
                }
            }
            return menu;
        }).collect(Collectors.toList());
        return productMenuDtoList;
    }

    /**
     * author: dungtq
     * date : 26/11/2020
     * @param idSp : mã sản phẩm
     * @return thông tin sản phẩm
     */
    @Override
    public Response getProductInfo(Integer idSp) {
        List<ProductPropertiesDto> result = new ArrayList<ProductPropertiesDto>();
        try {
            Optional<Product> pro = productRepository.findById(idSp);
            if(pro.isPresent()) {
                ProductPropertiesDto dto = new ProductPropertiesDto();
                dto.setProductId(pro.get().getId());
                dto.setProductName(pro.get().getTenSP());
                dto.setImage1(pro.get().getAnh_1());
                dto.setImage2(pro.get().getAnh_2());
                List<ProductPropertiesModel> lstProp =  propertiesRepository.getProductInfo(idSp, 1);
                dto.setLstProp(lstProp);
                result.add(dto);
            }

            return Response.success(result);
        } catch (Exception e) {
            log.error("getProductInfo Exception : "+e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }

    }

    @Override
    public Page<ProductMenuDto> filterProduct(FilterProductRequest request) {
        Date fromParse = StringUtil.convertStringToDate(request.getFromDate());
        Date toDate = StringUtil.convertStringToDate(request.getToDate());
        Page<ProductMenuDto> listProductPage = productRepository.filterProduct(
                PageRequest.of(request.getPage(), request.getPageSize())
                , fromParse, toDate, request.getMenuId(), ProductConst.STATUS_ACTIVE);
        return listProductPage;
    }

    @Override
    public List<ProductMenuDto> getSuggestForSearch(String keySearch, Integer size) {
        return productRepository.searchByName(PageRequest.of(0, size), keySearch, ProductConst.STATUS_ACTIVE).getContent();
    }

    @Override
    public Page<ProductMenuDto> search(SearchProductRequest request) {
        return productRepository.searchProduct(
                PageRequest.of(request.getPage(), request.getPageSize()),
                request.getKeySearch(), ProductConst.STATUS_ACTIVE
        );
    }

    private List<ProductMenuDto> getProductChild(Integer idParent) {
        return productRepository.checkProductOnSearch(idParent, ProductConst.STATUS_ACTIVE, ProductConst.APPROVED);
    }

    /**
     * author: anhld
     * date : 26/11/2020
     * @param
     * @return danh sách loại khách hàng
     */
    @Override
    public ApiResultResponse<List<ProductMenuDto>> listGroupOfProduct(){
        ApiResultResponse<List<ProductMenuDto>> response = new ApiResultResponse<>();
        response.setResponseCode("000");
        response.setResponseMessage("Success");
        response.setData(productRepository.listGroupOfProduct());

        return response;
    }
}
