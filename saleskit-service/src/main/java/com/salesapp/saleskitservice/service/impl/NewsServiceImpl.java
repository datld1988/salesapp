package com.salesapp.saleskitservice.service.impl;

import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import com.salesapp.saleskitservice.domain.News;
import com.salesapp.saleskitservice.domain.UserNewsView;
import com.salesapp.saleskitservice.dto.NewsDto;
import com.salesapp.saleskitservice.dto.UserNewsViewDto;
import com.salesapp.saleskitservice.model.NewsDetailRequest;
import com.salesapp.saleskitservice.repository.NewsRepository;
import com.salesapp.saleskitservice.repository.UserNewsViewReposity;
import com.salesapp.saleskitservice.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class NewsServiceImpl implements NewsService {
    private final Logger log = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private UserNewsViewReposity userNewsViewReposity;

    @Override
    public Response<NewsDetailRequest> addNews(NewsDetailRequest newsDetailRequest, String user) {
        News news = new News();
        boolean isCreate = true;
        try{
            if (newsDetailRequest.getId() != null){
                news.setId(newsDetailRequest.getId());
                isCreate = false;
            }
            news.setTitle(newsDetailRequest.getTitle());
            news.setStatus(1);
            news.setPriority(newsDetailRequest.getPriority());
            news.setContent(newsDetailRequest.getContent());
            news.setPublisher(user);
            if(isCreate) {
                news.setPubDate(new Date());
                news.setCreateDate(new Date());
                news.setCreatedBy(user);
            } else {
                news.setModifyDate(new Date());
                news.setModifyBy(user);
            }

            News ns =  newsRepository.save(news);
            if (newsDetailRequest.getListViewer().size() >= 1){
                for (UserNewsViewDto item: newsDetailRequest.getListViewer()) {
                    UserNewsView userNewsView = new UserNewsView();
                    userNewsView.setIdUser(item.getIdUser());
                    userNewsView.setIdNews(ns.getId());
                    userNewsView.setCreateDate(new Date());
                    userNewsViewReposity.save(userNewsView);
                }
            }
            return Response.success("Update successful");
        }
        catch (Exception e){
            log.error("addNews Exception : "+e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }

    }
}
