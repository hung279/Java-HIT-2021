package Bai3;

import java.util.Scanner;

public class Person {
    private String name;
    private String birthday;
    private String country;

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        name = scanner.nextLine();
        System.out.print("Nhap ngay sinh: ");
        birthday = scanner.nextLine();
        System.out.print("Nhap que quan: ");
        country = scanner.nextLine();
    }

    public void Output() {
        System.out.println("Ho ten: " + name);
        System.out.println("Ngay sinh: " + birthday);
        System.out.println("Que quan: " + country);
    }
}
