package Bai1;

public class RunMain {
    public static void main(String[] args) {
        Person Man = new Person("Hưng", 19, "Nam", "Yêu MU");
        System.out.println(Man.toString());
        Person Woman = new Person();
        Woman.setName("NguoiYeu");
        Woman.setAge(18);
        Woman.setGender("Nu");
        Woman.setHobby("Yêu Hưng nhất");
        System.out.println("Name: " + Woman.getName());
        System.out.println("Age: " + Woman.getAge());
        System.out.println("Gender: " + Woman.getGender());
        System.out.println("Hobby: " + Woman.getHobby());
    }
}
