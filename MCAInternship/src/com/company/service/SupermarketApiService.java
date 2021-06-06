package com.company.service;

import com.company.models.Product;
import com.company.models.StoreHouse;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SupermarketApiService implements SupermarketService {
    private final StoreHouse storeHouse = new StoreHouse();

    @Override
    public void getAllProducts() {
        try {
            String jsonString = getJsonString("https://interview-task-api.mca.dev/qr-scanner-codes/alpha-qr-gFpwhsQ8fkY1");
            Gson gson = new Gson();
            JSONParser parser = new JSONParser();
            JSONArray jsonProducts = (JSONArray) parser.parse(jsonString);

            for (var p : jsonProducts) {
                Product product = gson.fromJson(p.toString(), Product.class);
                this.storeHouse.addProduct(product);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printStoreProducts() {
        System.out.println(this.storeHouse);
    }

    private String getJsonString(String api) {
        StringBuilder inline = new StringBuilder();

        try {
            URL url = new URL(api);
            //Get Response
            Scanner sc = new Scanner(url.openStream());

            while (sc.hasNext()) {
                inline.append(sc.nextLine());
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inline.toString();
    }
}
