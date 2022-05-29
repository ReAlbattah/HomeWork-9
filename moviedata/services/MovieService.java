package com.example.moviedata.services;

import com.example.moviedata.model.Movie;
import com.example.moviedata.reporistory.MovieRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepo movieRepo;

    public List<Movie> getMovies(){
        return movieRepo.findAll();
    }

    public void  addMovies(Movie movie){
        movieRepo.save(movie);
    }
    public void update(Movie movie,Integer id){
        Movie oldMovie=movieRepo.findById(id).get();
        oldMovie.setId(movie.getId());
        oldMovie.setName(movie.getName());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setRating(movie.getRating());
        oldMovie.setLaunchDate(movie.getLaunchDate());
        movieRepo.save(oldMovie);
    }

    public void delete(Integer id){
        movieRepo.deleteById(id);
    }
}
