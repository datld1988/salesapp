package com.uniform.notificationservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AD_EMAIL_SERVER")
@Data
public class AdEmailServer implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "HOST")
    private String host;
    @Column(name = "PORT")
    private Integer port;
    @Column(name = "IS_SECURE")
    private Boolean isSecure;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

}