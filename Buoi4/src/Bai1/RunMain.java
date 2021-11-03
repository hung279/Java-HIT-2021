package Bai1;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Nhap so luong sach: ");
        n = scanner.nextInt();
        Books[] book = new Books[n];
        for (int i = 0; i < n; i++) {
            book[i] = new Books();
            System.out.println("Nhap laoi sach thu " + (i+1) + ": ");
            book[i].input();
        }
        System.out.println("==========THONG TIN SACH===========");
        for (int i = 0; i < n; i++) {
            System.out.println("\n+Loai sach " + (i+1));
            book[i].display();
        }
    }
}
