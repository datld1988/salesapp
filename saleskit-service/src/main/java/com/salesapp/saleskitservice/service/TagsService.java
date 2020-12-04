package com.salesapp.saleskitservice.service;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.TagsDto;
import com.salesapp.saleskitservice.model.AssignTagRequest;

public interface TagsService {
    Response insertTags(TagsDto tagsDto);
    Response insertTagsAny(AssignTagRequest request);
    Response findAnyByTags(String tag);
}
