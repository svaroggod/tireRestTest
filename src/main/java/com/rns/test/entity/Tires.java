package com.rns.test.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
@Table(schema = "public", name = "tiers")
public class Tires {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spec_id")
    private TireSpecification specification;

    public Tires() {
        this.specification = new TireSpecification();
    }

}
