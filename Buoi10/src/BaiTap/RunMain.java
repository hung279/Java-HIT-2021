package BaiTap;

import java.util.*;

public class RunMain {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Input quantity of person: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                Person person = new Person();
                System.out.print("Input id: ");
                person.setId(scanner.nextLine());
                System.out.print("Input name: ");
                person.setName(scanner.nextLine());
                System.out.print("Input address: ");
                person.setAddress(scanner.nextLine());
                personList.add(person);
            }
            Collections.sort(personList);
            System.out.println("\n==========PERSON LIST===============\n");
            System.out.printf("%-10s | %-20s | %-20s\n", "ID", "Name", "Address");
            personList.forEach(person -> System.out.printf(
                    "%-10s | %-20s | %-20s\n", person.getId(), person.getName(), person.getAddress()
            ));
            Collections.sort(personList, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    if (o1.getName().compareTo(o2.getName()) != 0)
                        return o1.getName().compareTo(o2.getName());
                    else
                        return o2.getAddress().compareTo(o1.getAddress());
                }
            });
            System.out.println("\n==========PERSON LIST SORT BY NAME===============\n");
            System.out.printf("%-10s | %-20s | %-20s\n", "ID", "Name", "Address");
            personList.forEach(person -> System.out.printf(
                    "%-10s | %-20s | %-20s\n", person.getId(), person.getName(), person.getAddress()
            ));
        } catch (Exception ex) {
            System.out.print("Error: Input mismatch, please try again!");
        }
    }
}
