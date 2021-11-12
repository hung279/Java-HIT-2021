package Bai2;

import java.util.Scanner;

public class DateTime {
    private int day;
    private int month;
    private int year;

    public DateTime() {
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void InputDateTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ngay: ");
        day = scanner.nextInt();
        System.out.print("Nhap thang: ");
        month = scanner.nextInt();
        System.out.print("Nhap nam: ");
        year = scanner.nextInt();
    }

    public void OuputDateTime() {
        System.out.println("Thoi gian: " + day +"/" + month + "/" + year);
    }
}
