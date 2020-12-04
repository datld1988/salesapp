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
    /**
     * author: anhld
     * date : 4/12/2020
     * Thêm loại tag vào dữ liệu
     * @param :
     * @return : kết quả insert tag
     */
    @RequestMapping(path = "insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response<FilterQuestionAndAnswerResponse> insertTag(@RequestBody TagsDto tagsDto) {
        return tagsService.insertTags(tagsDto);
    }
    /**
     * author: anhld
     * date : 4/12/2020
     * thêm tag vào bất kỳ thứ gì
     * @param :
     * @return : kết quả insert tag vào bất kỳ thứ gì
     */
    @RequestMapping(path = "tagAny", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response<FilterQuestionAndAnswerResponse> insertTagsAny(@RequestBody AssignTagRequest assignTagRequest) {
        return tagsService.insertTagsAny(assignTagRequest);
    }
    /**
     * author: anhld
     * date : 4/12/2020
     * tìm kiếm tất cả kết quả có type
     * @param typeKey: từ khóa để tìm kiếm type
     * @return : danh sách có chứa type đã nhập
     */
    @RequestMapping(path = "searchType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response<FilterQuestionAndAnswerResponse> findAnyTagsByType(@RequestParam("type") String typeKey) {
        return tagsService.findAnyTagsByType(typeKey);
    }
}
