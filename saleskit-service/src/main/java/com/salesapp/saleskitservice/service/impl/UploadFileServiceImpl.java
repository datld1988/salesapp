package com.salesapp.saleskitservice.service.impl;

import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import com.salesapp.common.utils.UploadFile;
import com.salesapp.saleskitservice.service.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

@Service
public class UploadFileServiceImpl  implements UploadFileService {

    private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "saleskit-service/src/main/resources/";

    //Save the uploaded file to this folder
    private static String HOST_NAME = "222.252.25.241";
    //Save the uploaded file to this folder
    private static int PORT = 10022;
    //Save the uploaded file to this folder
    private static String USER_NAME = "root";
    //Save the uploaded file to this folder
    private static String PASS_WORD = "awt@2019";
    //Save the uploaded file to this folder
    private static String PATH_SERVER_FILE = "/root/fileserver/file/";

    @Autowired
    private MessageSource messageSource;

    /**
     * Upload file from
     *
     * @param file MultipartFile file from Portal
     * @return Result upload
     */
    @Override
    public Response uploadFile(MultipartFile file) {

        if (file.isEmpty()) {

            String mess = messageSource.getMessage("upload_file_missing", null,
                    new Locale("en_US"));
            return Response.error(ErrorCode.NOT_FOUND_RECORDS, mess);
        }

        try {

            UploadFile ftp = new UploadFile(HOST_NAME, PORT, USER_NAME, PASS_WORD);

            // Upload to
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            // Upload to server
            StringBuilder pathFileResource = new StringBuilder(UPLOADED_FOLDER).append(file.getOriginalFilename());
            ftp.upload(pathFileResource.toString(), PATH_SERVER_FILE);

            Files.delete(Paths.get(pathFileResource.toString()));


        } catch (IOException e) {
            String mess = messageSource.getMessage("upload_file_error", null,
                    new Locale("en_US"));
            return Response.error(ErrorCode.NOT_FOUND, mess);
        }

        String mess = messageSource.getMessage("upload_file_success", null,
                new Locale("en_US"));
        return Response.success(mess);
    }
}
