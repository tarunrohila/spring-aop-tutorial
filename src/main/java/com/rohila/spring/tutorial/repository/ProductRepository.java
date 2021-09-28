package com.rohila.spring.tutorial.repository;

import com.rohila.spring.tutorial.repository.domain.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface which is used to
 *
 * @author Tarun Rohila
 */
@Repository("productRepository")
public interface ProductRepository extends JpaRepository<ProductDetail, Long> {
}
