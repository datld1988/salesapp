package com.salesapp.saleskitservice.service.impl;

import com.salesapp.saleskitservice.constant.ProductConst;
import com.salesapp.saleskitservice.dto.PromotionDto;
import com.salesapp.saleskitservice.model.PromotionListRequest;
import com.salesapp.saleskitservice.model.SearchProductRequest;
import com.salesapp.saleskitservice.repository.PromotionRepository;
import com.salesapp.saleskitservice.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    PromotionRepository promotionRepository;

    @Override
    public Page<PromotionDto> search(SearchProductRequest request) {
        return promotionRepository.searchPromotion(
                PageRequest.of(request.getPage(), request.getPageSize()),
                request.getKeySearch(), ProductConst.STATUS_ACTIVE
        );
    }

    @Override
    public List<PromotionDto> getSuggestForSearch(String keySearch, Integer size) {
        return promotionRepository.searchByName(PageRequest.of(0, size), keySearch, ProductConst.STATUS_ACTIVE).getContent();
    }

    @Override
    public Page<PromotionDto> filterPromotion(PromotionListRequest request){
        return  promotionRepository.filterPromotion(PageRequest.of(request.getPage(), request.getPerPage()), request.getIdSP(), 1);
    }

    @Override
    public Page<PromotionDto> listAllPromotion(PromotionListRequest request){
        return  promotionRepository.listAllPromotion(PageRequest.of(request.getPage(), request.getPerPage()), 1);
    }

    @Override
    public PromotionDto getPromotionByID(Integer id){
        return  promotionRepository.getPromotionByID(id);
    }
}
