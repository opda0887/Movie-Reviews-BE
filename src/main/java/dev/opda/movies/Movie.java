package dev.opda.movies;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Movie {
  
  // use ObjectId as primary key
  @Id
  private ObjectId id;

  private String imdbId;

  private String title;

  private String releaseDate;

  private String trailerLink;

  private List<String> genres;

  private String poster;

  private List<String> backdrops;

  @DocumentReference
  private List<Review> reviewIds;
}
