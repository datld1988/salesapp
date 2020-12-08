package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdBranchUser;
import com.salesapp.adminservice.domain.AdBranchUserId;
import com.salesapp.adminservice.dto.AdBranchUserDto;
import com.salesapp.adminservice.dto.AdUserPortalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface AdBranchUserRepository extends JpaRepository<AdBranchUser, AdBranchUserId> {
    @Query("SELECT new com.salesapp.adminservice.dto.AdBranchUserDto(" +
            " abu.branchId, abu.userId,  ab.name, ab.address) " +
            " FROM AdBranchUser abu INNER JOIN AdBranch ab ON abu.branchId=ab.id" +
            " WHERE abu.userId = :userID")
    List<AdBranchUserDto> getBranchOfUser(
            @Param("userID") String userId
    );

    @Modifying
    @Query("DELETE FROM AdBranchUser WHERE userId = :id")
    void deleteByUserId(
            @Param("id") String userId
    );

}