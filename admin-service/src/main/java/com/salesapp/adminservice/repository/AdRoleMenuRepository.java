package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRoleMenuRepository extends JpaRepository<AdRoleMenu, String> {
    @Modifying
    @Query("DELETE FROM AdRoleMenu WHERE roleId = :id")
    void deleteByRoleKey(@Param("id") String roleId);
}
