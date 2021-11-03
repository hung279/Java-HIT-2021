package Bai2;

import java.util.Scanner;

public class Staff {
    private String staffID;
    private String staffName;
    private Date date;

    public Staff() {
    }

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan su: ");
        staffID = scanner.nextLine();
        System.out.print("Nhap ho ten: ");
        staffName = scanner.nextLine();
        System.out.println("Nhap ngay sinh: ");
        date = new Date();
        date.Input();
    }

    public void Display() {
        System.out.println("Ma nhan su: " + staffID);
        System.out.println("Ten nhan su: " + staffName);
        System.out.print("Ngay sinh: ");
        date.Display();
    }
}
