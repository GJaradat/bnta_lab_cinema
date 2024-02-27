package com.example.cinema.components;

import com.example.cinema.models.Movie;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieLoader implements ApplicationRunner{

    @Autowired
    MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        movieService.addMovie(new Movie("Alien","18", 117));
        movieService.addMovie(new Movie("The Imitation Game","12A", 114));
        movieService.addMovie(new Movie("Iron Man","12A", 126));
        movieService.addMovie(new Movie("The Martian","12A", 144));
        movieService.addMovie(new Movie("Avengers","12A", 181));
        movieService.addMovie(new Movie("Rush Hour","PG-13", 98));
        movieService.addMovie(new Movie("Indiana Jones and the Last Crusade","PG-13", 127));
        movieService.addMovie(new Movie("The Truman Show","PG", 103));

    }
}
