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
@Table(name = "AD_USER")
public class AdUser implements Serializable {
    
    public static String MetaPropId = "id";
    public static String MetaPropUserName = "userName";
    public static String MetaPropEmail = "email";
    public static String MetaPropPhone = "phone";
    public static String MetaPropStatusCode = "statusCode";
    public static String MetaPropCreatedDate = "createdDate";
    public static String MetaPropCreatedBy = "createdBy";
    public static String MetaPropModifiedDate = "modifiedDate";
    public static String MetaPropModifiedBy = "modifiedBy";
    public static String MetaPropAvatar = "avatar";
    public static String MetaPropFullName = "fullname";

    @Id
    @Column(name = "ID")
    // Mã PK
    private String id;
    
    @Column(name = "USER_NAME")
    // Tên ứng dụng
    private String userName;
    
    @Column(name = "EMAIL")
    // Secret Key để tạo chữ ký
    private String email;
    
    @Column(name = "PHONE")
    // Public Key để mã hóa dữ liệu
    private String phone;
    
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

    @Column(name = "AVATAR")
    // ảnh dại diện
    private String avatar;

    @Column(name = "FULLNAME")
    // họ tên
    private String fullName;

}