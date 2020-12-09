package com.salesapp.saleskitservice.controller;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.constant.TagsConst;
import com.salesapp.saleskitservice.dto.TagsDto;
import com.salesapp.saleskitservice.model.InsertTagRequest;
import com.salesapp.saleskitservice.model.SearchTagRequest;
import com.salesapp.saleskitservice.model.UpdateTagRequest;
import com.salesapp.saleskitservice.service.TagsService;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "tags")
public class TagsController {
    @Autowired
    private TagsService tagsService;


    /**
     * UPDATE: DUNGTQ
     * date : 4/12/2020
     * Thêm loại tag vào dữ liệu
     * @param :
     * @return : kết quả insert tag
     */
    @RequestMapping(path = "insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response insertTag(@RequestBody @Valid InsertTagRequest request) {
        return tagsService.insertTags(request);
    }

    /**
     * update tag
     * @param request
     * @return kết quả update
     */
    @RequestMapping(path = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response upadteTag(@RequestBody @Valid UpdateTagRequest request) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return tagsService.updateTags(request, user);
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
    public Response findAnyTagsByType(@RequestParam("type") String typeKey) {
        return tagsService.findAnyTagsByType(typeKey);
    }

    /**
     * dungtq - search tag with type
     * @return
     */
    @RequestMapping(path = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getAllTagForTypeNew() {
        return tagsService.getAllTagForTypeNew();
    }

    /**
     * dungtq - getAllTag for portal
     * @return
     */
    @RequestMapping(path = "getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getAllTags() {
        return tagsService.getAllTags();
    }

    /**
     * dungtq- get info tags for portal
     * @param tagId
     * @return
     */
    @RequestMapping(path = "getInfoTag", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getInfoTag( @RequestParam
                                    @NotEmpty(message = "tag id not empty")
                                    @NotNull(message = "tag id is not null")
                                    @Valid       Integer tagId) {
        return tagsService.getInfoTag(tagId);
    }

    /**
     * truongnh - search tags for portal
     * @param request
     * @return
     */
    @RequestMapping(path = "search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response searchTag(@RequestBody SearchTagRequest request) {
        return tagsService.searchTags(request);
    }

    @RequestMapping(path = "delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response deleteTag(@RequestParam @Valid @NotNull Integer tagId) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return tagsService.deleteTag(tagId, user);
    }

}
