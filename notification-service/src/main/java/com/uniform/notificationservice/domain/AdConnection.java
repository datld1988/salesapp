package com.uniform.notificationservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AD_CONNECTION")
@Data
public class AdConnection implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "CONNECTION_NAME")
    private String connectionName;
    @Column(name = "CONNECTION_STRING")
    private String connectionString;
    @Column(name = "SCHEMA_NAME")
    private String schemaName;
    @Column(name = "DB_TYPE_ID")
    private String dbTypeId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

}