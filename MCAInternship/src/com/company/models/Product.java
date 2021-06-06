package com.company.models;

public class Product {
    String name;
    String description;
    Boolean domestic;
    Double weight = null;
    Double price;

    public Product(String name, String description, Boolean isDomestic, Double weight, Double price) {
        this.name = name;
        this.description = description;
        this.domestic = isDomestic;
        this.weight = weight;
        this.price = price;
    }

    public Product(String name, String description, Boolean isDomestic, Double price) {
        this.name = name;
        this.description = description;
        this.domestic = isDomestic;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "\t" + name
                + "\n\tPrice: " + price
                + "\n\t" + description
                + "\n\t" + "Weight: " + (weight != null ? weight : "N/A") + "\n";
    }
}
