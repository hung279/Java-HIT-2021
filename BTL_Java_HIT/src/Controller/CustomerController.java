package Controller;

import Model.Bill;
import Model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerController {
    List<Customer> customersList = new ArrayList<>();
    String regUserName = "^[\\w]{6,}$";
    String regPassWord = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
    String regPhoneNumber = "^(0[\\d]{9})|(0[\\d\\-\\s]{11})$";

    FileController fileController = new FileController();
    ProductController productController = new ProductController();
    OrderController orderController = new OrderController();
    BillController billController = new BillController();
    Pattern pattern;

    Scanner sc = new Scanner(System.in);

    public void SignIn() {
        customersList = fileController.ReadAccountFromFile("CUSTOMERS.DAT");
        String username, password;
        System.out.println("======Đăng nhập======");
        System.out.print("Tài khoản: ");
        username = sc.nextLine();
        System.out.print("Mật khẩu: ");
        password = sc.nextLine();

        if (checkAccount(username, password)) {
            Customer customer = new Customer();
            for (int i = 0; i < customersList.size(); i++) {
                if (customersList.get(i).getUsername().compareTo(username) == 0)
                    customer = customersList.get(i);
            }

            if(username.compareTo("admin") == 0) {
                //admin
                int choose;
                do {
                    System.out.println("\nĐăng nhập thành công");
                    System.out.println("1. Xem danh sách sản phẩm");
                    System.out.println("2. Xem danh sahcs vé");
                    System.out.println("3. Thêm sản phẩm");
                    System.out.println("4. Sửa sản phẩm");
                    System.out.println("5. Xóa sản phẩm");
                    System.out.println("6. Sắp xếp sản phẩm");
                    System.out.println("7. Xem danh sách customer");
                    System.out.println("8. Xem hóa đơn customer");
                    System.out.println("9. Exit");
                    System.out.print("Your choose: ");
                    choose = sc.nextInt();
                    sc.nextLine();
                    switch (choose) {
                        case 1:
                            productController.ShowSportsProduct();
                            break;
                        case 2:
                            productController.ShowTicket();
                            break;
                        case 3:
                            productController.AddProduct();
                            break;
                        case 4:
                            productController.fixProduct();
                            break;
                        case 5:
                            productController.removeProduct();
                            break;
                        case 6:
                            int select;
                            do {
                                System.out.println("Sắp xếp sản phẩm");
                                System.out.println("1. Hàng thể thao");
                                System.out.println("2. Vé trận đấu");
                                System.out.println("3. Thoát");
                                System.out.print("Chọn: ");
                                select = sc.nextInt();

                                switch (select) {
                                    case 1:
                                        productController.sortSportsProduct();
                                        break;
                                    case 2:
                                        productController.sortTicket();
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Lựa chọn không hợp lệ");
                                }
                            } while (select < 3);

                        case 7:
                            showCustomerList();
                            break;
                        case 8:
                            //danh sach bill
                            System.out.println("Chúc năng này chưa hoàn thiện :<<");
                            break;
                        case 9:
                            return;
                        default:
                            System.out.println("Your choose id invalid");
                    }
                } while (true);
            } else {
                //customer
                int choose2;
                do {
                    System.out.println("\nĐăng nhập thành công");
                    System.out.println("1. Xem danh sách sản phẩm thể thao");
                    System.out.println("2. Xem danh sách vé");
                    System.out.println("3. Mua hàng");
                    System.out.println("4. Mua vé");
                    System.out.println("5. Sắp xếp sản phẩm");
                    System.out.println("6. Tìm kiếm sản phẩm");
                    System.out.println("7. Xem đơn hàng");
                    System.out.println("8. Exit");
                    System.out.print("Your choose: ");
                    choose2 = sc.nextInt();
                    sc.nextLine();
                    switch (choose2) {
                        case 1:
                            productController.ShowSportsProduct();
                            break;
                        case 2:
                            if (!checkCustomerIsFan(customer.getId())) {
                                System.out.println("Bạn phải là Fan của CLB mới xem và mua được vé. \nĐể là Fan của CLB bạn phải mua hàng 3 lần trở lên");
                            } else {
                                productController.ShowTicket();
                            }
                            break;
                        case 3:
                            sc.nextLine();
                            orderController.orderSportsProduct(customer);
                            break;
                        case 4:
                            sc.nextLine();
                            if (!checkCustomerIsFan(customer.getId())) {
                                System.out.println("Bạn phải là Fan của CLB mới xem và mua được vé. \nĐể là Fan của CLB bạn phải mua hàng 3 lần trở lên");
                            } else {
                                orderController.orderTicket(customer);
                            }
                            break;
                        case 5:
                            int select;
                            do {
                                System.out.println("Sắp xếp sản phẩm");
                                System.out.println("1. Hàng thể thao");
                                System.out.println("2. Vé trận đấu");
                                System.out.println("3. Thoát");
                                System.out.print("Chọn: ");
                                select = sc.nextInt();

                                switch (select) {
                                    case 1:
                                        productController.sortSportsProduct();
                                        break;
                                    case 2:
                                        if (!checkCustomerIsFan(customer.getId())) {
                                            System.out.println("Bạn phải là Fan của CLB mới xem và mua được vé. \nĐể là Fan của CLB bạn phải mua hàng 3 lần trở lên");
                                        } else {
                                            productController.sortTicket();
                                        }
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Lựa chọn không hợp lệ");
                                }
                            } while (select < 3);

                        case 6:
                            productController.findProduct();
                            break;
                        case 7:
                            //orderController.ShowBill();
                            System.out.println("Chức năng này chưa hoàn thiện");
                            break;
                        case 8:
                            return;
                        default:
                            System.out.println("Lựa chọn không hợp lệ");
                    }
                } while (true);
            }

        } else {
            System.out.println("\nBạn nhập sai tài khoản hoặc mật khẩu");
        }
    }

    public void SignUp() {
        Customer customer = new Customer();
        String username, password, confirmPass, phone;
        int id = creatCustomerID();
        customer.setId(id);
        System.out.print("Nhập họ tên: ");
        customer.setFullName(sc.nextLine());

        do {
            System.out.print("Nhập tên tài khoản: ");
            pattern = Pattern.compile(regUserName);
            username = sc.nextLine();
            if (!pattern.matcher(username).find()) {
                System.out.println("Tải khoản không hợp lệ");
            } else {
                if (checkExistUsername(username)) {
                    System.out.println("Tài khoản đã tồn tại");
                } else {
                    customer.setUsername(username);
                    break;
                }
            }
        } while (true);

        do {
            System.out.println("Mật khẩu yêu cầu 8 ký tự trở lên, có it nhất 1 chữ hoa, \nít nhất 1 chữ thường và ít nhất 1 số");
            System.out.print("Nhập mật khẩu: ");
            pattern = Pattern.compile(regPassWord);
            password = sc.nextLine();
            if (!pattern.matcher(password).find()) {
                System.out.println("Mật khẩu không hợp lệ");
            } else {
                customer.setPassword(password);
                break;
            }
        } while (true);

        do {
            System.out.print("Xác nhận mật khẩu: ");
            confirmPass = sc.nextLine();
            if (password.compareTo(confirmPass) != 0)
                System.out.println("Mật khẩu không trung nhau");
            else
                break;
        } while (true);

        do {
            System.out.print("Nhập số điện thoại: ");
            pattern = Pattern.compile(regPhoneNumber);
            phone = sc.nextLine();
            if (!pattern.matcher(phone).find()) {
                System.out.println("Số điện thoại không hợp lệ");
            } else {
                if (checkExistPhoneNum(phone)) {
                    System.out.println("Số điện thoại đã tồn tại");
                } else {
                    customer.setPhoneNumber(phone);
                    break;
                }
            }
        } while (true);

        System.out.print("Nhập tuổi: ");
        customer.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        customer.setAddress(sc.nextLine());
        //Date date = new Date();
        //account.setCreateAt(simpleDateFormat.format(date));

        customersList.add(customer);

        fileController.writeCustomerToFile("CUSTOMERS.DAT", customer);
    }

    public int creatCustomerID() {
        customersList = fileController.ReadAccountFromFile("CUSTOMERS.DAT");
        return customersList.size()+1;
    }

    public boolean checkExistUsername(String username) {
        customersList = fileController.ReadAccountFromFile("CUSTOMERS.DAT");
        for (Customer account: customersList) {
            if (account.getUsername().compareTo(username) == 0)
                return true;
        }
        return false;
    }

    public boolean checkExistPhoneNum(String phoneNum) {
        customersList = fileController.ReadAccountFromFile("CUSTOMERS.DAT");
        for (Customer account: customersList) {
            if (account.getPhoneNumber().compareTo(phoneNum) == 0)
                return true;
        }
        return false;
    }

    public boolean checkAccount(String username, String password) {
        customersList = fileController.ReadAccountFromFile("CUSTOMERS.DAT");
        for (Customer account: customersList) {
            if (account.getUsername().compareTo(username) == 0 && account.getPassword().compareTo(password) == 0)
                return true;
        }
        return false;
    }

    public boolean checkCustomerIsFan(long id) {
        List<Bill> billList = fileController.ReadBillFromFile("BILL.DAT");
        int count = 0;
        for (Bill bill: billList) {
            if(bill.getCustomerID() == id) {
                count++;
            }
        }
        if(count >= 3) return true;
        return false;
    }

    public void showCustomerList() {
        customersList = fileController.ReadAccountFromFile("CUSTOMERS.DAT");
        System.out.printf("%-10s | %-25s | %-15s | %-15s | %-10s | %-15s | %-25s\n",
                "ID", "Họ và tên", "Tài khoản", "Mật khẩu", "Tuổi", "SĐT", "Địa chỉ"
        );
        for (Customer customer: customersList) {
            System.out.printf("%-10s | %-25s | %-15s | %-15s | %-10s | %-15s | %-25s\n",
                    customer.getId(), customer.getFullName(), customer.getUsername(),
                            customer.getPassword(), customer.getAge(),
                            customer.getPhoneNumber(), customer.getAddress()
            );
        }
    }
}
