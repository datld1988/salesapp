package com.salesapp.saleskitservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SAPP_TAGS")
@Data
public class Tags implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAGS_SEQ")
    @SequenceGenerator(sequenceName = "SAPP_TAGS_SEQ", allocationSize = 1, name = "TAGS_SEQ")
    private Integer id;

    @Column(name = "KEY_TAG")
    private String keyTag;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "MODIFY_BY")
    private String modifyBy;
}
