package com.salesapp.saleskitservice.service.impl;

import com.salesapp.saleskitservice.domain.Product;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.repository.ProductRepository;
import com.salesapp.saleskitservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductMenuDto> getProductMenu(String prodType) {
        List<Product> productList = productRepository.findByLoaiSP(prodType);
        List<ProductMenuDto> productMenuDtoList = productList.stream().map(ProductMenuDto::fromRoot).collect(Collectors.toList());
        return productMenuDtoList;
    }
}
