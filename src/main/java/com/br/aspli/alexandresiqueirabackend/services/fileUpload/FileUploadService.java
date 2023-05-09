package com.br.aspli.alexandresiqueirabackend.services.fileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService implements IFileUploadService {

    @Autowired
    private AwsService _awsService;

    public String upload(MultipartFile file, String fileName) {
        var fileUri = "";

        try {
            fileUri = _awsService.upload(file, fileName);
        } catch (Exception e) {

        }

        return fileUri;
    }
}
