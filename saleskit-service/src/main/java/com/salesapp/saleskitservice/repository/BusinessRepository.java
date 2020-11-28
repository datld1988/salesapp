package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.Business;
import com.salesapp.saleskitservice.dto.BusinessDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Integer> {

    @Query("SELECT new com.salesapp.saleskitservice.dto.BusinessDto( " +
            " b.id, b.name, b.icon, b.image1, b.timeStart, b.timeEnd) FROM Business b" +
            " WHERE b.name LIKE CONCAT('%',:name,'%') OR :name IS NULL" +
            " AND b.status = :status" +
            " ORDER BY b.createDate DESC")
    Page<BusinessDto> searchBusiness(
            Pageable page,
            @Param("name") String name,
            @Param("status") Integer status
    );

    @Query("SELECT new com.salesapp.saleskitservice.dto.BusinessDto( " +
            " b.id, b.name, b.icon, b.image1, b.timeStart, b.timeEnd) FROM Business b" +
            " WHERE b.name LIKE CONCAT('%',:name,'%') OR :name IS NULL" +
            " AND b.status = :status" +
            " ORDER BY b.createDate DESC")
    Page<BusinessDto> searchByName(
            Pageable page,
            @Param("name") String name,
            @Param("status") Integer status
    );
}
