package com.salesapp.adminservice.models;

import com.salesapp.adminservice.dto.AdBranchUserDto;
import com.salesapp.adminservice.dto.AdUserPortalDto;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateAdUserPortalRequest {
    private AdUserPortalDto userPortal;
    private List<AdBranchUserDto> userBranchList;
}
