package com.uniform.printoutservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AD_TEMPLATE")
@Data
public class AdTemplate implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "FILE_TYPE")
    private String fileType;
    @Column(name = "FILE_CONTENT")
    private byte[] fileContent;
    @Column(name = "TEXT_CONTENT")
    private String textContent;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "BOOKMARKS")
    private String bookmarks;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

}