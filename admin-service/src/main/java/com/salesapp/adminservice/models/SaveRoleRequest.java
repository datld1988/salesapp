package com.salesapp.adminservice.models;

import com.salesapp.adminservice.dto.AdRoleMenuDto;
import com.salesapp.adminservice.dto.AdRoleRightDto;
import com.salesapp.adminservice.dto.AdRoleDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaveRoleRequest {
    private AdRoleDto roleInfo;

    private List<AdRoleMenuDto> menuList;

    private List<AdRoleRightDto> rightList;
}
