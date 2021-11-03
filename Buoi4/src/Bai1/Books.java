package Bai1;

import java.util.Scanner;

public class Books {
    private String bookID;
    private String bookName;
    private String publisher;
    private int pagesNumber;
    private double price;

    Scanner scanner = new Scanner(System.in);
    public void input() {
        System.out.print("Nhap ma sach: ");
        bookID = scanner.nextLine();
        System.out.print("Nhap ten sach: ");
        bookName = scanner.nextLine();
        System.out.print("Nhap ten nha xuat ban: ");
        publisher = scanner.nextLine();
        System.out.print("Nhap so trang: ");
        pagesNumber = scanner.nextInt();
        System.out.print("Nhap gia sach: ");
        price = scanner.nextDouble();
    }

    public void display() {
        System.out.println("Ma sach: " + bookID);
        System.out.println("Ten sach: " + bookName);
        System.out.println("Ten NXB: " + publisher);
        System.out.println("So trang: " + pagesNumber);
        System.out.println("Gia sach: " + price);
    }

    public Books() {
    }
}
