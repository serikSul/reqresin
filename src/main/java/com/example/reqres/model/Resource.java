package com.example.reqres.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;
    private String name;
    private String color;
    private String pantone_value;

    public Resource(int id, int year, String name, String color, String pantone_value) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.color = color;
        this.pantone_value = pantone_value;
    }

    public Resource() {
    }
}
