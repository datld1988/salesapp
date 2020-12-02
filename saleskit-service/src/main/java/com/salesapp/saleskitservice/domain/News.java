package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAPP_NEWS")
@Data
public class News implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "ID_GROUP_PRODUCT")
    private Integer idGroupProduct;

    @Column(name = "ID_GROUP_CUSTOMER")
    private Integer idGroupCustomer;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "PUBLISHING_DATE")
    private Date pubDate;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_BY")
    private String createdBy;

    @Column(name = "MODIFY_BY")
    private String modifyBy;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;
}
