package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdUser;
import com.salesapp.adminservice.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdUserRepository extends JpaRepository<AdUser, String> {

    List<AdUser> findAdUserByUserNameAndStatusCode(String userName, String statusCode);
}