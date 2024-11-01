package com.example.pruebabackend.controllers;

import com.example.pruebabackend.entities.Movie;
import com.example.pruebabackend.entities.Person;
import com.example.pruebabackend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable long id) {
        return personService.getById(id);
    }

    @GetMapping("/name")
    public List<Person> getPersonByName(@RequestParam String name) {
        return personService.getByName(name);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable long id) {
        personService.deletePerson(id);
    }

    @GetMapping("/{id}/movies")
    public List<Movie> getMovies(@PathVariable long id) {
        return personService.getPersonMovies(id);
    }

    @PostMapping("/{id}/movies")
    public List<Movie> addMovie(@PathVariable long id, @RequestBody Movie movie) {
        return personService.addMovie(id, movie);
    }

    @DeleteMapping("/{id}/movies")
    public List<Movie> deleteMovie(@PathVariable long id, @RequestBody Movie movie) {
        return personService.removeMovie(id, movie);
    }
}
