package com.example.pruebabackend.services;

import com.example.pruebabackend.entities.Movie;
import com.example.pruebabackend.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAll() {
        return (List<Movie>) movieRepository.findAll();
    }

    public Movie createMovie(Movie movie) {
        Movie findedMovie = movieRepository.findMovieByTitleIgnoreCase(movie.getTitle());
        if (findedMovie != null) {
            throw new RuntimeException("La pelicula ya existe");
        } else {
            return movieRepository.save(movie);
        }
    }

    public Movie getMovieByTitle(Movie movie) {
        Movie findedMovie = movieRepository.findMovieByTitleIgnoreCase(movie.getTitle());
        if (findedMovie == null) {
            throw new RuntimeException("No existe una pelicula con el titulo: " + movie.getTitle());
        } else {
            return findedMovie;
        }
    }
}
