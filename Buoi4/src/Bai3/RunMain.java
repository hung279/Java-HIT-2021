package Bai3;

public class RunMain {
    public static void main(String[] args) {
        Bill a = new Bill();
        double sum = 0;
        a.Input();
        System.out.println("\n=======THONG TIN PHIEU========");
        a.Display();
        for (int i = 0; i < a.getN(); i++) {
            sum += a.getX()[i].getPrice();
        }
        System.out.println("Tong tien: " + sum);
    }
}
