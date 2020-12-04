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
            " WHERE lower(ar.description) LIKE lower(CONCAT('%',:keySearch,'%')) " +
            " OR lower(ar.roleName) LIKE lower(CONCAT('%',:keySearch,'%'))" +
            " OR lower(ar.id) LIKE lower(CONCAT('%',:keySearch,'%'))" )
    List<AdRoleDto> searchRole(
            String keySearch
    );

}
