package com.krukun.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Eugeniy Krukun on 26.04.2016.
 */
@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    private long id = 1;
    @Column(name = "name",nullable = false,length = 30)
    private String name;
    @Column(name = "description",nullable = false)
    private String description;

    public Menu() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
