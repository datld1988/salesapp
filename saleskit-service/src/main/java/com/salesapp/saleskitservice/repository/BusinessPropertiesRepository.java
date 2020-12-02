package com.salesapp.saleskitservice.repository;

import com.salesapp.saleskitservice.domain.BusinessProperties;
import com.salesapp.saleskitservice.model.ProductPropertiesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusinessPropertiesRepository extends JpaRepository<BusinessProperties, Integer> {

    @Query("SELECT new com.salesapp.saleskitservice.model.ProductPropertiesModel(" +
            "TT.id, TT.shortContent, TT.content, DM.value ) FROM BusinessProperties TT" +
            " JOIN DanhMuc DM ON TT.type = DM.id" +
            " WHERE TT.businessId = :id AND TT.status = :status AND DM.status = :status")
    List<ProductPropertiesModel> getBusinessInfo(
            @Param("id") Integer id,
            @Param("status") Integer status
    );
}
