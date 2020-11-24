package com.salesapp.authservice.repository;

import com.salesapp.authservice.domain.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdUserRepository extends JpaRepository<AdUser, String> {

    Optional<AdUser> findByUserName(String username);

    @Query(value = "SELECT \n" +
            "ar.REQUEST_METHOD\n" +
            "FROM AD_USER au\n" +
            "JOIN AD_GROUP_USER agu ON au.ID = agu.USER_ID\n" +
            "JOIN AD_GROUP_ROLE agr ON agu.GROUP_ID = agr.GROUP_ID\n" +
            "JOIN AD_ROLE_RIGHT arr ON arr.ROLE_ID = agr.ROLE_ID\n" +
            "JOIN AD_RIGHT ar ON ar.ID = arr.RIGHT_ID\n" +
            "WHERE au.USER_NAME = :userName", nativeQuery = true)
    List<String> findPermissionWithAuthoritiesByLogin(@Param("userName") String userName);
}