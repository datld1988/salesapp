package com.salesapp.adminservice.models;

import com.salesapp.adminservice.dto.AdRoleDto;
import com.salesapp.adminservice.dto.UserDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssignUserRoleRequest {
    private UserDto userInfo;
    private List<AdRoleDto> roleList;
}
