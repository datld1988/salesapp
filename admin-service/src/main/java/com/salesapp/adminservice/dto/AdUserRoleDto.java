package com.salesapp.adminservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdUserRoleDto {

    private String userId;

    private String roleId;

    private Integer status;
}
