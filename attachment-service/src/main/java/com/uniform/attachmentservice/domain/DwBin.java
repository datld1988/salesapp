package com.uniform.attachmentservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DW_BIN")
@Data
public class DwBin implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "FILE_NAME")
    private String fileName;
    @Column(name = "FILE_TYPE")
    private String fileType;
    @Column(name = "FILE_CONTENT")
    private byte[] fileContent;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

}