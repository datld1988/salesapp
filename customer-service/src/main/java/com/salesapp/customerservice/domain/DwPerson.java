package com.salesapp.customerservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DW_PERSON")
@Data
public class DwPerson implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "PROCESS_ID")
    private String processId;
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "PER_DOC_TYPE")
    private String perDocType;
    @Column(name = "PER_DOC_NO")
    private String perDocNo;
    @Column(name = "ISSUE_PLACE")
    private String issuePlace;
    @Column(name = "ISSUE_DATE")
    private Date issueDate;
    @Column(name = "PASSPORT")
    private String passport;
    @Column(name = "PASSPORT_ISSUE_PLACE")
    private String passportIssuePlace;
    @Column(name = "PASSPORT_ISSUE_DATE")
    private Date passportIssueDate;
    @Column(name = "PASSPORT_EXP_DATE")
    private Date passportExpDate;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;
    @Column(name = "BIRD_DATE")
    private Date birdDate;
    @Column(name = "BORN_OF_PLACE")
    private String bornOfPlace;
    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NATIONALITY_CODE")
    private String nationalityCode;
    @Column(name = "R_COUNTRY_CODE")
    private String rCountryCode;
    @Column(name = "R_DISTRICT_CODE")
    private String rDistrictCode;
    @Column(name = "R_WARD_CODE")
    private String rWardCode;
    @Column(name = "R_STREET_NUMBER")
    private String rStreetNumber;
    @Column(name = "C_COUNTRY_CODE")
    private String cCountryCode;
    @Column(name = "C_DISTRICT_CODE")
    private String cDistrictCode;
    @Column(name = "C_WARD_CODE")
    private String cWardCode;
    @Column(name = "C_STREET_NUMBER")
    private String cStreetNumber;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

}