package com.salesapp.saleskitservice.service.impl;

import com.salesapp.saleskitservice.domain.Product;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.dto.ProductPropertiesDto;
import com.salesapp.saleskitservice.model.ProductPropertiesModel;
import com.salesapp.saleskitservice.repository.ProductPropertiesRepository;
import com.salesapp.saleskitservice.repository.ProductRepository;
import com.salesapp.saleskitservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ProductMenuDto> getProductMenu(String prodType) {
        List<Product> productList = productRepository.findByLoaiSP(prodType);
        List<ProductMenuDto> productMenuDtoList = productList.stream().map(ProductMenuDto::fromRoot).collect(Collectors.toList());
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
}
