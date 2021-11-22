package Bai3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RunMain {
    public static void Input(Classroom cr) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma lop hop: ");
        cr.setClassID(scanner.nextLine());
        System.out.print("Nhap ten lop hoc: ");
        cr.setClassName(scanner.nextLine());
        System.out.print("Nhap ngay mo: ");
        cr.setDate(scanner.nextLine());
        System.out.print("Nhap so luong sinh vien: ");
        cr.setN(scanner.nextInt());
        scanner.nextLine();
        ArrayList<Student> x = new ArrayList<>();
        for (int i = 0; i < cr.getN(); i++) {
            Student s = new Student();
            System.out.println("Nhap sinh thu " + (i+1));
            s.Input();
            System.out.print("Nhap ma sinh vien: ");
            s.setStudentID(scanner.nextLine());
            System.out.print("Nhap nganh: ");
            s.setMajor(scanner.nextLine());
            System.out.print("Nhap khoa hoc: ");
            s.setCourse(scanner.nextInt());
            scanner.nextLine();
            x.add(s);
        }
        cr.setX(x);
        System.out.print("Nhap giao vien: ");
        cr.setTeacher(scanner.nextLine());
    }

    public static void Output(Classroom cr) {
        System.out.println("Ma lop: " + cr.getClassID());
        System.out.println("Ten lop: " + cr.getClassName());
        System.out.println("Ngay mo: " + cr.getDate());
        for (int i = 0; i < cr.getX().size(); i++) {
            System.out.println("+Sinh vien thu " + (i+1));
            cr.getX().get(i).Output();
            System.out.println("Ma SV: " + cr.getX().get(i).getStudentID());
            System.out.println("Nganh hoc: " + cr.getX().get(i).getMajor());
            System.out.println("Khoa: K" + cr.getX().get(i).getCourse());
        }
        System.out.println("Giao vien: " + cr.getTeacher());
    }

    public static int countCourseK15(Classroom cr) {
        int count = 0;
        for (int i = 0; i < cr.getX().size(); i++) {
            if (cr.getX().get(i).getCourse() == 15)
                count++;
        }
        return count;
    }

    public static void Sort(Classroom cr) {
//        for (int i = 0; i < cr.getX().size()-1; i++) {
//            for (int j = i + 1; j < cr.getX().size(); j++) {
//                if (cr.getX().get(i).getCourse() > cr.getX().get(j).getCourse()) {
//                    Student temp = cr.getX().get(i);
//                    cr.getX().set(i, cr.getX().get(j));
//                    cr.getX().set(j, temp);
//                }
//            }
//        }
        Collections.sort(cr.getX(), new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getCourse() < o2.getCourse() ? -1 : 1;
            }
        });
        Output(cr);
    }

    public static void main(String[] args) {
        Classroom cr = new Classroom();
        Input(cr);
        System.out.println("\n============THONG TIN LOP HOC============\n");
        System.out.println();
        Output(cr);
        System.out.println("\n- Lop hoc co " + countCourseK15(cr) + " sinh vien K15");
        System.out.println("\n============SAP XEP THONG TIN============\n");
        Sort(cr);
    }
}
