package com.salesapp.saleskitservice.model;

import com.salesapp.saleskitservice.domain.TagsAny;
import com.salesapp.saleskitservice.domain.TagsAnyId;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssignTagRequest {
    private List<TagsAnyId> tagsAnyId;
}
