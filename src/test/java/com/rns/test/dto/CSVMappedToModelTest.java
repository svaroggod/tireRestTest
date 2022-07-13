package com.rns.test.dto;

import com.rns.test.models.TireModel;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CSVMappedToModelTest {

    private File test;
    private List <TireModel> list;
    private FileToModel csvMappedToModel;


    @BeforeEach
    @SneakyThrows
    public  void setup() {

        String strPath = "src/test/java/testFile.csv";
        test= new File(strPath);
        csvMappedToModel =  new CSVMappedToModel();
        String content = "Nokian,Hakkapeliitta R2 SUV,225,60,R,17,99,R,XL,Run Flat,TT,Зимние(шипованные)";
        Files.writeString(Path.of(test.getPath()), content, StandardCharsets.UTF_8);
        list= csvMappedToModel.mapFile(test);
    }


    @AfterEach
    public void deleteOutputFile() {
        test.delete();
    }



    @Test
     void mapFile() {

        assertSame(list.get(0).getClass(), TireModel.class);
    }

    @Test
    void mapFile2() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("Nokian", tireModel.getBrand());
    }

    @Test
    void mapFile3() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("Hakkapeliitta R2 SUV", tireModel.getModel());
    }

    @Test
    void mapFile4() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("Зимние(шипованные)", tireModel.getSeason());
    }

    @Test
    void mapFile5() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("225", tireModel.getWidth());
    }

    @Test
    void mapFile6() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("60", tireModel.getHeight());
    }

    @Test
    void mapFile7() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("R", tireModel.getConstruct());
    }

    @Test
    void mapFile8() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("17", tireModel.getDiameter());
    }

    @Test
    void mapFile9() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("99", tireModel.getResIndex());
    }

    @Test
    void mapFile10() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("R", tireModel.getSpeedIndex());
    }
    @Test
    void mapFile11() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("XL", tireModel.getAbbs());
    }

    @Test
    void mapFile12() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("Run Flat", tireModel.getRunFlat());
    }

    @Test
    void mapFile13() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("TT", tireModel.getCamera());
    }

    @Test
    void mapFile14() {

        TireModel tireModel = (TireModel) list.get(0);
        assertEquals("Зимние(шипованные)", tireModel.getSeason());
    }


    @Test
    @SneakyThrows
    void mapFile15() {
        File test= null;
        assertNull(csvMappedToModel.mapFile(test));
    }

}