package Cau3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<News> newsList = new ArrayList<>();
        int choose;
        do {
            System.out.println("\nIn the following options: ");
            System.out.println("1.Insert News");
            System.out.println("2.View List News");
            System.out.println("3.Average Rate");
            System.out.println("4.Exit");
            System.out.print("Your choose: ");
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    insertNews(newsList);
                    break;
                case 2:
                    viewListNews(newsList);
                    break;
                case 3:
                    averageRateShow(newsList);
                    break;
                case 4:
                    System.out.println("Goodbye!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your choose id invalid");
            }
        } while (true);
    }

    public static void insertNews(List<News> newsList) {
        News news = new News();
        System.out.print("Input id: ");
        news.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Input title: ");
        news.setTitle(scanner.nextLine());
        System.out.print("Input publish date: ");
        news.setPublishDate(scanner.nextLine());
        System.out.print("Input author name: ");
        news.setAuthor(scanner.nextLine());
        System.out.print("Input content: ");
        news.setContent(scanner.nextLine());
        System.out.println("Input rate list: ");
        news.inputRateList();
        newsList.add(news);
    }

    public static void viewListNews (List<News> newsList) {
        for (News post: newsList) {
            post.Display();
        }
    }

    public static void averageRateShow (List<News> newsList) {
        for (News post: newsList) {
            post.Calculate();
            post.Display();
        }
    }
}
