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
@Table(name = "RIGHT_DETAIL_VW")
public class RightDetailVw implements Serializable {
    
    public static String MetaPropId = "id";
    public static String MetaPropRoleId = "roleId";
    public static String MetaPropUrl = "url";
    public static String MetaPropRequestMethod = "requestMethod";
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
    
    @Column(name = "ROLE_ID")
    // Mã PK Quyền
    private String roleId;
    
    @Column(name = "URL")
    // Đường dẫn Url, VD: /api/project/list
    private String url;
    
    @Column(name = "REQUEST_METHOD")
    // Method type, VD: get/post/put/delete
    private String requestMethod;
    
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