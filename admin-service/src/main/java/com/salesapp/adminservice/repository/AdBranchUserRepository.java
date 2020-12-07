package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdBranchUser;
import com.salesapp.adminservice.dto.AdBranchUserDto;
import com.salesapp.adminservice.dto.AdUserPortalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;
@Repository
public interface AdBranchUserRepository extends JpaRepository<AdBranchUser, String> {
    @Query("SELECT new com.salesapp.adminservice.dto.AdBranchUserDto(" +
            " abu.id, abu.branchId, abu.userId) " +
            " FROM AdBranchUser abu" +
            " WHERE abu.userId = :userID")
    List<AdBranchUserDto> getBranchOfUser(
            @Param("userID") String userId
    );

}