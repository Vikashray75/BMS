package com.example.bmsjul23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class City extends BaseModel{
   // private int id;
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres;
}
