package com.delremi.srini.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Country {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;
}
