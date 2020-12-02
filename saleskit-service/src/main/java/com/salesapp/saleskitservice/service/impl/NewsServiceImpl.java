package com.salesapp.saleskitservice.service.impl;

import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import com.salesapp.saleskitservice.domain.News;
import com.salesapp.saleskitservice.domain.UserNewsView;
import com.salesapp.saleskitservice.dto.NewsDto;
import com.salesapp.saleskitservice.model.NewsDetailRequest;
import com.salesapp.saleskitservice.repository.NewsRepository;
import com.salesapp.saleskitservice.repository.UserNewsViewReposity;
import com.salesapp.saleskitservice.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class NewsServiceImpl implements NewsService {
    private final Logger log = LoggerFactory.getLogger(NewsServiceImpl.class);
    private NewsRepository newsRepository;
    private UserNewsViewReposity userNewsViewReposity;
    @Override
    public Response<NewsDetailRequest> addNews(NewsDetailRequest newsDetailRequest) {
        News news = new News();
        UserNewsView userNewsView = new UserNewsView();

        try{
            if (newsRepository.findNewsById(newsDetailRequest.getId()).getId() == null){
                news.setId(newsRepository.getNextNewsID());
            }
            news.setTitle(newsDetailRequest.getTitle());
            news.setPriority(newsDetailRequest.getPriority());
            news.setContent(newsDetailRequest.getContent());
            news.setCreateDate(new Date());
            news.setPubDate(newsDetailRequest.getPublishTime());
            news.setIdGroupCustomer(newsDetailRequest.getIdGroupCustomer());
            news.setIdGroupProduct(newsDetailRequest.getIdGroupProduct());
            newsRepository.save(news);
            if (newsDetailRequest.getListViewer().size() >= 1){
                for (int i=0;i<newsDetailRequest.getListViewer().size();i++){
                    userNewsView.setIdUser(newsDetailRequest.getListViewer().get(i).getIdUser());
                    userNewsView.setIdNews(news.getId());
                    userNewsView.setCreateDate(new Date());
                }

            }
            userNewsViewReposity.save(userNewsView);


            return Response.success("Update successful");
        }
        catch (Exception e){
            log.error("addNews Exception : "+e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }

    }
}
