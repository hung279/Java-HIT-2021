package BaiTap;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class RunMain {
    static Scanner scanner = new Scanner(System.in);
    static List<Account> accountList = new ArrayList<>();
    static Pattern pattern;
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static FileController fileController = new FileController();

    static String regUserName = "^[\\w]{6,}$";
    static String regPassWord = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
    static String regEmail = "^[\\w-]+@[\\w-]{2,}(\\.[\\w-]{2,4}){1,2}$";
    static String regPhoneNumber = "^(0[\\d]{9})|(0[\\d\\-\\s]{11})$";

    public static void main(String[] args) {
        int choose;
        do {
            System.out.println("\nIn the following options: ");
            System.out.println("1. Creat new account");
            System.out.println("2. Login to an existing account.");
            System.out.println("3. Sort accounts by username.");
            System.out.println("4. Exit");
            System.out.print("Your choose: ");
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    creatAccount();
                    break;
                case 2:
                    Login();
                    break;
                case 3:

                    sortAccoutByUsername();
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

    public static void creatAccount() {
        Account account = new Account();
        String username, password, confirmPass, email, phone;

        scanner.nextLine();
        System.out.print("Enten your fullname: ");
        account.setFullName(scanner.nextLine());

        do {
            System.out.print("Enter your username: ");
            pattern = Pattern.compile(regUserName);
            username = scanner.nextLine();
            if (!pattern.matcher(username).find()) {
                System.out.println("Username is invalid");
            } else {
                if (checkExistUsername(username)) {
                    System.out.println("Username already exists");
                } else {
                    account.setUsername(username);
                    break;
                }
            }
        } while (true);

        do {
            System.out.print("Enter your password: ");
            pattern = Pattern.compile(regPassWord);
            password = scanner.nextLine();
            if (!pattern.matcher(password).find()) {
                System.out.println("Password is invalid");
            } else {
                account.setPassword(password);
                break;
            }
        } while (true);

        do {
            System.out.print("Confirm your password: ");
            confirmPass = scanner.nextLine();
            if (password.compareTo(confirmPass) != 0)
                System.out.println("Those passwords didn’t match");
            else
                break;
        } while (true);

        do {
            System.out.print("Enter your email: ");
            pattern = Pattern.compile(regEmail);
            email = scanner.nextLine();
            if (!pattern.matcher(email).find()) {
                System.out.println("Email is invalid");
            } else {
                if (checkExistEmail(email)) {
                    System.out.println("Email already exists");
                } else {
                    account.setEmail(email);
                    break;
                }
            }
        } while (true);

        do {
            System.out.print("Enter your phone number: ");
            pattern = Pattern.compile(regPhoneNumber);
            phone = scanner.nextLine();
            if (!pattern.matcher(phone).find()) {
                System.out.println("Password is invalid");
            } else {
                if (checkExistPhoneNum(phone)) {
                    System.out.println("Username already exists");
                } else {
                    account.setPhone(phone);
                    break;
                }
            }
        } while (true);

        Date date = new Date();
        account.setCreateAt(simpleDateFormat.format(date));

        accountList.add(account);
        fileController.writeAccountToFile("Account.DAT", account);
    }

    public static boolean checkExistUsername(String username) {
        accountList = fileController.ReadAccountFromFile("Account.DAT");
        for (Account account: accountList) {
            if (account.getUsername().compareTo(username) == 0)
                return true;
        }
        return false;
    }

    public static boolean checkExistEmail(String email) {
        accountList = fileController.ReadAccountFromFile("Account.DAT");
        for (Account account: accountList) {
            if (account.getEmail().compareTo(email) == 0)
                return true;
        }
        return false;
    }

    public static boolean checkExistPhoneNum(String phoneNum) {
        accountList = fileController.ReadAccountFromFile("Account.DAT");
        for (Account account: accountList) {
            if (account.getPhone().compareTo(phoneNum) == 0)
                return true;
        }
        return false;
    }

    public static void Login() {
        accountList = fileController.ReadAccountFromFile("Account.DAT");
        String username, password;
        System.out.println("======Sign in======");
        scanner.nextLine();
        System.out.print("Username: ");
        username = scanner.nextLine();
        System.out.print("Password: ");
        password = scanner.nextLine();

        if (checkAccount(username, password)) {
            Account account = new Account();
            for (int i = 0; i < accountList.size(); i++) {
                if (accountList.get(i).getUsername().compareTo(username) == 0)
                    account = accountList.get(i);
            }

            int choose;
            do {
                System.out.println("\nLogin successful");
                System.out.println("1. Show info");
                System.out.println("2. Change password");
                System.out.println("3. Exit");
                System.out.print("Your choose: ");
                choose = scanner.nextInt();
                scanner.nextLine();
                switch (choose) {
                    case 1:
                        account.display();
                        break;
                    case 2:
                        changePassword(username, password, account);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Your choose id invalid");
                }
            } while (true);
        } else {
            System.out.println("\nLogin unsuccessful");
        }
    }

    public static boolean checkAccount(String username, String password) {
        accountList = fileController.ReadAccountFromFile("Account.DAT");
        for (Account account: accountList) {
            if (account.getUsername().compareTo(username) == 0 && account.getPassword().compareTo(password) == 0)
                return true;
        }
        return false;
    }

    public static void changePassword(String username, String password, Account account) {
        String curPassword, newPassword, confirmPass;
        do {
            System.out.print("Current password: ");
            curPassword = scanner.nextLine();
            if (curPassword.compareTo(password) == 0)
                break;
            else
                System.out.println("Password is incorrect. Try again");
        } while (true);

        do {
            System.out.print("New password: ");
            pattern = Pattern.compile(regPassWord);
            newPassword = scanner.nextLine();
            if (!pattern.matcher(password).find()) {
                System.out.println("Password is invalid");
            } else {
                break;
            }
        } while (true);

        do {
            System.out.print("Confirm password: ");
            confirmPass = scanner.nextLine();
            if (newPassword.compareTo(confirmPass) != 0)
                System.out.println("Those passwords didn’t match");
            else
                break;
        } while (true);

        System.out.println("Your password is changed successful");
        account.setPassword(newPassword);
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUsername().compareTo(username) == 0) {
                accountList.set(i, account);
                break;
            }
        }
        fileController.updateAccountInFile("Account.DAT", accountList);
    }

    public static void sortAccoutByUsername() {
        accountList = fileController.ReadAccountFromFile("Account.DAT");
        System.out.println("==============SORT ACCOUNT BY USERNAME================\n");
        System.out.printf("%-10s | %-25s | %-15s | %-30s | %-15s | %-20s\n", "ID", "Fullname", "Username", "Email", "Phone Number", "Creat at");
        Collections.sort(accountList);
        for (Account account: accountList) {
            account.display();
        }
    }
}
