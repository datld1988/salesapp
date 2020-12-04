package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAPP_NEWS")
@Data
public class News implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEWS_SEQ")
    @SequenceGenerator(sequenceName = "SAPP_NEWS_SEQ", allocationSize = 1, name = "NEWS_SEQ")
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "PUBLISHING_DATE")
    private Date pubDate;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "PRIORITY")
    private String priority;

    @Column(name = "FILE_PATH")
    private  String filePath;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_BY")
    private String createdBy;

    @Column(name = "MODIFY_BY")
    private String modifyBy;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;
}
