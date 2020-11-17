package com.uniform.notificationservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CL_DB_TYPE")
@Data
public class ClDbType implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DISPLAY_PRIORITY")
    private Integer displayPriority;

}