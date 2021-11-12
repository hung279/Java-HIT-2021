package Bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class Bill {
    private String billID;
    private String billName;
    private DateTime a;
    private ArrayList<Product> x;
    private int n;

    public Bill() {
    }

    public void InputBill() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhap ma phieu: ");
        billID = scanner.nextLine();
        System.out.printf("Nhap ten phieu: ");
        billName = scanner.nextLine();
        a = new DateTime();
        a.InputDateTime();
        System.out.printf("Nhap so luong san pham: ");
        n = scanner.nextInt();
        x = new ArrayList<>();
        for(int i = 0; i < n; i++){
            System.out.println("Nhap san pham thu: " + (i+1));
            Product p = new Product();
            p.InputP();
            x.add(p);
        }
    }
    public void OutputBill() {
        System.out.println("Ma phieu: " + billID);
        System.out.println("Ten phieu: " + billName);
        a.OuputDateTime();
        System.out.println("======Thong tin san pham========");
        for (int i = 0; i < n; i++) {
            System.out.println("+San pham " + (i+1));
            x.get(i).OutputP();
        }
    }
}
