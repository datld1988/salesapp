package com.salesapp.saleskitservice.service.impl;

import com.salesapp.saleskitservice.constant.ProductConst;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import com.salesapp.saleskitservice.util.StringUtil;
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
        productMenuDtoList = productRepository.findByMaSPChaAndLoaiSPAndTrangThai(idParent, prodType, ProductConst.STATUS_ACTIVE)
        .stream().map(product -> {
            ProductMenuDto menu = ProductMenuDto.fromRoot(product);
            if (product.getMaSPCha() != null) {
                List<Product> child = getProductChild(product.getId());
                if (child != null && child.size() > 0) {
                    menu.setChild(1);
                } else {
                    menu.setChild(0);
                }
            }
            return menu;
        }).collect(Collectors.toList());
        return productMenuDtoList;
    }

    @Override
    public List<ProductPropertiesDto> getProductInfo(Integer idSp) {
        List<ProductPropertiesDto> result = new ArrayList<ProductPropertiesDto>();


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

        return result;
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
    public List<ProductMenuDto> getSuggestForSearch(String keySearch) {
        return productRepository.searchByName(PageRequest.of(0, 5), keySearch, ProductConst.STATUS_ACTIVE).getContent();
    }

    @Override
    public Page<ProductMenuDto> search(SearchProductRequest request) {
        return productRepository.searchProduct(
                PageRequest.of(request.getPage(), request.getPageSize()),
                request.getKeySearch(), ProductConst.STATUS_ACTIVE
//                request.getIsProduct(),
//                request.getIsPromotion(),
//                request.getIsMajor()
        );
    }

    private List<Product> getProductChild(Integer idParent) {
        return productRepository.findByMaSPCha(idParent);
    }
}
