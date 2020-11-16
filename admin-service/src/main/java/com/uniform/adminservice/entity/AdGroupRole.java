package com.uniform.adminservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AD_GROUP_ROLE")
@Data
public class AdGroupRole implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "GROUP_ID")
    private String GroupId;
    @Column(name = "ROLE_ID")
    private String RoleId;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;

}