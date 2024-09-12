package dev.opda.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.opda.movies.Movie;
import dev.opda.movies.Review;
import dev.opda.movies.repository.ReviewRepository;

@Service
public class ReviewService {
  
  @Autowired
  private ReviewRepository reviewRepository;

  // use mongoTemplate to do a more complex query
  @Autowired
  private MongoTemplate mongoTemplate;
  
  public Review createReview(String reviewbody, String imdbId) {
    Review review = reviewRepository.insert(new Review(reviewbody));

    // use imdbId as a filter, and push review to Movie's reviewIds
    mongoTemplate.update(Movie.class)
      .matching(Criteria.where("imdbId").is(imdbId))
      .apply(new Update().push("reviewIds").value(review))
      .first();
    
    return review;
  }
}
