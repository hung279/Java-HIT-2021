package Bai4;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String str = scanner.nextLine();
        str = str.trim();
        str = str.toLowerCase();
        str = str.replaceAll("[0-9]", "");
        while (str.indexOf("  ") != -1) str = str.replaceAll("  ", " ");
        String[] temp = str.split(" ");
        str = "";
        for (int i = 0; i < temp.length; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) str += " ";
        }
        System.out.println(str);
    }
}
