package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.Business;
import com.salesapp.saleskitservice.domain.News;
import com.salesapp.saleskitservice.dto.BusinessDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    News findNewsById(Integer id);

    @Query(value = "SELECT SCHEMA.SAPP_NEWS_SEQ.nextval FROM dual", nativeQuery = true)
    public Integer getNextNewsID();
}
