package Cau3;

import java.util.Scanner;

public class News implements INews{
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;

    int[] rateList = new int[3];

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    @Override
    public void Display() {
        System.out.println("News title: " + getTitle());
        System.out.println("News publish date: " + getPublishDate());
        System.out.println("News author: " + getAuthor());
        System.out.println("News content: " + getContent());
        System.out.println("News average of rate: " + getAverageRate());
    }

    public void inputRateList() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Input rate " + i + ": ");
            rateList[i] = scanner.nextInt();
        }
        scanner.nextLine();
    }

    public void Calculate() {
        averageRate = (float) ((rateList[0] + rateList[1] + rateList[2])*1.0/3);
    }
}
