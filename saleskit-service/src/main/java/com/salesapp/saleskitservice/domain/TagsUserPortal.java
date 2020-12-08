package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "SAPP_TAGS_USER_PORTAL")
@IdClass(TagsUserPortalId.class)
public class TagsUserPortal implements Serializable {

    @Id
    @Column(name = "USER_PORTAL_ID")
    private String userPortalId;

    @Id
    @Column(name = "TAG_ID")
    private Integer idTag;

    @Id
    @Column(name = "TAGS_TYPE")
    private String tagType;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "MODIFY_BY")
    private String modifyBy;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

}
