package com.rns.test.service;


import com.rns.test.dto.CSVMappedToModel;
import com.rns.test.dto.TireModelToEntity;
import com.rns.test.entity.Tires;
import com.rns.test.hibernate.HibernateAdd;
import com.rns.test.models.TireModel;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;


@Service
public class FileProcessService {

    @Autowired
    private HibernateAdd hibernateAdd;
    @Autowired
    private CSVMappedToModel csvMapper;
    @Autowired
    private TireModelToEntity tireModel;


    @SneakyThrows
    public void fileProcess(MultipartFile file) {

        if (Objects.requireNonNull(file.getContentType()).equals("text/csv")) {
            File targetFile = multipartToFile(file);
            List<TireModel> tireModelList = csvMapper.mapFile(targetFile);
            List<Tires> tireList = tireModel.getEntity(tireModelList);
            hibernateAdd.addToDB(tireList);
        }
    }


    @SneakyThrows
    public File multipartToFile(MultipartFile file) {

        if (file == null) return null;
        InputStream initialStream = file.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        File targetFile = new File("src/main/resources/files/targetFile.csv");
        try (OutputStream outStream = new FileOutputStream(targetFile)) {
            outStream.write(buffer);
        }
        return targetFile;
    }
}