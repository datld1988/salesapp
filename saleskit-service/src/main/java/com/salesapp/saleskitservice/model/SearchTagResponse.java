package com.salesapp.saleskitservice.model;

import com.salesapp.saleskitservice.dto.TagsUserPortalDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchTagResponse {
    private List<TagsUserPortalDto> tagsList;
    private Long totalItem;
}
