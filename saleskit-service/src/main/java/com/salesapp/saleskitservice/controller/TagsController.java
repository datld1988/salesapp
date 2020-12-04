package com.salesapp.saleskitservice.controller;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.TagsDto;
import com.salesapp.saleskitservice.model.AssignTagRequest;
import com.salesapp.saleskitservice.model.FilterQuestionAndAnswerRequest;
import com.salesapp.saleskitservice.model.FilterQuestionAndAnswerResponse;
import com.salesapp.saleskitservice.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "tags")
public class TagsController {
    @Autowired
    private TagsService tagsService;

    @RequestMapping(path = "insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response<FilterQuestionAndAnswerResponse> filterQuestionAndAnswer(@RequestBody TagsDto tagsDto) {
        return tagsService.insertTags(tagsDto);
    }

    @RequestMapping(path = "tagAny", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response<FilterQuestionAndAnswerResponse> filterQuestionAndAnswer(@RequestBody AssignTagRequest assignTagRequest) {
        return tagsService.insertTagsAny(assignTagRequest);
    }
}
