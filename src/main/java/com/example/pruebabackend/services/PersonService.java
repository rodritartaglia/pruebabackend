package com.example.pruebabackend.services;

import com.example.pruebabackend.entities.Movie;
import com.example.pruebabackend.entities.Person;
import com.example.pruebabackend.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MovieService movieService;

    public List<Person> getAll() {
        return (List<Person>) personRepository.findByOrderByLastNameAsc();
    }

    public Person getById(long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe la persona con el id " + id));
    }

    public List<Person> getByName(String name) {
        List<Person> personList = personRepository.getPersonByFirstNameIgnoreCase(name);
        if (personList.isEmpty()) {
            throw new RuntimeException("No existen personas con el nombre " + name);
        } else {
            return personList;
        }
    }

    public Person createPerson(Person person) {
        if (person.getFirstName() == null || person.getFirstName().isEmpty()) {
            throw new RuntimeException("El nombre no puede estar vacío");
        }
        if (person.getLastName() == null || person.getLastName().isEmpty()) {
            throw new RuntimeException("El apellido no puede estar vacío");
        }

        if (person.getHasInsurance() == null) {
            throw new RuntimeException("El seguro no tiene un valor valido");
        }
        return personRepository.save(person);
    }

    public Person updatePerson(long id, Person person) {
        Person oldPerson = getById(id);

        if (person.getFirstName() != null) {
            oldPerson.setFirstName(person.getFirstName());
        }

        if (person.getLastName() != null) {
            oldPerson.setLastName(person.getLastName());
        }

        if (person.getBirthdate() != null) {
            oldPerson.setBirthdate(person.getBirthdate());
        }

        if (person.getHasInsurance() != null) {
            oldPerson.setHasInsurance(person.getHasInsurance());
        }

        if (person.getFavMovies() != null && !person.getFavMovies().isEmpty()) {
            oldPerson.setFavMovies(person.getFavMovies());
        }

        personRepository.save(oldPerson);
        return oldPerson;
    }

    public void deletePerson(long id) {
        Person person = getById(id);
        personRepository.delete(person);
    }

    public List<Movie> getPersonMovies(long id) {
        Person person = getById(id);
        return person.getFavMovies();
    }

    public List<Movie> addMovie(long id, Movie newMovie) {
        Person person = getById(id);
        Movie movie = movieService.getMovieByTitle(newMovie);

        if(person.getFavMovies().contains(movie)) {
            throw new RuntimeException("La pelicula ya existe");
        }

        if (person.getFavMovies().size() >= person.getMaxMovies()) {
            throw new RuntimeException("Ya posee 5 peliculas favoritas");
        }

            person.getFavMovies().add(movie);
            personRepository.save(person);
            return person.getFavMovies();
    }

    public List<Movie> removeMovie(long id, Movie movie) {
        Person person = getById(id);
        Movie movieToRemove = movieService.getMovieByTitle(movie);
        if (person.getFavMovies().contains(movieToRemove)) {
            person.getFavMovies().remove(movieToRemove);
            personRepository.save(person);
            return person.getFavMovies();
        } else {
            throw new RuntimeException("La pelicula no se encuentra en la lista");
        }

    }
}
