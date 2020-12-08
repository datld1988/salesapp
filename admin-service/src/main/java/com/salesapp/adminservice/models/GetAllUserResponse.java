package com.salesapp.adminservice.models;

import com.salesapp.adminservice.domain.AdUserPortal;
import com.salesapp.adminservice.dto.AdBranchUserDto;
import com.salesapp.adminservice.dto.AdUserPortalDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetAllUserResponse {
    private AdUserPortalDto userPortal;
    private List<AdBranchUserDto> listBranch;
}
