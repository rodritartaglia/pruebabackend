package com.example.pruebabackend.repositories;

import com.example.pruebabackend.entities.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Movie findMovieByTitleIgnoreCase(String title);
}
