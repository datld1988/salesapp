package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdRoleMenu;
import com.salesapp.adminservice.domain.AdRoleMenuId;
import com.salesapp.adminservice.dto.AdRoleMenuDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRoleMenuRepository extends JpaRepository<AdRoleMenu, AdRoleMenuId> {
    @Modifying
    @Query("DELETE FROM AdRoleMenu WHERE roleId = :id")
    void deleteByRoleKey(@Param("id") String roleId);

    @Query("SELECT new com.salesapp.adminservice.dto.AdRoleMenuDto(arm.roleId, arm.menuId, arm.status) " +
            " FROM AdRoleMenu arm" +
            " WHERE arm.menuId = CONCAT('%',:menuID,'%')" +
            " AND arm.roleId =  CONCAT('%',:roleID,'%')")
    AdRoleMenuDto findAdRoleMenuByMenuId(
            @Param("menuID") String menuID,
            @Param("roleID") String roleID
    );
}
