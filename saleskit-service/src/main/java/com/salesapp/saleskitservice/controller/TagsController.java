package com.salesapp.saleskitservice.controller;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.constant.TagsConst;
import com.salesapp.saleskitservice.dto.TagsDto;
import com.salesapp.saleskitservice.model.InsertTagRequest;
import com.salesapp.saleskitservice.model.UpdateTagRequest;
import com.salesapp.saleskitservice.service.TagsService;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
    public Response insertTag(@RequestBody InsertTagRequest request) {
        return tagsService.insertTags(request);
    }

    /**
     * update tag
     * @param request
     * @return kết quả update
     */
    @RequestMapping(path = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response upadteTag(@RequestBody UpdateTagRequest request) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return tagsService.updateTags(request, user);
    }

    /**
     * author: anhld
     * date : 4/12/2020
     * thêm tag vào bất kỳ thứ gì
     * @param :
     * @return : kết quả insert tag vào bất kỳ thứ gì
     */
//    @RequestMapping(path = "tagAny", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Response insertTagsAny(@RequestBody In assignTagRequest) {
//        return tagsService.insertTagsAny(assignTagRequest);
//    }

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


    @RequestMapping(path = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getAllTag() {
        return tagsService.getAllTag();
    }
}
