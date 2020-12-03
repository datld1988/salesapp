package com.salesapp.adminservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class AdRoleRightId implements Serializable {
    private String roleId;
    private String rightId;
}
