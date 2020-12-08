package com.salesapp.saleskitservice.service;

import com.salesapp.common.dto.Response;
import com.salesapp.saleskitservice.dto.TagsDto;
import com.salesapp.saleskitservice.model.InsertTagRequest;
import com.salesapp.saleskitservice.model.UpdateTagRequest;

public interface TagsService {
    /**
     * author: anhld
     * update: dungtq
     * date : 4/12/2020
     * thêm tag
     * @param
     * @return kết quả của việc thêm tag
     */
    Response insertTags(InsertTagRequest request);

    /**
     * dungtq  - update info tags
     * @param request
     * @return
     */
    Response updateTags(UpdateTagRequest request, String user);

    /**
     * author: anhld
     * date : 4/12/2020
     * gắn tag vào bất kỳ thứ gì
     * @param
     * @return kết quả của việc gắn tag
     */
   // Response insertTagsAny(AssignTagRequest request);

    /**
     * author: anhld
     * date : 4/12/2020
     * tìm mọi thứ có bao gồm type
     * @param type : loại
     * @return danh sách của type
     */
    Response findAnyTagsByType(String type);

    Response getAllTag();
}
