package com.salesapp.adminservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class SAppTagsUserPortalId implements Serializable {
    private String userPortalId;
    private Integer tagId;
    private String tagType;
}
