package com.uniform.authservice.domain;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AD_ROLE")
@Data
public class AdRole implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

}