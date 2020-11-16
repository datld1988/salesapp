package com.uniform.processservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROCESS_INTEGRATED_HIS")
@Data
public class ProcessIntegratedHis implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "PROCESS_ID")
    private String ProcessId;
    @Column(name = "INTEGRATED_ID")
    private String IntegratedId;
    @Column(name = "STATUS")
    private String Status;
    @Column(name = "EXECUTE_BY")
    private String ExecuteBy;
    @Column(name = "EXECUTE_DATE")
    private Date ExecuteDate;

}