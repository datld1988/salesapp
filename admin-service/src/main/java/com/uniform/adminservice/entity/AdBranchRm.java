package com.uniform.adminservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AD_BRANCH_RM")
@Data
public class AdBranchRm implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "RM_ID")
    private String RmId;
    @Column(name = "BRANCH_ID")
    private String BranchId;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;

}