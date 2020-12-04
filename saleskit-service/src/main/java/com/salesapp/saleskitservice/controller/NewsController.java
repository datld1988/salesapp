package com.salesapp.saleskitservice.controller;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.NewsDto;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import com.salesapp.saleskitservice.model.FilterQuestionAndAnswerRequest;
import com.salesapp.saleskitservice.model.NewsDetailRequest;
import com.salesapp.saleskitservice.service.NewsService;
import com.salesapp.saleskitservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(path = "detail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response<NewsDetailRequest> getGroupOfProduct(@RequestBody NewsDetailRequest newsDetailRequest) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return newsService.addNews(newsDetailRequest, user);
    }
}
