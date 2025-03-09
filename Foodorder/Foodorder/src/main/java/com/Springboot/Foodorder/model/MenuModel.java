package com.Springboot.Foodorder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "menu") // ✅ Make sure the table name matches your database table
public class MenuModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String menuDishes;
    private double price;
    private int ratings;

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuDishes() {
        return menuDishes;
    }

    public void setMenuDishes(String menuDishes) {
        this.menuDishes = menuDishes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
