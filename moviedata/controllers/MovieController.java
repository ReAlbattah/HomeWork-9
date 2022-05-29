package com.example.moviedata.controllers;

import com.example.moviedata.model.Movie;
import com.example.moviedata.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
@AllArgsConstructor
public class MovieController {

private final MovieService movieService;

    @GetMapping
    public ResponseEntity getMovie(){

        return ResponseEntity.status(200).body(movieService.getMovies());
    }

    @PostMapping
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovies(movie);
        return ResponseEntity.status(200).body("Movie added");
    }

    @PutMapping("/{id}")
    public ResponseEntity update(Movie movie,@PathVariable Integer id){
        movieService.update(movie, id);
        return ResponseEntity.status(200).body("Movie updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        movieService.delete(id);
        return ResponseEntity.status(200).body("Movie deleted");
    }
}
