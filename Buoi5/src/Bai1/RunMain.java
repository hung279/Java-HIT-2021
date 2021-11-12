package Bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Nhap so luong dieu hoa: ");
            n = scanner.nextInt();
        } while (n <= 0);
        ArrayList<DieuHoa> dieuHoaArrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            DieuHoa dieuHoa = new DieuHoa();
            dieuHoa.Input();
            dieuHoaArrayList.add(dieuHoa);
        }
        int count = 0;
        double min = dieuHoaArrayList.get(0).getPrice();
        for (int i = 0; i < n; i++) {
            if(dieuHoaArrayList.get(i).getManufacturer().equals("Electrolux"))
                count++;
            if(dieuHoaArrayList.get(i).getPrice() < min)
                min = dieuHoaArrayList.get(i).getPrice();

        }
        if (count == 0) {
            System.out.println();
            System.out.println("-Khong ton tai san pham hang Electrolux");
        } else {
            System.out.println();
            System.out.println("=============Danh sach dieu hoa Electrolux============");
            for (int i = 0; i < n; i++) {
                if (dieuHoaArrayList.get(i).getManufacturer().equals("Electrolux"))
                    dieuHoaArrayList.get(i).Display();
            }
        }
        System.out.println();
        System.out.println("=============Danh sach san pham Electrolux gia thap nhat============");
        for (int i = 0; i < n; i++) {
            if (dieuHoaArrayList.get(i).getPrice() == min)
                dieuHoaArrayList.get(i).Display();
        }
    }
}
