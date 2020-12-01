package com.salesapp.customerservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CL_STATUS")
@Data
public class ClStatus implements Serializable {

    @Id
    @Column(name = "CODE")
    private String code;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NAME_F")
    private String nameF;

}