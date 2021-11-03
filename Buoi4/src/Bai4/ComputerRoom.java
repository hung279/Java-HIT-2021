package Bai4;

import java.util.Scanner;

public class ComputerRoom {
    private String roomID;
    private String roomName;
    private double area;
    private Manager x = new Manager();
    private Computer[] y;
    private int n;

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma phong: ");
        roomID = scanner.nextLine();
        System.out.print("Nhap ten phong: ");
        roomName = scanner.nextLine();
        System.out.print("Nhap dien tich: ");
        area = scanner.nextDouble();
        x.Input();
        System.out.print("Nhap so luong may: ");
        n = scanner.nextInt();
        y = new Computer[n];
        for (int i = 0; i < n; i++) {
            y[i] = new Computer();
            System.out.println("Nhap loai may " + (i+1));
            y[i].Input();
        }
    }

    public void Display() {
        System.out.println("Ma phong: " + roomID);
        System.out.println("Ten phong: " + roomName);
        System.out.println("Dien tich: " + area);
        x.Display();
        for (int i = 0; i < n; i++) {
            System.out.println("+Loai may " + (i+1));
            y[i].Display();
        }
    }

    public ComputerRoom() {
    }
}
