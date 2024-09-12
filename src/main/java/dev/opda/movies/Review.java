package dev.opda.movies;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
  @Id
  private ObjectId id;

  private String body;

  // Review constructor using body
  public Review(String body) {
    this.body = body;
  }
}
