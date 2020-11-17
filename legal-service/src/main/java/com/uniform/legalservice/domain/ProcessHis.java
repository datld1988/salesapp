package com.uniform.legalservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PROCESS_HIS")
@Data
public class ProcessHis implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "PROCESS_ID")
    private String processId;
    @Column(name = "STEP")
    private String step;
    @Column(name = "STEP_BY")
    private String stepBy;
    @Column(name = "STEP_DATE")
    private Date stepDate;
    @Column(name = "NOTE")
    private String note;
    @Column(name = "HIS_CREATED_DATE")
    private Date hisCreatedDate;

}