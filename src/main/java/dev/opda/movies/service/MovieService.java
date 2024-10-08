package dev.opda.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.opda.movies.Movie;
import dev.opda.movies.repository.MovieRepository;

@Service
public class MovieService {
  @Autowired
  private MovieRepository movieRepository;

  public List<Movie> allMovies() {
    return movieRepository.findAll();
  }

  public Optional<Movie> singleMovie(String imdbId) {
    return movieRepository.findMovieByImdbId(imdbId);
  }
}
