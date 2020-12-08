package com.salesapp.adminservice.models;

import com.salesapp.adminservice.dto.AdBranchUserDto;
import com.salesapp.adminservice.dto.AdUserPortalDto;
import com.salesapp.adminservice.dto.TagsDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateAdUserPortalRequest {
    private AdUserPortalDto userPortal;
    private List<AdBranchUserDto> userBranchList;
    private List<TagsDto> listTagQnA;
    private List<TagsDto> listTagNews;
    private List<TagsDto> listTagKPI;
    private List<TagsDto> listTagTool;
}
