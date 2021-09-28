package com.rohila.spring.tutorial.controller;

import com.rohila.spring.tutorial.dto.Product;
import com.rohila.spring.tutorial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class which is used to
 *
 * @author Tarun Rohila
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    /**
     * method to retreive all products
     * @return list of products
     */
    @GetMapping
    public List<Product> retrieveAllProduct() {
        throw new IllegalStateException("Exception");
        //return productService.retrieveAllProduct();
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }
}
