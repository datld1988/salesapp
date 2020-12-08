package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.News;
import com.salesapp.saleskitservice.domain.UserNewsView;
import com.salesapp.saleskitservice.dto.NewsTagDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserNewsViewRepository extends JpaRepository<UserNewsView, Integer> {
    @Modifying
    @Query("DELETE FROM UserNewsView WHERE idNews = :id")
    void deleteByNewsID(@Param("id") Integer newsID);

}
