package com.uniform.processservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DW_PERSON")
@Data
public class DwPerson implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "PROCESS_ID")
    private String ProcessId;
    @Column(name = "FULL_NAME")
    private String FullName;
    @Column(name = "PER_DOC_TYPE")
    private String PerDocType;
    @Column(name = "PER_DOC_NO")
    private String PerDocNo;
    @Column(name = "ISSUE_PLACE")
    private String IssuePlace;
    @Column(name = "ISSUE_DATE")
    private Date IssueDate;
    @Column(name = "PASSPORT")
    private String Passport;
    @Column(name = "PASSPORT_ISSUE_PLACE")
    private String PassportIssuePlace;
    @Column(name = "PASSPORT_ISSUE_DATE")
    private Date PassportIssueDate;
    @Column(name = "PASSPORT_EXP_DATE")
    private Date PassportExpDate;
    @Column(name = "GENDER")
    private String Gender;
    @Column(name = "MARITAL_STATUS")
    private String MaritalStatus;
    @Column(name = "BIRD_DATE")
    private Date BirdDate;
    @Column(name = "BORN_OF_PLACE")
    private String BornOfPlace;
    @Column(name = "MOBILE_PHONE")
    private String MobilePhone;
    @Column(name = "EMAIL")
    private String Email;
    @Column(name = "NATIONALITY_CODE")
    private String NationalityCode;
    @Column(name = "R_COUNTRY_CODE")
    private String RCountryCode;
    @Column(name = "R_DISTRICT_CODE")
    private String RDistrictCode;
    @Column(name = "R_WARD_CODE")
    private String RWardCode;
    @Column(name = "R_STREET_NUMBER")
    private String RStreetNumber;
    @Column(name = "C_COUNTRY_CODE")
    private String CCountryCode;
    @Column(name = "C_DISTRICT_CODE")
    private String CDistrictCode;
    @Column(name = "C_WARD_CODE")
    private String CWardCode;
    @Column(name = "C_STREET_NUMBER")
    private String CStreetNumber;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;

}