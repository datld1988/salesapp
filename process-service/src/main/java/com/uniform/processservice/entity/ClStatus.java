package com.uniform.processservice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CL_STATUS")
@Data
public class ClStatus implements Serializable {

    @Id
    @Column(name = "CODE")
    private String Code;
    @Column(name = "NAME")
    private String Name;
    @Column(name = "NAME_F")
    private String NameF;

}