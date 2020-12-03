package com.salesapp.adminservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdRoleMenuDto {
    private String id;

    private String roleId;

    private String menuId;

    private String status;
}
