package sen.learning.microservice.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sen.learning.microservice.productservice.model.Product;
import sen.learning.microservice.productservice.util.ServiceUtil;

@RestController
public class ProductController {

    private ServiceUtil serviceUtil;

    @Autowired
    public ProductController(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }


    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable  int productId) {

        return new Product(productId, "name-" + productId, 123,
                serviceUtil.getServiceAddress());
    }

}
