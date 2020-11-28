package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.Promotion;
import com.salesapp.saleskitservice.dto.PromotionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    @Query("SELECT new com.salesapp.saleskitservice.dto.PromotionDto( " +
            " p.id, p.name, p.image1, p.timeStart, p.timeEnd) FROM Promotion p" +
            " WHERE p.name LIKE CONCAT('%',:name,'%') OR :name IS NULL" +
            " AND p.status = :status" +
            " ORDER BY p.createDate DESC")
    Page<PromotionDto> searchPromotion(
            Pageable page,
            @Param("name") String name,
            @Param("status") Integer status
    );
}
