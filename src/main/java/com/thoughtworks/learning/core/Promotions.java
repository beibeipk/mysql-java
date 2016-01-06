package com.thoughtworks.learning.core;

public class Promotions {
    private String type;
    private String barcode;

    public Promotions(String type,String barcode){
        this.type=type;
        this.barcode=barcode;
    }

    public String getType() {
        return type;
    }

    public String getBarcode() {
        return barcode;
    }
}