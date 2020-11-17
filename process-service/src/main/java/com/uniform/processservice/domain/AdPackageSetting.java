package com.uniform.processservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AD_PACKAGE_SETTING")
@Data
public class AdPackageSetting implements Serializable {

    @Id
    @Column(name = "CODE")
    private String code;
    @Column(name = "SERVICE_LIST")
    private String serviceList;
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