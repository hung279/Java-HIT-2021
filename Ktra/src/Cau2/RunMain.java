package Cau2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
                    addBook(books);
                    break;
                case 2:
                    editBookByID(books);
                    break;
                case 3:
                    deleteBook(books);
                    break;
                case 4:
                    sortByName(books);
                    break;
                case 5:
                    sortByPrice(books);
                    break;
                case 6:
                    Show(books);
                    break;
                case 7:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Moi ban chon lai tu 1 - 8 de chay chuong trinh!");
            }
        } while (select < 7);
    }

    public static void addBook(ArrayList<Book> books) {
        Book book = new Book();
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

    public static void editBookByID(ArrayList<Book> books) {
        scanner.nextLine();
        if (books.size() == 0) {
            System.out.println("Không có thông tin cuốn sách nào vui lòng nhập thêm sách!");
        } else {
            System.out.print("Nhập id bạn muốn sửa: ");
            String id = scanner.nextLine();
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getId().compareTo(id) == 0) {
                    System.out.print("Các thuộc tính:\n" +
                            "1. ID\n" +
                            "2. Name\n" +
                            "3. Publisher\n" +
                            "4. Price\n" +
                            "5. numberOfPage\n" +
                            "6. author\n" +
                            "Nhập thuộc tính bạn muốn thay đổi: ");
                    int subSelect = scanner.nextInt();
                    scanner.nextLine();
                    switch (subSelect) {
                        case 1:
                            System.out.print("Nhập ID: ");
                            books.get(i).setId(scanner.nextLine());
                            break;
                        case 2:
                            System.out.print("Nhập tên sách: ");
                            books.get(i).setName(scanner.nextLine());
                            break;
                        case 3:
                            System.out.print("Nhập nhà sản xuất: ");
                            books.get(i).setPublisher(scanner.nextLine());
                            break;
                        case 4:
                            System.out.print("Nhập giá: ");
                            books.get(i).setPrice(scanner.nextDouble());
                            scanner.nextLine();
                            break;
                        case 5:
                            System.out.print("Nhập số trang: ");
                            books.get(i).setNumberOfPage(scanner.nextInt());
                            scanner.nextLine();
                            break;
                        case 6:
                            System.out.print("Nhập tên tác giả: ");
                            books.get(i).setAuthor(scanner.nextLine());
                            break;
                    }
                }
            }
        }
    }

    public static void deleteBook(ArrayList<Book> books) {
        scanner.nextLine();
        if (books.size() == 0) {
            System.out.println("Không có thông tin cuốn sách nào vui lòng nhập thêm sách!");
        } else {
            String id;
            System.out.print("Nhập id muốn xóa: ");
            id = scanner.nextLine();
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getId().compareTo(id) == 0) {
                    books.remove(i);
                }
            }
        }
    }

    public static void sortByName(ArrayList<Book> books) {
        if (books.size() == 0) {
            System.out.println("Không có thông tin cuốn sách nào vui lòng nhập thêm sách!");
        } else {
            for (int i = 0; i < books.size()-1; i++) {
                Collections.sort(books, new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
            }
        }
    }

    public static void sortByPrice(ArrayList<Book> books) {
        if (books.size() == 0) {
            System.out.println("Không có thông tin cuốn sách nào vui lòng nhập thêm sách!");
        } else {
            Collections.sort(books, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getPrice() > o2.getPrice() ? -1 : 1;
                }
            });
        }
    }

    public static void Show(ArrayList<Book> books) {
        if (books.size() == 0) {
            System.out.println("Không có thông tin cuốn sách nào vui lòng nhập thêm sách!");
        } else {
            System.out.println("\n===========THONG TIN SACH=============\n");
            System.out.printf(
                    "%-15s %-20s %-20s %-15s %-15s %-20s\n",
                    "ID", "Tên sách", "Nhà xuất bản", "Giá sách", "Số trang", "Tác giả"
            );
            books.forEach(ele -> System.out.printf("%-15s %-20s %-20s %-15f %-15d %-20s\n",
                    ele.getId(), ele.getName(), ele.getPublisher(), ele.getPrice(), ele.getNumberOfPage(), ele.getAuthor()
            ));
        }
    }
}
