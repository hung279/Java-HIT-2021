package Bai2;

import java.util.Scanner;

public class RunMain {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        int select;
        do {
            System.out.print("\nNhap n = ");
            n = scanner.nextInt();
        } while (n < 1);
        arr = new int[100];
        do {
            System.out.println("\n\nChon cac lua chon sau: ");
            System.out.println("1. Nhap mang voi n so nguyen");
            System.out.println("2. Hien thi mang vua tao");
            System.out.println("3. Them 1 phan tu vao vi tri k bat ky");
            System.out.println("4. Xoa 1 phan tu tai vi tri k bat ky");
            System.out.println("5. Dao nguoc mang");
            System.out.println("6. Hien thi phan tu a[1] va cac so chia het cho a[1]");
            System.out.println("7. Xuat ra man hinh tong cac so nguyen to co trong mang");
            System.out.println("8. Thoat chuong trinh");

            System.out.print("\n====> Moi ban nhap lua chon: ");
            select = scanner.nextInt();

            switch (select) {
                case 1:
                    inputArray();
                    break;
                case 2:
                    displayArray();
                    break;
                case 3:
                    insertToArray();
                    break;
                case 4:
                    removeFromArray();
                    break;
                case 5:
                    reverseArray();
                    break;
                case 6:
                    displayElement();
                    break;
                case 7:
                    sumOfPrime();
                    break;
                case 8:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Moi ban chon lai tu 1 - 8 de chay chuong trinh!");
            }
        } while (select < 8);
    }

    public static void inputArray() {
        System.out.println("Nhap mang: ");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }
    }

    public static void displayArray() {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertToArray() {
        System.out.print("\nNhap phan tu muon chen t = ");
        int t = scanner.nextInt();
        int k;
        do {
            System.out.print("Nhap vi tri chen k(k>n) = ");
            k = scanner.nextInt();
        } while (k <= 0 || k > n);
        for (int i = n; i > k-1; i--)
        {
            arr[i] = arr[i-1];
        }
        arr[k-1]=t;
        n++;
        System.out.print("Mang sau khi chen: ");
        displayArray();
    }

    public static void removeFromArray() {
        int k;
        do {
            System.out.print("Nhap vi tri xoa k(k>n) = ");
            k = scanner.nextInt();
        } while (k <= 0 || k > n);
        for (int i = k - 1; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        n--;
        System.out.print("Mang sau khi xoa: ");
        displayArray();
    }

    public static void reverseArray() {
        System.out.print("Mang dao nguoc: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void displayElement() {
        if (n < 2)
            System.out.println("Lenh nay khong thuc hien duoc vi n < 2");
        else {
            System.out.println("Phan tu a[1]: " + arr[1]);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] != arr[1] && arr[i] % arr[1] == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("Khong co phan tu nao chia het cho a[1]");
            } else {
                System.out.print("Phan tu chia het cho a[1]: ");
                for (int i = 0; i < n; i++) {
                    if (arr[i] != arr[1] && arr[i] % arr[1] == 0)
                        System.out.print(arr[i] + " ");
                }
            }
        }
    }

    public static boolean isPrime(int a) {
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) return false;
        }
        return a > 1;
    }

    public static void sumOfPrime() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(arr[i])) sum += arr[i];
        }
        if (sum == 0)
            System.out.println("Mang khong co so nguyen to nao");
        else
            System.out.println("Tong cac so nguyen to: " + sum);
    }
}
