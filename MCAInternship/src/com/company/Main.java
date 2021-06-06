package com.company;

import com.company.service.SupermarketApiService;
import com.company.service.SupermarketService;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SupermarketService service = new SupermarketApiService();
        service.getAllProducts();
        service.printStoreProducts();
    }
}
