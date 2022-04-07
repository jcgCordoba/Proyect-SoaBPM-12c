package com.test.mock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table( name="person" )
public class Person {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name="id" )
    private long id;

    @Column( name="name" )
    private String name;

    @Column( name="genre" )
    private String genre;

    @Column( name="country" )
    private String country;

    @Column( name="occupation" )
    private String occupation;

    @Column( name="age" )
    private int age;

    @Column( name="icon" )
    private int icon;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }    
    
}
