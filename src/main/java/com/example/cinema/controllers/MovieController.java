package com.example.cinema.controllers;


import com.example.cinema.models.Movie;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {


    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<String> showMovieList(){
        String movies = movieService.getMovies().toString();
        return new ResponseEntity<String>(movies, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<String> showMovie(@PathVariable long id){
        Optional<Movie> movie = movieService.getMovieById(id);

        if (movie.isEmpty()){
            return new ResponseEntity<>("Movie is not in database", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(String.format("%d. %s has a rating of %s and is %d minutes long.",
                                    movie.get().getId(), movie.get().getTitle(), movie.get(). getRating(), movie.get().getDuration()),
                                    HttpStatus.FOUND);
    }


    @PostMapping
    public ResponseEntity <String> newMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>(String.format("Added %s to database", movie.getTitle()),
                                    HttpStatus.CREATED);


    }
}