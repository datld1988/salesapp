package com.uniform.printoutservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "HIS_DATA_MODEL")
@Data
public class HisDataModel implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "TEMPLATE_ID")
    private String templateId;
    @Column(name = "CONNECTION_ID")
    private String connectionId;
    @Column(name = "CODE")
    private String code;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "IS_MULTI")
    private Boolean isMulti;
    @Column(name = "QUERY_STATEMENT")
    private String queryStatement;
    @Column(name = "QUERY_SAMPLE")
    private String querySample;
    @Column(name = "FIELD_NAMES")
    private String fieldNames;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "HIS_CREATED_DATE")
    private Date hisCreatedDate;

}