package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.ProductProperties;
import com.salesapp.saleskitservice.model.ProductPropertiesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPropertiesRepository extends JpaRepository<ProductProperties, Integer> {
    List<ProductProperties> findByIdSPAndTrangThai(Integer idSP, Integer trangThai);

    @Query("SELECT new com.salesapp.saleskitservice.model.ProductPropertiesModel(" +
            "TT.id, TT.noiDungNgan, TT.ndChiTiet, DM.value ) FROM ProductProperties TT" +
            " JOIN DanhMuc DM ON TT.loaiThuocTinh = DM.id" +
            " WHERE TT.idSP = :idSP AND TT.trangThai = :status AND DM.status = :status")
    List<ProductPropertiesModel> getProductInfo(
            @Param("idSP") Integer idSp,
            @Param("status") Integer status
    );
}
