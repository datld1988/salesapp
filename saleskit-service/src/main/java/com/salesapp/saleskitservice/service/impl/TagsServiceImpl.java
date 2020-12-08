package com.salesapp.saleskitservice.service.impl;

import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import com.salesapp.saleskitservice.constant.TagsConst;
import com.salesapp.saleskitservice.domain.*;
import com.salesapp.saleskitservice.dto.TagsAnyDto;
import com.salesapp.saleskitservice.dto.TagsDto;
import com.salesapp.saleskitservice.dto.TagsUserPortalDto;
import com.salesapp.saleskitservice.model.InsertTagRequest;
import com.salesapp.saleskitservice.model.UpdateTagRequest;
import com.salesapp.saleskitservice.repository.TagsAnyRepository;
import com.salesapp.saleskitservice.repository.TagsRepository;
import com.salesapp.saleskitservice.repository.TagsUserPortalRepository;
import com.salesapp.saleskitservice.service.TagsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TagsServiceImpl implements TagsService {
    private final Logger log = LoggerFactory.getLogger(TagsServiceImpl.class);
    @Autowired
    private TagsRepository tagsRepository;

    @Autowired
    private TagsAnyRepository tagsAnyRepository;

    @Autowired
    private TagsUserPortalRepository tagsUserPortalRepository;
    /**
     * author: anhld
     * date : 4/12/2020
     * @param
     * @return kết quả việc thêm tag
     */
    @Transactional
    @Override
    public Response insertTags(InsertTagRequest request) {
        Tags tags = new Tags();
        try {
            // check existed tag
            TagsDto tagExisted = tagsRepository.checkTags(request.getTagValue().trim());
            if (tagExisted == null){
                // insert table SAPP_TAGS
                String user = SecurityContextHolder.getContext().getAuthentication().getName();
                tags.setValue(request.getTagValue());
                tags.setStatus(TagsConst.StatusActive);
                tags.setCreateDate(new Date());
                tags.setCreateBy(user);
                Tags tags_new = tagsRepository.save(tags);

                // insert table SAPP_TAGS_USER_PORTAL
                List<TagsUserPortal> lstTUP = new ArrayList<>();
                for (String type: request.getTagType()) {
                    for (String assignee: request.getAssignee()) {
                            TagsUserPortal item = new TagsUserPortal();
                            item.setIdTag(tags_new.getId());
                            item.setTagType(type);
                            item.setUserPortalId(assignee);
                            item.setStatus(TagsConst.StatusActive);
                            item.setCreateDate(new Date());
                            item.setCreateBy(user);
                            lstTUP.add(item);
                    }
                }
                tagsUserPortalRepository.saveAll(lstTUP);

                return Response.success("insert tag successful");
            }
            else {
                return Response.error(ErrorCode.OBJECT_EXISTED,"Tag existed");
            }

        }
        catch (Exception e){
            log.error("insertTags Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }

    }

    /**
     * dungtq - update info tags
     * @param request
     * @return
     */
    @Transactional
    @Override
    public Response updateTags(UpdateTagRequest request, String user) {

        try {
            // check tag existed
            if(tagsRepository.findById(request.getTagId()).isPresent()) {
                Tags tag = tagsRepository.getTagsByIdAndStatus(request.getTagId(), TagsConst.StatusActive);
                tag.setId(request.getTagId());
                tag.setValue(request.getTagValue());
                tag.setModifyDate(new Date());
                tag.setModifyBy(user);
                // update table SAPP_TAGS
                Tags tags_new = tagsRepository.save(tag);


                List<TagsUserPortal> lstTUP = new ArrayList<>();
                for (String type: request.getTagType()) {
                    for (String assignee: request.getAssignee()) {
                        TagsUserPortal item = new TagsUserPortal();
                        item.setIdTag(tags_new.getId());
                        item.setTagType(type);
                        item.setUserPortalId(assignee);
                        item.setStatus(TagsConst.StatusActive);
                        item.setCreateDate(new Date());
                        item.setCreateBy(user);
                        lstTUP.add(item);

                        // delete old records
                        tagsUserPortalRepository.deleteTagsUserPortalByIdTag(item.getIdTag());

                    }
                }
                // insert new records in table tagsUserPortal
                tagsUserPortalRepository.saveAll(lstTUP);
                return Response.success("update tag successful");
            } else
                return Response.error(ErrorCode.NOT_FOUND_RECORDS, "Không tìm thấy tag id");

        }
        catch (Exception e){
            log.error("update tags Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }

    /**
     * author: anhld
     * date : 4/12/2020
     * @param
     * @return kết quả việc gắn tag
     */
//    @Override
//    public Response insertTagsAny(AssignTagRequest request) {
//        List<TagsAny> tagsAnyList = new ArrayList<>();
//        String user = SecurityContextHolder.getContext().getAuthentication().getName();
//        try{
//            boolean ableToAdd = true;
//            if (request.getTagsAnyId().size() >=1){
//                for (TagsAnyId tagsAnyId: request.getTagsAnyId()){
////                    TagsAnyDto tagExisted = tagsAnyRepository.checkTags(tagsAnyId.getIdTag(), tagsAnyId.getIdAny(), tagsAnyId.getTypeAny());
//
//                    if (/*tagExisted == null &&*/ ableToAdd){
//                        TagsAny tagsAny = new TagsAny();
//                        tagsAny.setIdAny(tagsAnyId.getIdAny());
//                        tagsAny.setIdTag(tagsAnyId.getIdTag());
//                        tagsAny.setTypeAny(tagsAnyId.getTypeAny());
//                        tagsAny.setStatus(1);
//                        tagsAny.setCreateBy(user);
//                        tagsAny.setCreateDate(new Date());
//                        tagsAnyList.add(tagsAny);
//                        ableToAdd = true;
//                    }
//                    else {
//                        ableToAdd = false;
//                    }
//                }
//            }
//            else {
//                ableToAdd = false;
//            }
//            if (ableToAdd){
//                tagsAnyRepository.saveAll(tagsAnyList);
//                return Response.success("tag successful");
//            }
//            else {
//                return Response.error("408","tag failed");
//            }
//        }
//        catch (Exception e){
//            log.error("insertTagsAny Exception : " + e.toString(), e);
//            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
//        }
//    }

    /**
     * author: anhld
     * date : 4/12/2020
     * @param type: loại
     * @return danh sách những thứ có chứa type
     */
    @Override
    public Response findAnyTagsByType(String type) {
        try {
            List<TagsAnyDto> tagsAnyDtoList = tagsAnyRepository.searchByTypeAny(type);
            if (tagsAnyDtoList.isEmpty()){
                return Response.error(ErrorCode.NOT_FOUND_RECORDS, "No record was found");
            }
            else{
                return Response.success(tagsAnyDtoList);
            }
        }
        catch (Exception e){
            log.error("findAnyByTags Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }
    /**
     * author: anhld
     * date : 7/12/2020
     * @param
     * @return danh sách các tag
     */
    @Override
    public Response getAllTagForTypeNew() {
        try{
            List<TagsDto> tagsDtoList = tagsRepository.getAllTagForTypeNew();
                if (tagsDtoList.size() >=1){
                    return Response.success(tagsDtoList);
                }
                else {
                    return Response.error(ErrorCode.NOT_FOUND_RECORDS,"No record found");
                }
        }
        catch (Exception e){
            log.error("getAllTag Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }

    @Override
    public Response getAllTags() {
        try {
            List<TagsUserPortalDto> lst = tagsRepository.getAllTags();

            return Response.success(lst);
        } catch (Exception e) {
            log.error("getAllTag Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }

    @Override
    public Response getInfoTag(Integer tagId) {
        try {
            Tags tags = tagsRepository.getTagsById(tagId);
            TagsUserPortalDto dto = new TagsUserPortalDto();
            dto.setTagId(tags.getId());
            dto.setTagValue(tags.getValue());
            dto.setTagKey(tags.getKeyTag());
            dto.setTagType(tagsUserPortalRepository.getAllTypeOfTag(tagId));
            dto.setAssignee(tagsUserPortalRepository.getAllUserAssignTags(tagId));
            return Response.success(dto);
        } catch (Exception e) {
            log.error("getAllTag Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }


}
