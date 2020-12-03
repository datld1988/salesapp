package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdRole;
import com.salesapp.adminservice.dto.AdRoleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRoleRepository extends JpaRepository<AdRole, String> {
    @Query("SELECT new com.salesapp.adminservice.dto.AdRoleDto(ar.id, ar.roleName, ar.description, ar.statusCode) FROM AdRole ar" +
            " WHERE ar.description LIKE CONCAT('%',:keySearch,'%')" )
    List<AdRoleDto> searchRole(
            String keySearch
    );

}
