package com.salesapp.saleskitservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class TagsUserPortalId implements Serializable {
    private String userPortalId;
    private Integer idTag;
    private String tagType;
}
