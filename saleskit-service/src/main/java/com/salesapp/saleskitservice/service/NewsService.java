package com.salesapp.saleskitservice.service;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.NewsDto;
import com.salesapp.saleskitservice.model.NewsDetailRequest;

public interface NewsService {
    Response<NewsDetailRequest> addNews(NewsDetailRequest newsDetailRequest, String user);
}
