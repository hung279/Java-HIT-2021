package Bai2;

import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private int quantity;
    private double price;

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
        productName = productName;
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

    public void InputP(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhap ma san pham: ");
        productID = scanner.nextLine();
        System.out.printf("Nhap ten san pham: ");
        productName = scanner.nextLine();
        System.out.printf("Nhap so luong: ");
        quantity = scanner.nextInt();
        System.out.printf("Nhap don gia: ");
        price = scanner.nextDouble();
    }
    public void OutputP(){
        System.out.println("Ma SP: " + productID);
        System.out.println("Ten SP: " + productName);
        System.out.println("So luong: "+ quantity);
        System.out.println("Don gia: "+ price);
        System.out.println("Thanh tien: "+ price*quantity);
    }
}
