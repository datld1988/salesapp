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
    private List<String> assignee;

}
