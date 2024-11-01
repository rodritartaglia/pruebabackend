package com.example.pruebabackend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private Boolean hasInsurance;
    @ManyToMany
    private List<Movie> favMovies;

    private static final int MAX_MOVIES = 5;

    public Person() {
    }

    public Person(Long id, String firstName, String lastName, LocalDate birthdate, Boolean hasInsurance, List<Movie> favMovies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.hasInsurance = hasInsurance;
        this.favMovies = favMovies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Boolean getHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(Boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public List<Movie> getFavMovies() {
        return favMovies;
    }

    public void setFavMovies(List<Movie> favMovies) {
        this.favMovies = favMovies;
    }

    public int getMaxMovies() {
        return MAX_MOVIES;
    }
}

