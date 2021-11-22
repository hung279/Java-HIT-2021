package Cau2;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Book book = new Book();
        ArrayList<Book> books = new ArrayList<>();
        int select;
        do {
            System.out.println("\n\nChon cac lua chon sau: ");
            System.out.println("1. Add book");
            System.out.println("2. Edit book by id");
            System.out.println("3. Delete book by id");
            System.out.println("4. Sort books by name (ascending)");
            System.out.println("5. Sort books by price (descending)");
            System.out.println("6. Show all books");
            System.out.println("7. Exit");

            System.out.print("\n====> Moi ban nhap lua chon: ");
            select = scanner.nextInt();

            switch (select) {
                case 1:
                    addBook(book, books);
                    break;
                case 2:

                    break;
                case 3:
                    deleteBook(book,books);
                    break;
                case 4:
                    sortByName(book, books);
                    break;
                case 5:
                    sortByPrice(book, books);
                    break;
                case 6:
                    Show(book, books);
                    break;
                case 7:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Moi ban chon lai tu 1 - 8 de chay chuong trinh!");
            }
        } while (select < 7);
    }

    public static void addBook(Book book, ArrayList<Book> books) {
        scanner.nextLine();
        System.out.print("Nhập id: ");
        book.setId(scanner.nextLine());
        System.out.print("Nhập tên sách: ");
        book.setName(scanner.nextLine());
        System.out.print("Nhập nhà sản xuất: ");
        book.setPublisher(scanner.nextLine());
        System.out.print("Nhập giá: ");
        book.setPrice(scanner.nextDouble());
        System.out.print("Nhập số trang: ");
        book.setNumberOfPage(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Nhập tên tác giả: ");
        book.setAuthor(scanner.nextLine());
        books.add(book);
    }

    public static void editBookByID(Book book, ArrayList<Book> books) {

    }

    public static void deleteBook(Book book, ArrayList<Book> books) {
        String id;
        System.out.print("Nhập id muốn xóa: ");
        id = scanner.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
            }
        }
    }

    public static void sortByName(Book book, ArrayList<Book> books) {
        for (int i = 0; i < books.size()-1; i++) {
            for (int j = i+1; j < books.size() ; j++) {
                if (books.get(i).getName().compareToIgnoreCase(books.get(j).getName()) > 0) {
                    Book temp = books.get(i);
                        books.set(i , books.get(j));
                        books.set(j, temp);
                }
            }
        }
    }

    public static void sortByPrice(Book book, ArrayList<Book> books) {
        for (int i = 0; i < books.size()-1; i++) {
            for (int j = i+1; j < books.size() ; j++) {
                if (books.get(i).getPrice() < books.get(j).getPrice()) {
                    Book temp = books.get(i);
                        books.set(i , books.get(j));
                        books.set(j, temp);
                }
            }
        }
    }

    public static void Show(Book book, ArrayList<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println("ID: " + books.get(i).getId());
            System.out.println("Tên sách: " + books.get(i).getName());
            System.out.println("NSX: " + books.get(i).getPublisher());
            System.out.println("Giá: " + books.get(i).getPrice());
            System.out.println("Số trang: " + books.get(i).getNumberOfPage());
            System.out.println("Tác giả: " + books.get(i).getAuthor());
        }
    }
}
