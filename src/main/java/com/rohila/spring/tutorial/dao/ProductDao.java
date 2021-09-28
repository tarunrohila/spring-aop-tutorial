package com.rohila.spring.tutorial.dao;

import com.rohila.spring.tutorial.dto.Product;
import com.rohila.spring.tutorial.repository.domain.ProductDetail;

import java.util.List;

/**
 * Interface which is used to
 *
 * @author Tarun Rohila
 */
public interface ProductDao {
    List<ProductDetail> retrieveAllProduct();

    ProductDetail addNewProduct(ProductDetail product);
}
