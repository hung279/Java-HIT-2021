package View;


import Controller.CustomerController;

import java.util.Scanner;

public class RunMain {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        int choose;
        do {
            System.out.println("\n===============MANUTD STORE=============: ");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Thoát chương trình");
            System.out.print("Chọn: ");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    customerController.SignIn();
                    break;
                case 2:
                    customerController.SignUp();
                    break;
                case 3:
                    System.out.println("Hẹn gặp lại!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }
}
