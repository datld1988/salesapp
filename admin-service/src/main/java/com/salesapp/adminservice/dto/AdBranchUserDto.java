package com.salesapp.adminservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdBranchUserDto {
    private String id;
    private String branchId;
    private String userId;
}
