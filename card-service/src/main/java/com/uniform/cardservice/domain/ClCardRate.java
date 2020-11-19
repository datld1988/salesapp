package com.uniform.cardservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CL_CARD_RATE")
@Data
public class ClCardRate implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NAME_F")
    private String nameF;
    @Column(name = "IS_INDIV")
    private Boolean isIndiv;
    @Column(name = "IS_ORG")
    private Boolean isOrg;
    @Column(name = "DISPLAY_PRIORITY")
    private Integer displayPriority;
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

}