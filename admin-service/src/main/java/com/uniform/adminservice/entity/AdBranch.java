package com.uniform.adminservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AD_BRANCH")
@Data
public class AdBranch implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "PARENT_ID")
    private String ParentId;
    @Column(name = "NAME")
    private String Name;
    @Column(name = "CODE")
    private String Code;
    @Column(name = "PHONE")
    private String Phone;
    @Column(name = "FAX")
    private String Fax;
    @Column(name = "CONTACT_NAME")
    private String ContactName;
    @Column(name = "EMAIL")
    private String Email;
    @Column(name = "ADDRESS")
    private String Address;
    @Column(name = "CITY_CODE")
    private String CityCode;
    @Column(name = "DISTRICT_CODE")
    private String DistrictCode;
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