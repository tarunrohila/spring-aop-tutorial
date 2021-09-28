package com.rohila.spring.tutorial.dao.impl;

import com.rohila.spring.tutorial.dao.ProductDao;
import com.rohila.spring.tutorial.dto.Product;
import com.rohila.spring.tutorial.repository.ProductRepository;
import com.rohila.spring.tutorial.repository.domain.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which is used to
 *
 * @author Tarun Rohila
 */
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    @Autowired
    @Qualifier("productRepository")
    private ProductRepository productRepository;

    @Override
    public List<ProductDetail> retrieveAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ProductDetail addNewProduct(ProductDetail product) {
        return productRepository.save(product);
    }
}
