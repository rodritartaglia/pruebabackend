package com.example.pruebabackend;

import com.example.pruebabackend.entities.Movie;
import com.example.pruebabackend.entities.Person;
import com.example.pruebabackend.repositories.MovieRepository;
import com.example.pruebabackend.repositories.PersonRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PruebabackendBootstrap implements InitializingBean {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PersonRepository personRepository;

    public void afterPropertiesSet()  {
        Movie movie1 = new Movie();
        movie1.setTitle("Harry Potter");
        movie1.setGenre("Fantasy");
        Movie movie2 = new Movie();
        movie2.setTitle("The Lord of the Rings");
        movie2.setGenre("Fantasy");
        Movie movie3 = new Movie();
        movie3.setTitle("Pulp Fiction");
        movie3.setGenre("Action");

        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);

        Person person1 = new Person();
        person1.setFirstName("Pablo");
        person1.setLastName("Lamberti");
        person1.setBirthdate(LocalDate.of(1987, 4, 3));
        person1.setHasInsurance(true);
        Person person2 = new Person();
        person2.setFirstName("Rodrigo");
        person2.setLastName("Tartaglia");
        person2.setBirthdate(LocalDate.of(2000, 4, 21));
        person2.setHasInsurance(false);
        Person person3 = new Person();
        person3.setFirstName("Rodrigo");
        person3.setLastName("Garcia");

        List<Movie> favMovies1 = new ArrayList<>();
        favMovies1.add(movie2);
        favMovies1.add(movie3);

        person1.setFavMovies(favMovies1);

        List<Movie> favMovies2 = new ArrayList<>();
        favMovies2.add(movie1);
        favMovies2.add(movie2);

        person2.setFavMovies(favMovies2);

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
    }
}
