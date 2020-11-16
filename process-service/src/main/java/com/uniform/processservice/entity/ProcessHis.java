package com.uniform.processservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROCESS_HIS")
@Data
public class ProcessHis implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "PROCESS_ID")
    private String ProcessId;
    @Column(name = "STEP")
    private String Step;
    @Column(name = "STEP_BY")
    private String StepBy;
    @Column(name = "STEP_DATE")
    private Date StepDate;
    @Column(name = "NOTE")
    private String Note;

}