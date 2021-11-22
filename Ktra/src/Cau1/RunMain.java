package Cau1;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();
        int count = 0;
        int sum = 0;
        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                count++;
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
                number.add(Integer.parseInt(String.valueOf(str.charAt(i))));
            }
        }
        System.out.println("Có "+count+" ký tự số");
        if(count == 0) {
            System.out.println("Không có ký tự số nào để tính tích các ước của tổng các chữ số");
        } else {
            int product = 1;
            int subCount = 0;
            for (int i = 0; i < number.size(); i++) {
                if(sum % number.get(i) == 0) {
                    product *= number.get(i);
                    subCount++;
                }
            }
            if(subCount == 0) {
                System.out.println("Không có số nào là ước của tổng các chữ số");
            } else {
                System.out.println("Tich: " + product);
            }
        }
    }
}
