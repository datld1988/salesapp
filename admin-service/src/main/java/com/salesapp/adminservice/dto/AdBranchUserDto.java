package com.salesapp.adminservice.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdBranchUserDto {
    @NotNull(message = "branchId {not.empty}")
    private String branchId;
    @NotNull(message = "userId {not.empty}")
    private String userId;
    private String branchName;
    private String branchAddress;
}
