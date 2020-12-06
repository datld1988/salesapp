package com.salesapp.adminservice.domain;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class AdUserRoleId implements Serializable {

    private String userId;

    private String roleId;
}
