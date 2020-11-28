package com.salesapp.saleskitservice.service;

import com.salesapp.saleskitservice.dto.HomePageMobileDto;

public interface HomePageService {
      HomePageMobileDto getInfoForHome(String userName);
}
