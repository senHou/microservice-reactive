package sen.learning.microservice.productrecommendationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sen.learning.microservice.productrecommendationservice.model.Recommendation;
import sen.learning.microservice.productrecommendationservice.util.ServiceUtil;
import sen.learning.microservice.productrecommendationservice.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecommendationController {
    private static final Logger LOG = LoggerFactory.getLogger(RecommendationController.class);

    @Autowired
    private ServiceUtil serviceUtil;


    /**
     * Sample usage: "curl $HOST:$PORT/recommendation?productId=1".
     *
     * @param productId Id of the product
     * @return the recommendations of the product
     */
    @GetMapping("/recommendation")
    List<Recommendation> getRecommendations(
            @RequestParam(value = "productId", required = true) int productId) {
        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        if (productId == 113) {
            LOG.debug("No recommendations found for productId: {}", productId);
            return new ArrayList<>();
        }

        List<Recommendation> list = new ArrayList<>();
        list.add(new Recommendation(productId, 1, "Author 1", 1, "Content 1", serviceUtil.getServiceAddress()));
        list.add(new Recommendation(productId, 2, "Author 2", 2, "Content 2", serviceUtil.getServiceAddress()));
        list.add(new Recommendation(productId, 3, "Author 3", 3, "Content 3", serviceUtil.getServiceAddress()));

        LOG.debug("/recommendation response size: {}", list.size());

        return list;
    }
}
