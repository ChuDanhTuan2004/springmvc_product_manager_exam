package org.example.demo3.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String description;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date product_day;

    public Product() {
    }

    public Product(Long id, String name, String code, String description, double price, Date product_day) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
        this.product_day = product_day;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getProduct_day() {
        return product_day;
    }

    public void setProduct_day(Date product_day) {
        this.product_day = product_day;
    }
}
