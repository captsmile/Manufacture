package com.ed.manufacture.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "сотрудники")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "код")
    private int id;

    @Column(name = "фамилия", columnDefinition = "nvarchar(255)")
    private String surname;

    @Column(name = "имя", columnDefinition = "nvarchar(255)")
    private String name;

    @Column(name = "пароль", columnDefinition = "nvarchar(255)")
    private String password;

    @Column(name = "уволен")
    private boolean dismissed;

    @Transient
    private String role = "USER";



}
