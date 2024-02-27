package com.example.cinema.services;


import com.example.cinema.models.Movie;
import com.example.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieService() {}


    public List<String> getMovies(){
        ArrayList<String> titles = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()){
            titles.add(movie.getTitle());
        }
        return titles;
    }
    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }
}
