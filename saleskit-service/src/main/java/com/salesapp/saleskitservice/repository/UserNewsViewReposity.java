package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.News;
import com.salesapp.saleskitservice.domain.UserNewsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNewsViewReposity extends JpaRepository<UserNewsView, Integer> {
}
