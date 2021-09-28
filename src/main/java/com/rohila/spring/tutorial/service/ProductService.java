package com.rohila.spring.tutorial.service;

import com.rohila.spring.tutorial.dto.Product;

import java.util.List;

/**
 * Interface which is used to
 *
 * @author Tarun Rohila
 */
public interface ProductService {
    List<Product> retrieveAllProduct();

    Product addNewProduct(Product product);
}
