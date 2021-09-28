package com.rohila.spring.tutorial.service.impl;

import com.rohila.spring.tutorial.dao.ProductDao;
import com.rohila.spring.tutorial.dto.Product;
import com.rohila.spring.tutorial.repository.domain.ProductDetail;
import com.rohila.spring.tutorial.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class which is used to
 *
 * @author Tarun Rohila
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("productDao")
    private ProductDao productDao;

    @Override
    public List<Product> retrieveAllProduct() {
        List<Product> products = new ArrayList<>();
        return productDao.retrieveAllProduct().stream().map(productDetail -> {
            Product p = new Product();
            p.setId(productDetail.getId());
            p.setName(productDetail.getName());
            return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product addNewProduct(Product product) {
        ProductDetail productDetail = new ProductDetail();
        BeanUtils.copyProperties(product, productDetail);
        Product savedProduct = new Product();
        BeanUtils.copyProperties(productDao.addNewProduct(productDetail), savedProduct);
        return savedProduct;
    }
}
