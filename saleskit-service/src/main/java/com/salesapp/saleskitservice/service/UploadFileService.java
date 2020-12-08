package com.salesapp.saleskitservice.service;

import com.salesapp.common.dto.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 */
public interface UploadFileService {

    /**
     * Upload file from
     * @param file MultipartFile file from Portal
     *
     * @return Result upload
     */
    Response uploadFile(MultipartFile file);
}
