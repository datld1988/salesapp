package com.salesapp.saleskitservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewsTagDto {
    private String title;
    private String image;
    private String priority;
    private String content;
    private List<TagsDto> tagList;

    public NewsTagDto(String title, String image, String priority, List<TagsDto> tagList) {
        this.title = title;
        this.image = image;
        this.priority = priority;
        this.content = null;
        this.tagList = tagList;
    }
}
