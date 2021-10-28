package Bai3;


import java.util.Random;

public class RunMain {
    public static void main(String[] args) {
        Random random = new Random();
        Guns DiepBeDe = new Guns("AK-47-21", 100);
        Guns DoanXinhGai = new Guns("AK-47-20", 100);

        while (true) {
            int a = DiepBeDe.shoot(random.nextInt(10)+1);
            int b = DoanXinhGai.shoot(random.nextInt(10)+1);
            if (a == 0 && b == 0) {
                System.out.println("Cả 2 đều hết đạn. Nạp đạn bắn tiếp");
                DiepBeDe.load(random.nextInt(10)+1);
                DoanXinhGai.load(random.nextInt(10)+1);
            } else if (a == 0) {
                System.out.println("Anh DiepBeDe hết đạn. Anh DoanXinhGai thắng");
                break;
            } else if (b == 0) {
                System.out.println("Anh DoanXinhGai hết đạn. Anh DiepBeDe thắng");
                break;
            } else {
                DiepBeDe.load(random.nextInt(10)+1);
                DoanXinhGai.load(random.nextInt(10)+1);
            }
        }
    }
}
