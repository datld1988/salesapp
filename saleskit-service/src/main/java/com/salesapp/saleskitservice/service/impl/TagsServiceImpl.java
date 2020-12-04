package com.salesapp.saleskitservice.service.impl;

import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import com.salesapp.saleskitservice.constant.TagsConst;
import com.salesapp.saleskitservice.domain.Tags;
import com.salesapp.saleskitservice.domain.TagsAny;
import com.salesapp.saleskitservice.domain.TagsAnyId;
import com.salesapp.saleskitservice.dto.TagsAnyDto;
import com.salesapp.saleskitservice.dto.TagsDto;
import com.salesapp.saleskitservice.model.AssignTagRequest;
import com.salesapp.saleskitservice.repository.TagsAnyRepository;
import com.salesapp.saleskitservice.repository.TagsRepository;
import com.salesapp.saleskitservice.service.TagsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
    @Override
    public Response insertTags(TagsDto tagsDto) {
        Tags tags = new Tags();
        try {
            TagsDto tagExisted = tagsRepository.checkTags(tagsDto.getValue());
            if (tagExisted == null){
                String user = SecurityContextHolder.getContext().getAuthentication().getName();
                tags.setValue(tagsDto.getValue());
                tags.setStatus(tagsDto.getStatus());
                tags.setCreateDate(new Date());
                tags.setCreateBy(user);
                tagsRepository.save(tags);
                return Response.success("insert tag successful");
            }
            else {
                return Response.error("","Tag existed");
            }

        }
        catch (Exception e){
            log.error("insertTags Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }

    }

    @Override
    public Response insertTagsAny(AssignTagRequest request) {
        List<TagsAny> tagsAnyList = new ArrayList<>();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        try{

            if (request.getTagsAnyId().size() >=1){
                for (TagsAnyId tagsAnyId: request.getTagsAnyId()){
                    TagsDto tagExisted = tagsAnyRepository.checkTags(tagsAnyId.getIdTag(), tagsAnyId.getIdAny(), tagsAnyId.getTypeAny());

                    TagsAny tagsAny = new TagsAny();
                    tagsAny.setIdAny(tagsAnyId.getIdAny());
                    tagsAny.setIdTag(tagsAnyId.getIdTag());
                    tagsAny.setTypeAny(tagsAnyId.getTypeAny());
                    tagsAny.setStatus(1);
                    tagsAny.setCreateBy(user);
                    tagsAny.setCreateDate(new Date());
                    tagsAnyList.add(tagsAny);
                }
                tagsAnyRepository.saveAll(tagsAnyList);

            }
            return Response.success("tag successful");
        }
        catch (Exception e){
            log.error("insertTagsAny Exception : " + e.toString(), e);
            return Response.error(ErrorCode.ERROR_STATUS, e.toString());
        }
    }

    @Override
    public Response findAnyByTags(String tag) {
        return null;
    }


}
