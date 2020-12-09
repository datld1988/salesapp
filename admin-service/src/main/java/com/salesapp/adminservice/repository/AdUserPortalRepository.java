package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdUserPortal;
import com.salesapp.adminservice.dto.AdUserPortalDto;
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

    @Query("SELECT new com.salesapp.adminservice.dto.AdUserPortalDto(" +
            " aup.userId,'', aup.fullNamel,'','', aup.role, aup.status, aup.position) " +
            " FROM AdUserPortal aup" +
            " WHERE (lower(aup.fullNamel)  LIKE lower(CONCAT('%',:keyword,'%'))" +
            " OR lower(aup.position) LIKE lower(CONCAT('%',:keyword,'%')))" +
            " AND (lower(aup.role) LIKE lower(:role) OR :role IS NULL)" +
            " AND (aup.status = :status OR :status =-1)" +
            " ORDER BY aup.fullNamel ASC")
    List<AdUserPortalDto> filterUserPortal(
            @Param("keyword") String keyword,
            @Param("role") String role,
            @Param("status") Integer status
    );
}
