package com.rohila.spring.tutorial.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class which is used to
 *
 * @author Tarun Rohila
 */
@Entity
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    /**
     * Method to get the value of id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * Method to set the value of id
     *
     * @param id - id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Method to get the value of name
     *
     * @return name - name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the value of name
     *
     * @param name - name
     */
    public void setName(String name) {
        this.name = name;
    }
}
