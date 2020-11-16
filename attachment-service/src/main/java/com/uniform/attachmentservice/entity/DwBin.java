package com.uniform.attachmentservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DW_BIN")
@Data
public class DwBin implements Serializable {

    @Id
    @Column(name = "ID")
    private String Id;
    @Column(name = "FILE_NAME")
    private String FileName;
    @Column(name = "FILE_TYPE")
    private String FileType;
    @Column(name = "FILE_CONTENT")
    private byte[] FileContent;
    @Column(name = "CREATED_BY")
    private String CreatedBy;
    @Column(name = "CREATED_DATE")
    private Date CreatedDate;
    @Column(name = "MODIFIED_BY")
    private String ModifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date ModifiedDate;

}