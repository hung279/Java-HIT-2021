package Bai4;

import java.util.Scanner;

public class Computer {
    private String computerID;
    private String computerType;
    private String status;

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma may: ");
        computerID = scanner.nextLine();
        System.out.print("Nhap kieu may: ");
        computerType = scanner.nextLine();
        System.out.print("Nhap tinh trang: ");
        status = scanner.nextLine();
    }

    public void Display() {
        System.out.println("Ma may: " + computerID);
        System.out.println("Kieu may: " + computerType);
        System.out.println("Tinh trang: " + status);
    }

    public Computer() {
    }
}
