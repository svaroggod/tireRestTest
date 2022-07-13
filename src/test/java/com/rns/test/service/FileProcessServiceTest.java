package com.rns.test.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;


class FileProcessServiceTest {


    FileProcessService fileProcessService = new FileProcessService();

    @Test
    @SneakyThrows
    void multipartToFile() {

        MultipartFile multipartFile = new MockMultipartFile("sourceFile.tmp", "Hello World".getBytes());
        fileProcessService.multipartToFile(multipartFile);
        assertEquals("Hello World", (Files.readString(Path.of("src/main/resources/files/targetFile.csv"),
                StandardCharsets.US_ASCII)));

    }

    @Test
    @SneakyThrows
    void multipartToFile2() {

        MultipartFile multipartFile = new MockMultipartFile("sourceFile.tmp", "".getBytes());
        fileProcessService.multipartToFile(multipartFile);
        assertEquals("", (Files.readString(Path.of("src/main/resources/files/targetFile.csv"),
                StandardCharsets.US_ASCII)));

    }

    @Test
    @SneakyThrows
    void multipartToFile3() {

        MultipartFile multipartFile = null;
        assertNull(fileProcessService.multipartToFile(multipartFile));
    }
}