package com.rns.test.controller;

import com.rns.test.payload.UploadFileResponse;
import com.rns.test.service.FileProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class FileController {


    @Autowired
    private FileProcessService fileProcessService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws Exception {

        fileProcessService.fileProcess(file);
        String fileName = file.getName();
        return new UploadFileResponse(fileName,
                file.getContentType(), file.getSize());
    }


}


