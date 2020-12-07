package com.salesapp.saleskitservice.controller;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.NewsDto;
import com.salesapp.saleskitservice.dto.NewsTagDto;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.model.FilterQuestionAndAnswerRequest;
import com.salesapp.saleskitservice.model.NewsDetailRequest;
import com.salesapp.saleskitservice.model.SearchNewsRequest;
import com.salesapp.saleskitservice.service.NewsService;
import com.salesapp.saleskitservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(path = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response<NewsDetailRequest> getGroupOfProduct(@RequestBody NewsDetailRequest newsDetailRequest) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return newsService.addNews(newsDetailRequest, user);
    }

    /**
     * auth: truongnh
     * date: 04/10/2020
     * Tim kiem ban tin tren mobile
     * @param request gia tri tim kiem
     * */
    @RequestMapping(path = "search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response searchNews(@RequestBody @Valid SearchNewsRequest request) {
        return newsService.searchNews(request);
    }
    /**
     * auth: anhld
     * date: 7/12/2020
     * lấy thông tin chi tiết của bảng tin
     * @param newsId: id của bảng tin
     * */
    @RequestMapping(path = "detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response searchNews(@RequestParam("newsId") Integer newsId) {
        return newsService.newsDetail(newsId);
    }
}
