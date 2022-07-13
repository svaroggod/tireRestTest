package com.rns.test.dto;

import com.rns.test.entity.Tires;
import com.rns.test.models.TireModel;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TireModelToEntityTest {


    List<Tires> tires;
    TireModel tireModel;
    List<TireModel> listModel;
    TireModelToEntity tireModelToEntity = new TireModelToEntity();


    @BeforeEach
    @SneakyThrows
    public void setup() {

        tireModel = new TireModel();
        listModel = new ArrayList<>();

        tireModel.setAbbs("XR");
        tireModel.setHeight("60");
        tireModel.setWidth("225");
        tireModel.setCamera("TT");
        tireModel.setResIndex("TT");
        tireModel.setDiameter("19");
        tireModel.setConstruct("R");
        tireModel.setBrand("Nokian");
        tireModel.setSpeedIndex("XL");
        tireModel.setRunFlat("Run Flat");
        tireModel.setModel("Hakkapeliitta R2 SUV");
        tireModel.setSeason("Зимние(шипованные)");

    }


    @Test
    void getEntity() {

        listModel.add(tireModel);
        tires = tireModelToEntity.getEntity(listModel);
        assertSame(tires.get(0).getClass(), Tires.class);
    }


    @Test
    void getEntity2() {

        tireModel.setModel(" ");
        listModel.add(tireModel);
        tires = tireModelToEntity.getEntity(listModel);
        assertEquals("Incorrect", tires.get(0).getStatus());
    }

    @Test
    void getEntity3() {

        tireModel.setBrand(" ");
        listModel.add(tireModel);
        tires = tireModelToEntity.getEntity(listModel);
        assertEquals("Incorrect", tires.get(0).getStatus());
    }

    @Test
    void getEntity4() {

        tireModel.setSeason(" ");
        listModel.add(tireModel);
        tires = tireModelToEntity.getEntity(listModel);
        assertEquals("Incorrect", tires.get(0).getStatus());
    }
    @Test
    void getEntity5() {

        tireModel.setWidth(" ");
        listModel.add(tireModel);
        tires = tireModelToEntity.getEntity(listModel);
        assertEquals("Incorrect", tires.get(0).getStatus());
    }


    @Test
    void getEntity6() {

        tireModel.setHeight(" ");
        listModel.add(tireModel);
        tires = tireModelToEntity.getEntity(listModel);
        assertEquals("Incorrect", tires.get(0).getStatus());
    }

    @Test
    void getEntity7() {

        tireModel.setConstruct(" ");
        listModel.add(tireModel);
        tires = tireModelToEntity.getEntity(listModel);
        assertEquals("Incorrect", tires.get(0).getStatus());
    }


    @Test
    void getEntity8() {

        tireModel.setDiameter(" ");
        listModel.add(tireModel);
        tires = tireModelToEntity.getEntity(listModel);
        assertEquals("Incorrect", tires.get(0).getStatus());
    }

    @Test
    void getEntity9() {

        tireModel.setResIndex(" ");
        listModel.add(tireModel);
        tires = tireModelToEntity.getEntity(listModel);
        assertEquals("Incorrect", tires.get(0).getStatus());
    }

    @Test
    void getEntity10() {

        tireModel.setSpeedIndex(" ");
        listModel.add(tireModel);
        tires = tireModelToEntity.getEntity(listModel);
        assertEquals("Incorrect", tires.get(0).getStatus());
    }

}
