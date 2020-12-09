package com.salesapp.saleskitservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TagsUserPortalDto {
    private  Integer tagId;
    private  String  tagValue;
    private String tagKey;
    private List<String> tagType;
    private List<UserPortalDto> assignee;

    public TagsUserPortalDto(Integer tagId, String tagValue, String tagKey) {
        this.tagId = tagId;
        this.tagKey = tagKey;
        this.tagValue = tagValue;

    }
}
