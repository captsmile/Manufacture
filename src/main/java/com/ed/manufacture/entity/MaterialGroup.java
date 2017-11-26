package com.ed.manufacture.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "гр1сырьё")
public class MaterialGroup {

    @Id
    @GeneratedValue
    @Column(name = "кодгр1")
    private int id;

    @Column(name = "гр1описание", columnDefinition = "nvarchar(255)")
    private String name;

}
