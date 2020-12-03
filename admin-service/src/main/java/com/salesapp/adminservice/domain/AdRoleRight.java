package com.salesapp.adminservice.domain;

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
@Table(name = "AD_ROLE_RIGHT")
@IdClass(AdRoleRightId.class)
public class AdRoleRight implements Serializable {
    
    public static String MetaPropId = "id";
    public static String MetaPropRoleId = "roleId";
    public static String MetaPropRightId = "rightId";
    public static String MetaPropCreatedDate = "createdDate";
    public static String MetaPropCreatedBy = "createdBy";
    public static String MetaPropModifiedDate = "modifiedDate";
    public static String MetaPropModifiedBy = "modifiedBy";

    @Id
    @Column(name = "ROLE_ID")
    // Mã PK Quyền
    private String roleId;

    @Id
    @Column(name = "RIGHT_ID")
    // Mã PK Chức năng
    private String rightId;
    
    @Column(name = "CREATED_DATE")
    // Ngày tạo
    private Date createdDate;
    
    @Column(name = "CREATED_BY")
    // Người tạo
    private String createdBy;
    
    @Column(name = "MODIFIED_DATE")
    // Ngày cập nhật
    private Date modifiedDate;
    
    @Column(name = "MODIFIED_BY")
    // Người cập nhật
    private String modifiedBy;
    

}