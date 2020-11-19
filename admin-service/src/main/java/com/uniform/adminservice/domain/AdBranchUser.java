package com.uniform.adminservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AD_BRANCH_USER")
public class AdBranchUser implements Serializable {
    
    public static String MetaPropId = "id";
    public static String MetaPropBranchId = "branchId";
    public static String MetaPropUserId = "userId";
    public static String MetaPropCreatedBy = "createdBy";
    public static String MetaPropCreatedDate = "createdDate";
    public static String MetaPropModifiedBy = "modifiedBy";
    public static String MetaPropModifiedDate = "modifiedDate";

    @Id
    @Column(name = "ID")
    // Mã PK
    private String id;
    
    @Column(name = "BRANCH_ID")
    // Mã PK Chi nhánh
    private String branchId;
    
    @Column(name = "USER_ID")
    // Mã PK Người dùng
    private String userId;
    
    @Column(name = "CREATED_BY")
    // Người tạo
    private String createdBy;
    
    @Column(name = "CREATED_DATE")
    // Ngày tạo
    private Date createdDate;
    
    @Column(name = "MODIFIED_BY")
    // Người cập nhật
    private String modifiedBy;
    
    @Column(name = "MODIFIED_DATE")
    // Ngày cập nhật
    private Date modifiedDate;
    

}