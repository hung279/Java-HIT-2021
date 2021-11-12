package Bai4;

public class RunMain {
    public static void main(String[] args) {
        Sum<Integer> integerSum = new Sum<>(3, 5);
        Sum<Long> longSum = new Sum<>(100L, 200L);
        Sum<Float> floatSum = new Sum<>(3.5f, 6.9f);
        Sum<Double> doubleSum = new Sum<>(7.2d, 2.7d);

        System.out.println("Tong 2 so int: " + (integerSum.getSoA() + integerSum.getSoB()));
        System.out.println("Tong 2 so long: " + (longSum.getSoA() + longSum.getSoB()));
        System.out.println("Tong 2 so float: " + (floatSum.getSoA() + floatSum.getSoB()));
        System.out.println("Tong 2 so double: " + (doubleSum.getSoA() + doubleSum.getSoB()));
    }
}
