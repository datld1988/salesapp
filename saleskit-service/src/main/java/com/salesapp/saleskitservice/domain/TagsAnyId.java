package com.salesapp.saleskitservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class TagsAnyId implements Serializable {
    private Integer idTag;
    private String idAny;
    private String typeAny;

}
