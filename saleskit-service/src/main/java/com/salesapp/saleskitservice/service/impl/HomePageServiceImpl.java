package com.salesapp.saleskitservice.service.impl;

import com.salesapp.saleskitservice.dto.HomePageMobileDto;
import com.salesapp.saleskitservice.service.HomePageService;
import org.springframework.stereotype.Service;

@Service
public class HomePageServiceImpl implements HomePageService {



    @Override
    public HomePageMobileDto getInfoForHome(String userName) {
        HomePageMobileDto dto = new HomePageMobileDto();
        dto.setFullName(null);
        dto.setUserName(userName);
        dto.setKHTC(10);
        dto.setKHTN(10);
        return dto;
    }
}
