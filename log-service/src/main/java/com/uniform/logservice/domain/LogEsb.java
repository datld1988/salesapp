package com.uniform.logservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LOG_ESB")
@Data
public class LogEsb implements Serializable {

    @Id
    @Column(name = "REQUEST_ID")
    private String requestId;
    @Column(name = "SERVICE_CODE")
    private String serviceCode;
    @Column(name = "INPUT_DATA")
    private String inputData;
    @Column(name = "OUTPUT_DATA")
    private String outputData;
    @Column(name = "DURATION_TIME")
    private Long durationTime;
    @Column(name = "USER_REQUEST")
    private String userRequest;
    @Column(name = "OBJECT_ID")
    private String objectId;
    @Column(name = "REF_OBJECT1_ID")
    private String refObject1Id;
    @Column(name = "REF_OBJECT2_ID")
    private String refObject2Id;
    @Column(name = "REF_OBJECT3_ID")
    private String refObject3Id;
    @Column(name = "REQUEST_DATE")
    private Date requestDate;
    @Column(name = "RESPONSE_CODE")
    private String responseCode;
    @Column(name = "RESPONSE_MSG")
    private String responseMsg;
    @Column(name = "IS_SUCCESS")
    private Boolean isSuccess;

}