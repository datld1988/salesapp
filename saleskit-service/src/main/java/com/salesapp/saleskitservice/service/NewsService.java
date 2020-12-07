package com.salesapp.saleskitservice.service;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.NewsDto;
import com.salesapp.saleskitservice.model.NewsDetailRequest;
import com.salesapp.saleskitservice.model.SearchNewsRequest;

public interface NewsService {
    Response<NewsDetailRequest> addNews(NewsDetailRequest newsDetailRequest, String user);

    Response searchNews(SearchNewsRequest request);
    /**
     * auth: anhld
     * date: 7/12/2020
     * lấy thông tin chi tiết của bảng tin
     * @param id: id của bảng tin
     * */
    Response newsDetail(Integer id);
}
