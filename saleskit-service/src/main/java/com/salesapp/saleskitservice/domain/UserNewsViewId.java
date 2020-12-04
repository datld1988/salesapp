package com.salesapp.saleskitservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class UserNewsViewId implements Serializable {
    private String idUser;
    private Integer idNews;
}
