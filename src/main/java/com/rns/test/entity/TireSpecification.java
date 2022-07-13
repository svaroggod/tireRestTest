package com.rns.test.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "public", name = "specification")
public class TireSpecification {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id")
    private int spec_id;

    @Column(name = "twidth")
    private String width;

    @Column(name = "heigh")
    private String height;

    @Column(name = "construct")
    private String construct;

    @Column(name = "tdiameter")
    private String diameter;

    @Column(name = "resindex")
    private String resIndex;

    @Column(name = "speedindex")
    private String speedIndex;

    @Column(name = "abbs")
    private String abbs;

    @Column(name = "runflat")
    private String runFlat;

    @Column(name = "camera")
    private String camera;

    @Column(name = "season")
    private String season;

}
