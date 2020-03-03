package com.hustlebar.microhustle.apigee;

public class DeveloperApp {
    private String name;
    private String[] apiProducts;
    private Tuple[] attributes;

    public DeveloperApp() {}

    public DeveloperApp(String name, String[] apiProducts) {
        this.name = name;
        this.apiProducts = apiProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getApiProducts() {
        return apiProducts;
    }

    public void setApiProducts(String[] apiProducts) {
        this.apiProducts = apiProducts;
    }

    public Tuple[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Tuple[] attributes) {
        this.attributes = attributes;
    }
}
