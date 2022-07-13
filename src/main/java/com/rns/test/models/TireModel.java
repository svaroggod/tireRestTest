package com.rns.test.models;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class TireModel {

    private String brand;
    private String model;
    private String width;
    private String height;
    private String construct;
    private String diameter;
    private String resIndex;
    private String speedIndex;
    private String season;
    private String abbs;
    private String runFlat;
    private String camera;

}
