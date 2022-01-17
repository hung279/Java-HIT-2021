package Model;

import java.util.Scanner;

public class Product {
    private String id;
    private String name;
    private String productType;
    private int quantity;
    private double price;

    public Product() {
    }

    public Product(String id, String name, String productType, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
