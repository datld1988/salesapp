package com.salesapp.saleskitservice.service;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.NewsDto;
import com.salesapp.saleskitservice.model.NewsDetailRequest;
import com.salesapp.saleskitservice.model.SearchNewsRequest;

public interface NewsService {
    Response<NewsDetailRequest> addNews(NewsDetailRequest newsDetailRequest, String user);

    Response searchNews(SearchNewsRequest request);
}
