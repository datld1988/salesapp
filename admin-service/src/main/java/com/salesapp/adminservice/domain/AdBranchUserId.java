package com.salesapp.adminservice.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class AdBranchUserId implements Serializable {
    private String branchId;
    private String userId;
}
