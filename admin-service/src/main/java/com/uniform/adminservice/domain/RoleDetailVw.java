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
@Table(name = "ROLE_DETAIL_VW")
public class RoleDetailVw implements Serializable {
    
    public static String MetaPropId = "id";
    public static String MetaPropGroupId = "groupId";
    public static String MetaPropRoleName = "roleName";
    public static String MetaPropDescription = "description";
    public static String MetaPropStatusCode = "statusCode";
    public static String MetaPropCreatedDate = "createdDate";
    public static String MetaPropCreatedBy = "createdBy";
    public static String MetaPropModifiedDate = "modifiedDate";
    public static String MetaPropModifiedBy = "modifiedBy";

    @Id
    @Column(name = "ID")
    // Mã PK
    private String id;
    
    @Column(name = "GROUP_ID")
    // Mã PK Nhóm
    private String groupId;
    
    @Column(name = "ROLE_NAME")
    // Tên
    private String roleName;
    
    @Column(name = "DESCRIPTION")
    // Mô tả
    private String description;
    
    @Column(name = "STATUS_CODE")
    // Trạng thái sử dụng A, I, L, D
    private String statusCode;
    
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