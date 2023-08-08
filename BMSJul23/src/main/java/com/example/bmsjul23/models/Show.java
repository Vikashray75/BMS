package com.example.bmsjul23.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "shows")
public class Show extends BaseModel{
    private Date startTime;
    private Date endTime;
    @ElementCollection
    @Enumerated(value = EnumType.ORDINAL)
    private List<Feature>features;
    @ManyToOne
    private Screen screen;
}
