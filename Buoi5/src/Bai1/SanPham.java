package Bai1;

import java.util.Scanner;

public class SanPham {
    private String productID;
    private String productName;
    private String manufacturer;
    private String date;

    public SanPham() {
    }

    public SanPham(String productID, String productName, String manufacturer, String date) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.date = date;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        productID = scanner.nextLine();
        System.out.print("Nhap ten san pham:");
        productName = scanner.nextLine();
        System.out.print("Nhap ten hang san xuat:");
        manufacturer = scanner.nextLine();
        System.out.print("Nhap ngay nhap:");
        date = scanner.nextLine();
    }

    public void Display() {
        System.out.println("Ma san pham: " + productID);
        System.out.println("Ten san pham: " + productName);
        System.out.println("Ten hang san xuat: " + manufacturer);
        System.out.println("Ngay nhap: " + date);
    }
}
