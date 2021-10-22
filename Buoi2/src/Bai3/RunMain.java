package Bai3;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String str = scanner.nextLine();
        int sum = 0, count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
                count++;
            }
        }

        if (count != 0) {
            System.out.println(true);
            System.out.print("Trung binh cong cac so: " + sum * 1.0 / count);
        } else {
            System.out.println(false);
        }

    }
}
