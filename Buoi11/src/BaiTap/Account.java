package BaiTap;

public class Account implements Comparable<Account>{
    private long id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String createAt;
    private static long auto = 10000;

    public Account() {
        id = ++auto;
    }

    public Account(long id, String fullName, String username, String password, String email, String phone, String createAt) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public void display() {
        System.out.printf("%-10d | %-25s | %-15s | %-30s | %-15s | %-20s\n", id, fullName, username, email, phone, createAt);
    }

    @Override
    public int compareTo(Account o) {
        return getUsername().compareTo(o.getUsername());
    }
}
