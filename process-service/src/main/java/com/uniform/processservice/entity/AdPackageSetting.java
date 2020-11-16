package com.uniform.processservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AD_PACKAGE_SETTING")
@Data
public class AdPackageSetting implements Serializable {

    @Id
    @Column(name = "CODE")
    private String Code;
    @Column(name = "SERVICE_LIST")
    private String ServiceList;
    @Column(name = "DISPLAY_PRIORITY")
    private Integer DisplayPriority;
    @Column(name = "STATUS_CODE")
    private String StatusCode;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;

}