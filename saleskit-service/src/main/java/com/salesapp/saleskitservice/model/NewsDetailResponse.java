package com.salesapp.saleskitservice.model;

import com.salesapp.saleskitservice.dto.NewsDto;
import com.salesapp.saleskitservice.dto.TagsAnyDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewsDetailResponse {
    NewsDto newsDto;
    List<TagsAnyDto> tagOfNews;
}
