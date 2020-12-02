package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TAGS_NEW")
@Data
public class TagsNew implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ID_TAG")
    private Integer idTag;

    @Column(name = "ID_NEW")
    private Integer idNew;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "MODIFY_BY")
    private String modifyBy;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;
}
