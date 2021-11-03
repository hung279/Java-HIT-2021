package Bai3;

import java.util.Scanner;

public class Bill {
    private String billID;
    private int n;
    private Product[] x;

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma phieu: ");
        billID = scanner.nextLine();
        System.out.print("Nhap so luong hang: ");
        n = scanner.nextInt();
        x = new Product[n];
        for (int i = 0; i < n; i++) {
            x[i] = new Product();
            System.out.println("Nhap hang thu " + (i+1));
            x[i].Input();
        }
    }

    public void Display() {
        System.out.print("Ma phieu: " + billID);
        for (int i = 0; i < n; i++) {
            System.out.println("+Hang thu " + (i+1));
            x[i].Display();
        }
    }

    public Bill() {
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Product[] getX() {
        return x;
    }

    public void setX(Product[] x) {
        this.x = x;
    }
}
