package Bai2;

import java.util.Scanner;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ngay: ");
        day = scanner.nextInt();
        System.out.print("Nhap thang: ");
        month = scanner.nextInt();
        System.out.print("Nhap nam: ");
        year = scanner.nextInt();
    }

    public void Display() {
        System.out.println(day+"/"+month+"/"+year);
    }
}
