package com.rns.test.dto;


import com.rns.test.entity.Tires;
import com.rns.test.models.TireModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TireModelToEntity {


    public List<Tires> getEntity(List<TireModel> tireModels) {

        List<Tires> tiresList = new ArrayList<>();
        for (TireModel model : tireModels) {
            tiresList.add(setFields(model));
        }
        return tiresList;
    }


    private Tires setFields(TireModel model) {

        Tires tire = new Tires();

        tire.setModel(model.getModel());
        tire.setBrand(model.getBrand());
        tire.getSpecification().setAbbs(model.getAbbs());
        tire.getSpecification().setWidth(model.getWidth());
        tire.getSpecification().setCamera(model.getCamera());
        tire.getSpecification().setHeight(model.getHeight());
        tire.getSpecification().setSeason(model.getSeason());
        tire.getSpecification().setRunFlat(model.getRunFlat());
        tire.getSpecification().setResIndex(model.getResIndex());
        tire.getSpecification().setDiameter(model.getDiameter());
        tire.getSpecification().setConstruct(model.getConstruct());
        tire.getSpecification().setSpeedIndex(model.getSpeedIndex());

        if (isModelValid(model)) {
            tire.setStatus("Incorrect");
        } else {
            tire.setStatus("Correct");
        }

        return tire;
    }

    private boolean isModelValid(TireModel model) {

        return ((Objects.equals(model.getBrand(), " ")) || (Objects.equals(model.getModel(), " "))
                || (Objects.equals(model.getWidth(), " ")) || (Objects.equals(model.getHeight(), " "))
                || (Objects.equals(model.getConstruct(), " ")) || (Objects.equals(model.getDiameter(), " "))
                || (Objects.equals(model.getResIndex(), " ")) || (Objects.equals(model.getSpeedIndex(), " "))
                || (Objects.equals(model.getSeason(), " ")));
    }
}
