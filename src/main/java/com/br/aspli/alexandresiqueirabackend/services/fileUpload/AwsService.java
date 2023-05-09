package com.br.aspli.alexandresiqueirabackend.services.fileUpload;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class AwsService {
    @Autowired
    private AmazonS3 amazonS3;

    public String upload(MultipartFile multipartFile, String fileName) throws Exception {
        var fileUri = "";

        try {
            var fileConverted = convertMultiPartToFile(multipartFile);

            amazonS3.putObject(new PutObjectRequest("mybucket", fileName, fileConverted).withCannedAcl(CannedAccessControlList.PublicRead));

            fileUri = "http://s3.localhost.localstack.cloud:4566" + "/" + "mybucket" + "/" + fileName;

            fileConverted.delete();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return fileUri;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        var convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));

        var fos = new FileOutputStream(convFile);

        fos.write(file.getBytes());
        fos.close();

        return convFile;
    }
}