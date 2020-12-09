package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdUserPortal;
import com.salesapp.adminservice.dto.AdRoleRightDto;
import com.salesapp.adminservice.dto.AdUserPortalDto;
import com.salesapp.adminservice.models.GetAllUserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdUserPortalRepository extends JpaRepository<AdUserPortal, String> {
    @Query("SELECT new com.salesapp.adminservice.dto.AdUserPortalDto(" +
            " aup.userId,'', aup.fullNamel,'','', aup.role, aup.status, aup.position) " +
            " FROM AdUserPortal aup" +
            " ORDER BY aup.fullNamel ASC")
    List<AdUserPortalDto> getAllUser(
    );
    @Modifying
    @Query("UPDATE AdUserPortal SET status= :status WHERE userId = :id")
    void deactiveUserPortal(
            @Param("id") String userId,
            @Param("status") Integer status
    );
}
