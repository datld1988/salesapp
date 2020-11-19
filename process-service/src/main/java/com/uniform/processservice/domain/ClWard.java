package com.uniform.processservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CL_WARD")
@Data
public class ClWard implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "DISTRICT_ID")
    private String districtId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NAME_F")
    private String nameF;
    @Column(name = "DISPLAY_PRIORITY")
    private Integer displayPriority;
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

}