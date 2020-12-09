package com.salesapp.adminservice.models;

import com.salesapp.adminservice.dto.AdBranchUserDto;
import com.salesapp.adminservice.dto.AdUserPortalDto;
import com.salesapp.adminservice.dto.SAppTagsUserPortalDto;
import lombok.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateUserPortalRequest implements Serializable {
    @Valid
    private AdUserPortalDto userPortal;
    private Integer isChangePassword;
    @Valid
    private List<AdBranchUserDto> userBranchList;
    private List<SAppTagsUserPortalDto> listTagQnA;
    private List<SAppTagsUserPortalDto> listTagNews;
    private List<SAppTagsUserPortalDto> listTagKPI;
    private List<SAppTagsUserPortalDto> listTagTool;
}
