package com.salesapp.adminservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AD_USER_PORTAL")
public class AdUserPortal implements Serializable {
    @Id
    @Column(name = "USER_ID")
    // mã pk (username)
    private String userId;

    @Column(name = "PASSWORD")
    // mật khẩu (mã hóa)
    private String password;

    @Column(name = "FULLNAME")
    // họ tên
    private String fullNamel;

    @Column(name = "PHONE")
    // sđt
    private String phone;

    @Column(name = "email")
    // email
    private String email;

    @Column(name = "ROLE")
    // role
    private String role;

    @Column(name = "STATUS")
    // trạng thái user
    private String status;

    @Column(name = "POSITION")
    // chức vụ
    private String position;

    @Column(name = "CREATE_BY")
    // người tạo
    private String createBy;

    @Column(name = "CREATE_DATE")
    // ngày tạo
    private Date createDate;

    @Column(name = "MODIFY_BY")
    //người sửa
    private String modifyBy;

    @Column(name = "MODIFY_DATE")
    // ngày sửa
    private Date modifyDate;


}
