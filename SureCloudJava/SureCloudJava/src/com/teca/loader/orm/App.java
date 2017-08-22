package com.teca.loader.orm;

/**
 * Created by truonglx.
 */
public class App {

    private String brand;

    private String type;

    public App(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Brand: "+brand+"Type: "+type;
    }
}
