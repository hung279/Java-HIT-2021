package Bai1;

import java.util.Scanner;

public class DieuHoa extends SanPham {
    private double power;
    private double price;

    public DieuHoa() {
    }

    public DieuHoa(String productID, String productName, String manufacturer, String date, double power, double price) {
        super(productID, productName, manufacturer, date);
        this.power = power;
        this.price = price;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        super.Input();
        System.out.print("Nhap cong suat: ");
        power = scanner.nextDouble();
        System.out.print("Nhap gia ban: ");
        price = scanner.nextDouble();
        scanner.nextLine();
    }

    public void Display() {
        super.Display();
        System.out.println("Cong suat: " + power +" W");
        System.out.println("Gia ban: " + price);
    }
}
