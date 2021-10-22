package Bai1;

import java.util.Scanner;
import java.lang.Math;

public class RunMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap a = ");
        int a = scanner.nextInt();
        System.out.print("Nhap b = ");
        int b = scanner.nextInt();
        System.out.print("Nhap c = ");
        int c = scanner.nextInt();
        System.out.println("Max trong 3 so la: " + maxThreeNum(a, b, c));
    }

    public static int maxThreeNum(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
