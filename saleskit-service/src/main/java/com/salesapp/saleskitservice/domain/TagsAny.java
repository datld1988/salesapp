package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAPP_TAGS_ANY")
@Data
@IdClass(TagsAnyId.class)
public class TagsAny implements Serializable {

    @Id
    @Column(name = "ID_TAG")
    private Integer idTag;

    @Id
    @Column(name = "ID_ANY")
    private String idAny;

    @Id
    @Column(name = "TYPE_ANY")
    private String typeAny;

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
