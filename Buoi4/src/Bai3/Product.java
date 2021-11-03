package Bai3;

import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private double price;

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma hang: ");
        productID = scanner.nextLine();
        System.out.print("Nhap ten hang: ");
        productName = scanner.nextLine();
        System.out.print("Nhap don gia: ");
        price = scanner.nextDouble();
    }

    public void Display() {
        System.out.println("Ma hang: " + productID);
        System.out.println("Ten hang: " + productName);
        System.out.println("Don gia: " + price);
        System.out.println();
    }

    public Product() {
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
