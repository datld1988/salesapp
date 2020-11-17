package com.uniform.processservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AD_SECTOR")
@Data
public class AdSector implements Serializable {

    @Id
    @Column(name = "CODE")
    private String code;
    @Column(name = "CUSTOMER_TYPE")
    private String customerType;
    @Column(name = "MAIN_SECTOR")
    private String mainSector;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NAME_F")
    private String nameF;
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