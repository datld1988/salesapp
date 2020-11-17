package com.uniform.adminservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AD_BRANCH")
@Data
public class AdBranch implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "PARENT_ID")
    private String parentId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE")
    private String code;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY_CODE")
    private String cityCode;
    @Column(name = "DISTRICT_CODE")
    private String districtCode;
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