package com.salesapp.customerservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PROCESS_INTEGRATED_HIS")
@Data
public class ProcessIntegratedHis implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "PROCESS_ID")
    private String processId;
    @Column(name = "INTEGRATED_ID")
    private String integratedId;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "EXECUTE_BY")
    private String executeBy;
    @Column(name = "EXECUTE_DATE")
    private Date executeDate;

}