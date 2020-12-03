package com.salesapp.adminservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdRoleDto {

    private String id;

    private String name;

    private String description;

    private String statusCode;

    public AdRoleDto(String id)
    {

    }
}
