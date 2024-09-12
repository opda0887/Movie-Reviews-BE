package dev.opda.movies.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.opda.movies.Movie;
import dev.opda.movies.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies") // instead of "localhost:8080/root" -> "localhost:8080/api/v1/movies"
public class MovieController {
  
  @Autowired
  private MovieService movieService;

  @GetMapping
  public ResponseEntity<List<Movie>> getAllMovies() {
    return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK); // 200
  }

  @GetMapping("/{imdbId}")
  public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
    return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
  }
}
