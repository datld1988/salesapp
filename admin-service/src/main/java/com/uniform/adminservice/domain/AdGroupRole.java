package com.uniform.adminservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AD_GROUP_ROLE")
@Data
public class AdGroupRole implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "GROUP_ID")
    private String groupId;
    @Column(name = "ROLE_ID")
    private String roleId;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

}