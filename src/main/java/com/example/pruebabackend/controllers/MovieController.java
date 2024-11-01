package com.example.pruebabackend.controllers;

import com.example.pruebabackend.entities.Movie;
import com.example.pruebabackend.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAll(){
        return movieService.getAll();
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }
}
