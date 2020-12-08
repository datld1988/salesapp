package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "AD_USER_PORTAL", schema = "SALES_APP_CORE")
public class AdUserPortal implements Serializable {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "MODIFY_BY")
    private String modifyBy;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;
}
