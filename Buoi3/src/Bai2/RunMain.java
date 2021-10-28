package Bai2;

public class RunMain {
    public static void main(String[] args) {
        Array arr1 = new Array();
        Array arr2 = new Array();
        System.out.println("Nhap mang arr1:");
        arr1.inputData();
        System.out.println("Nhap mang arr1:");
        arr2.inputData();
        System.out.print("Mang arr1: ");
        arr1.show();
        System.out.print("Mang arr2: ");
        arr2.show();
        float avg1 = (float)arr1.sum()/arr1.getN();
        float avg2 = (float)arr2.sum()/arr2.getN();
        if (avg1 > avg2) {
            System.out.println("Arr1 > Arr2");
        } else if (avg1 < avg2) {
            System.out.println("Arr1 < Arr2");
        } else {
            System.out.println("Bye");
        }
    }
}
