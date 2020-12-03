package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdRoleRight;
import com.salesapp.adminservice.domain.AdRoleRightId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdRoleRightRepository extends JpaRepository<AdRoleRight, AdRoleRightId> {
    @Modifying
    @Query("DELETE FROM AdRoleRight WHERE roleId = :id ")
    void deleteByRoleKey(@Param("id") String roleId);
}