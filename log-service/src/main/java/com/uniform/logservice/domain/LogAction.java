package com.uniform.logservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LOG_ACTION")
@Data
public class LogAction implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "BROWSER")
    private String browser;
    @Column(name = "IP_CLIENT")
    private String ipClient;
    @Column(name = "IP_SERVER")
    private String ipServer;
    @Column(name = "CONTROLLER_NAME")
    private String controllerName;
    @Column(name = "ACTION_NAME")
    private String actionName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "OTHERS")
    private String others;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "DURATION_TIME")
    private Integer durationTime;
    @Column(name = "OBJECT_ID")
    private String objectId;
    @Column(name = "LOG_TIME")
    private Date logTime;
    @Column(name = "MACHINE_NAME_SERVER")
    private String machineNameServer;

}