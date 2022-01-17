package Controller;

import Model.Bill;
import Model.Customer;
import Model.SportsProduct;
import Model.Ticket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderController {
    Scanner sc = new Scanner(System.in);
    FileController fileController = new FileController();
    ProductController productController = new ProductController();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    List<SportsProduct> sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
    List<Ticket> ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
    List<Bill> billList = new ArrayList<>();
    List<Customer> customerList= new ArrayList<>();
    public void orderSportsProduct(Customer customer) {
        SportsProduct sp = new SportsProduct();
        String id;
        int quantity;
        productController.ShowSportsProduct();
        do {
            System.out.print("Nhập id sản phẩm bạn muốn mua: ");
            id = sc.nextLine();
            if (!productController.CheckSportsProductID(id)) {
                System.out.println("ID sản phẩm không tồn tại. Vui lòng nhập lại!");
            }
        } while (!productController.CheckSportsProductID(id));
        for (int i = 0; i < sportsProductList.size(); i++) {
            if (sportsProductList.get(i).getId().compareTo(id) == 0) {
                sp = sportsProductList.get(i);
            }
        }
        do {
            System.out.print("Nhập số lượng muốn mua: ");
            quantity = sc.nextInt();
            if (!productController.CheckQuantitySP(id, quantity)) {
                System.out.println("Số lượng sản phẩm bạn cần không đủ hoặc đã hết. Vui lòng nhập lại!");
            } else {
                productController.ReduceQuantitySP(id, quantity, sp);
            }
        } while (!productController.CheckQuantitySP(id, quantity));
        Bill bill = new Bill();
        bill.setIdBill(creatBillID());
        bill.setCustomerID(customer.getId());
        bill.setCustomerName(customer.getFullName());
        Date date = new Date();
        bill.setPurchaseDate(simpleDateFormat.format(date));
//        bill.getPurchasedProduct().add(sp);
//        bill.setTotalMoney(sp.getQuantity()* sp.getPrice());
        billList.add(bill);
        fileController.writeBillToFile("BILL.DAT", bill);
    }

    public void orderTicket(Customer customer) {
        CustomerController customerController = new CustomerController();
        Ticket ticket = new Ticket();
        String id;
        int quantity;
        productController.ShowTicket();
        do {
            System.out.print("Nhập id vé bạn muốn mua: ");
            id = sc.nextLine();
            if (!productController.CheckTicketID(id)) {
                System.out.println("ID sản phẩm không tồn tại. Vui lòng nhập lại!");
            }
        } while (!productController.CheckTicketID(id));
        for (int i = 0; i < ticketList.size(); i++) {
            if (ticketList.get(i).getId().compareTo(id) == 0) {
                ticket = ticketList.get(i);
            }
        }
        do {
            System.out.print("Nhập số lượng muốn mua: ");
            quantity = sc.nextInt();
            if (!productController.CheckQuantityTK(id, quantity)) {
                System.out.println("Số lượng sản phẩm bạn cần không đủ hoặc đã hết. Vui lòng nhập lại!");
            } else {
                productController.ReduceQuantityTK(id, quantity, ticket);
            }
        } while (!productController.CheckQuantityTK(id, quantity));

        Bill bill = new Bill();
        bill.setIdBill(creatBillID());
        bill.setCustomerID(customer.getId());
        bill.setCustomerName(customer.getFullName());
        Date date = new Date();
        bill.setPurchaseDate(simpleDateFormat.format(date));
//        bill.getPurchasedTicket().add(ticket);
//        bill.setTotalMoney(ticket.getQuantity()* ticket.getPrice());
        billList.add(bill);
        fileController.writeBillToFile("BILL.DAT", bill);
    }

    public long creatBillID() {
        billList = fileController.ReadBillFromFile("BILL.DAT");
        return billList.size()+1;
    }
//    public void ShowBill() {
//        billList = fileController.ReadBillFromFile("BILL.DAT");
//        for (Bill bill: billList) {
//            System.out.println(bill);
//        }
//    }


}
