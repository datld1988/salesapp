package com.salesapp.adminservice.repository;

import com.salesapp.adminservice.domain.AdUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdUserRoleRepository extends JpaRepository<AdUserRole, String> {
    @Modifying
    @Query("DELETE FROM AdUserRole WHERE userId = :id ")
    void deleteByUserId(@Param("id") String userId);
}
