package com.ming.chenxi.domain;

import javax.persistence.*;

/**
 * Created by Ming on 2016/4/22.
 */

@Entity
@Table(name="nutrition")
public class Nutrition {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String name;

    private String  energy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }
}
