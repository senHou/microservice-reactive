package sen.learning.microservice.productcompositeservice.service;

import sen.learning.microservice.productcompositeservice.model.Product;
import sen.learning.microservice.productcompositeservice.model.Recommendation;
import sen.learning.microservice.productcompositeservice.model.Review;

import java.util.List;

public interface ProductCompositeService {
    Product getProduct(int productId);

    List<Recommendation> getRecommendations(int productId);

    public List<Review> getReviews(int productId);
}
