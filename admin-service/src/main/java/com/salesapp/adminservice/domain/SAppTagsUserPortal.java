package com.salesapp.adminservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SAPP_TAGS_USER_PORTAL", schema = "SALES_APP_CNSP")
@IdClass(SAppTagsUserPortalId.class)
public class SAppTagsUserPortal implements Serializable {
    @Id
    @Column(name = "USER_PORTAL_ID")
    private String userPortalId;

    @Id
    @Column(name = "TAG_ID")
    private Integer tagId;

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

    @Id
    @Column(name = "TAG_TYPE")
    private String tagType;
}
