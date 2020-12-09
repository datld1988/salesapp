package com.salesapp.adminservice.models;

import com.salesapp.adminservice.dto.AdBranchUserDto;
import com.salesapp.adminservice.dto.AdUserPortalDto;
import com.salesapp.adminservice.dto.SAppTagsUserPortalDto;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetUserPortalDetailResponse {
    private AdUserPortalDto userPortal;
    private List<AdBranchUserDto> userBranchList;
    private List<SAppTagsUserPortalDto> listTagQnA;
    private List<SAppTagsUserPortalDto> listTagNews;
    private List<SAppTagsUserPortalDto> listTagKPI;
    private List<SAppTagsUserPortalDto> listTagTool;
}
