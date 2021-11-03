package Bai4;

import java.util.Scanner;

public class Manager {
    private String managerID;
    private String managerName;

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma quan ly: ");
        managerID = scanner.nextLine();
        System.out.print("Nhap ho ten quan ly: ");
        managerName = scanner.nextLine();
    }

    public void Display() {
        System.out.println("Ma quan ly: " + managerID);
        System.out.println("Ten quan ly: " + managerName);
    }

    public Manager() {
    }
}
