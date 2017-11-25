package com.ed.manufacture.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "гр1сырьё")
@Data
public class MaterialGroup {

    @Id
    @GeneratedValue
    @Column(name = "кодгр1")
    private int id;

    @Column(name = "гр1описание")
    private String name;

}
