package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.Product;
import com.salesapp.saleskitservice.dto.ProductMenuDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByLoaiSP(String loaiSp);
    Optional<Product> findById(Integer id);

    List<Product> findByMaSPChaAndLoaiSPAndTrangThaiAndDaDuyet(
            Integer maSPCha,
            String loaiSP,
            Integer trangthai,
            Integer daDuyet
    );

    List<Product> findByLoaiSPAndTrangThai(
            String loaiSP,
            Integer trangthai
    );

    Optional<Product> findTopByMaSP(String type);

    List<Product> findByMaSPChaAndTrangThaiAndDaDuyet(Integer idParent, Integer trangthai, Integer daDuyet);

    Optional<Product> findFirstByMaSPChaAndTrangThaiAndDaDuyet(Integer idParent, Integer trangthai, Integer daDuyet);

    @Query("SELECT new com.salesapp.saleskitservice.dto.ProductMenuDto(" +
            " p.id, p.tenSP, p.icon, p.anh_1, p.tgBatDau, p.tgKetThuc) FROM Product p" +
            " WHERE (p.tgBatDau >= :fromDate OR :fromDate IS NULL)" +
            " AND (p.tgBatDau <= :toDate OR :toDate IS NULL)" +
            " AND (p.maSPCha = :menuId OR :menuId IS NULL)" +
            " AND p.trangThai = :status")
    Page<ProductMenuDto> filterProduct(
            Pageable page,
            @Param("fromDate") Date fromDate,
            @Param("toDate") Date toDate,
            @Param("menuId") Integer menuId,
            @Param("status") Integer status
    );

    @Query("SELECT new com.salesapp.saleskitservice.dto.ProductMenuDto( " +
            " p.id, p.tenSP, p.icon, p.anh_1, p.tgBatDau, p.tgKetThuc) FROM Product p" +
            " WHERE p.tenSP LIKE CONCAT('%',:name,'%') OR :name IS NULL" +
            " AND p.trangThai = :status" +
            " ORDER BY p.ngayTao DESC")
    Page<ProductMenuDto> searchByName(
            Pageable page,
            @Param("name") String name,
            @Param("status") Integer status
    );

    @Query("SELECT new com.salesapp.saleskitservice.dto.ProductMenuDto( " +
            " p.id, p.tenSP, p.icon, p.anh_1, p.tgBatDau, p.tgKetThuc) FROM Product p" +
            " WHERE p.tenSP LIKE CONCAT('%',:name,'%') OR :name IS NULL" +
            " AND p.trangThai = :status" +
            " ORDER BY p.ngayTao DESC")
    Page<ProductMenuDto> searchProduct(
            Pageable page,
            @Param("name") String name,
            @Param("status") Integer status
    );

    @Query("SELECT new com.salesapp.saleskitservice.dto.ProductMenuDto( " +
            " p.id, p.tenSP, p.icon, p.anh_1, p.tgBatDau, p.tgKetThuc, (SELECT COUNT(pc) FROM Product pc WHERE pc.maSPCha = p.id AND pc.trangThai = :status AND pc.daDuyet = :approved)) FROM Product p" +
            " WHERE p.maSPCha = :idParent" +
            " AND p.trangThai = :status" +
            " AND p.daDuyet = :approved")
    List<ProductMenuDto> checkProductOnSearch(
            @Param("idParent") Integer idParent,
            @Param("status") Integer status,
            @Param("approved") Integer approved
    );
}
