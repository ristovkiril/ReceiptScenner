package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class StoreHouse {
    private final List<Product> domesticProducts = new ArrayList<>();
    private final List<Product> importedProducts = new ArrayList<>();

    public StoreHouse() {
    }

    public void addProduct(Product product) {
        if (product.domestic && !domesticProducts.contains(product)) {
            this.domesticProducts.add(product);
        } else if (!this.importedProducts.contains(product)) {
            this.importedProducts.add(product);
        }
    }

    public double getDomesticTotalCost() {
        return this.domesticProducts
                .stream()
                .mapToDouble(product -> product.price)
                .reduce(0, Double::sum);
    }

    public double getImportedTotalCost() {
        return this.importedProducts
                .stream()
                .mapToDouble(product -> product.price)
                .reduce(0, Double::sum);
    }

    private String printProducts(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        products.forEach(sb::append);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Domestic:\n" + printProducts(domesticProducts)
               + "Imported:\n" + printProducts(importedProducts) + "\n"
               + "Domestic cost: $" + getDomesticTotalCost()+ "\n"
               + "Imported cost: $" + getImportedTotalCost()+ "\n"
               + "Domestic count: " + domesticProducts.size()+ "\n"
               + "Imported count: " + importedProducts.size();
    }
}
