package com.uniform.adminservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AD_USER_BRANCH")
@Data
public class AdUserBranch implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "USER_ID")
    private String UserId;
    @Column(name = "BRANCH_ID")
    private String BranchId;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;

}