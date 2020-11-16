package com.uniform.processservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DW_CUSTOMER")
@Data
public class DwCustomer implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "PROCESS_ID")
    private String ProcessId;
    @Column(name = "PARENT_ID")
    private String ParentId;
    @Column(name = "PERSON_ID")
    private String PersonId;
    @Column(name = "ORGANIZATION_ID")
    private String OrganizationId;
    @Column(name = "CUSTOMER_TYPE_CODE")
    private String CustomerTypeCode;
    @Column(name = "SECTOR")
    private String Sector;
    @Column(name = "RM_PRIMARY_CODE")
    private String RmPrimaryCode;
    @Column(name = "RM_SECONDARY_CODE")
    private String RmSecondaryCode;
    @Column(name = "BRANCH_CODE")
    private String BranchCode;
    @Column(name = "CONTACT_DATE")
    private Date ContactDate;
    @Column(name = "ACTION")
    private String Action;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;

}