package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAPP_USER_NEWS_VIEW")
@Data
@IdClass(UserNewsViewId.class)
public class UserNewsView implements Serializable {

//    @Id
//    @Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_NEWS_SEQ")
//    @SequenceGenerator(sequenceName = "SAPP_USER_NEWS_VIEW_SEQ", allocationSize = 1, name = "USER_NEWS_SEQ")
//    private Integer id;
    @Id
    @Column(name = "ID_USER")
    private String idUser;

    @Id
    @Column(name = "ID_NEWS")
    private Integer idNews;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "MODIFY_BY")
    private String modifyBy;


}
