package Controller;



import Model.Bill;
import Model.Customer;
import Model.SportsProduct;
import Model.Ticket;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileController {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;

    public void openFileToWrite(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFileAfterWrite(String fileName) {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openFileToRead(String fileName){
        try {
            scanner = new Scanner(Paths.get(fileName));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void closeFileAfterRead(String fileName){
        scanner.close();
    }

    public void writeCustomerToFile(String fileName, Customer customer) {
        openFileToWrite(fileName);
        printWriter.println(
                customer.getId() + "|" + customer.getFullName() + "|" + customer.getUsername() + "|" + customer.getPassword() + "|" + customer.getPhoneNumber()+ "|" + customer.getAge() + "|" + customer.getAddress()
        );
        closeFileAfterWrite(fileName);
    }

    public void writeSportsProductToFile(String fileName, SportsProduct sportsProduct) {
        openFileToWrite(fileName);
        printWriter.println(
                sportsProduct.getId() + "|" + sportsProduct.getName() + "|" + sportsProduct.getProductType()
                        + "|" + sportsProduct.getQuantity() + "|" + sportsProduct.getPrice()
                        + "|" + sportsProduct.getSize() + "|" + sportsProduct.getColor()
        );
        closeFileAfterWrite(fileName);
    }
    public void writeTicketToFile(String fileName, Ticket ticket) {
        openFileToWrite(fileName);
        printWriter.println(
                ticket.getId() + "|" + ticket.getName() + "|" + ticket.getProductType()
                            + "|" + ticket.getQuantity() + "|" + ticket.getPrice()
                            + "|" + ticket.getTicketType()
        );
        closeFileAfterWrite(fileName);
    }

    public void writeBillToFile(String fileName, Bill bill) {
        openFileToWrite(fileName);
//        String sp = "";
//        String tk = "";
//        for (int i=0;i<bill.getPurchasedProduct().size();i++){
//            sp += bill.getPurchasedProduct().get(i).getId();
//        }
//        for (int i=0;i<bill.getPurchasedTicket().size();i++){
//            tk += bill.getPurchasedTicket().get(i).getId();
//        }

        printWriter.println(
                bill.getIdBill() + "|" + bill.getCustomerID() + "|" + bill.getCustomerName() + "|" + bill.getPurchaseDate()

        );
        closeFileAfterWrite(fileName);
    }

    public List<Customer> ReadAccountFromFile(String fileName) {
        openFileToRead((fileName));
        List<Customer> customerList = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            String[] dt = data.split("\\|");
            customerList.add(new Customer(Integer.parseInt(dt[0]), dt[1], dt[2], dt[3], dt[4], Integer.parseInt(dt[5]), dt[6]));
            //System.out.println(dt[0] +"|"+ dt[1] +"|"+ dt[2] +"|"+ dt[3] +"|"+ dt[4] +"|"+ dt[5] +"|"+ dt[6]);
        }
        closeFileAfterRead(fileName);
        return customerList;
    }

    public List<SportsProduct> ReadSportsProductFromFile(String fileName) {
        openFileToRead((fileName));
        List<SportsProduct> spList = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            String[] dt = data.split("\\|");
            spList.add(new SportsProduct(dt[0], dt[1], dt[2], Integer.parseInt(dt[3]), Float.parseFloat(dt[4]), dt[5], dt[6]));
            //System.out.println(dt[0] +"|"+ dt[1] +"|"+ dt[2] +"|"+ dt[3] +"|"+ dt[4] +"|"+ dt[5] +"|"+ dt[6]);
        }
        closeFileAfterRead(fileName);
        return spList;
    }

    public List<Ticket> ReadTicketFromFile(String fileName) {
        openFileToRead((fileName));
        List<Ticket> tkList = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            String[] dt = data.split("\\|");
            tkList.add(new Ticket(dt[0], dt[1], dt[2], Integer.parseInt(dt[3]), Float.parseFloat(dt[4]), dt[5]));
            //System.out.println(dt[0] +"|"+ dt[1] +"|"+ dt[2] +"|"+ dt[3] +"|"+ dt[4] +"|"+ dt[5] +"|"+ dt[6]);
        }
        closeFileAfterRead(fileName);
        return tkList;
    }

    public List<Bill> ReadBillFromFile(String fileName) {
        openFileToRead((fileName));
        List<Bill> billList = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            String[] dt = data.split("\\|");
//            List<SportsProduct> spList = new ArrayList<>();
//            List<Ticket> tkList = new ArrayList<>();
//            spList.add(getSportsProduct(dt[3]));
//            tkList.add(getTicket(dt[4]));
            billList.add(new Bill(Long.parseLong(dt[0]), Integer.parseInt(dt[1]), dt[2], dt[3]));
            //System.out.println(dt[0] +"|"+ dt[1] +"|"+ dt[2] +"|"+ dt[3] +"|"+ dt[4] +"|"+ dt[5] +"|"+ dt[6]);
        }
        closeFileAfterRead(fileName);
        return billList;
    }

//    public SportsProduct getSportsProduct(String id) {
//        List<SportsProduct> sportsProductList = ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
//        for (int i = 0; i < sportsProductList.size(); i++) {
//            if(sportsProductList.get(i).getId().compareTo(id) == 0)
//                    return sportsProductList.get(i);
//        }
//        return null;
//    }
//
//    public Ticket getTicket(String id) {
//        List<Ticket> ticketList = ReadTicketFromFile("TICKET.DAT");
//        for (int i = 0; i < ticketList.size(); i++) {
//            if(ticketList.get(i).getId().compareTo(id) == 0)
//                return ticketList.get(i);
//        }
//        return null;
//    }

    public void updateSportsProductInFile(String fileName, List<SportsProduct> spList) {
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        openFileToWrite(fileName);
        for (SportsProduct sportsProduct: spList) {
            printWriter.println(
                    sportsProduct.getId() + "|" + sportsProduct.getName() + "|" + sportsProduct.getProductType()
                            + "|" + sportsProduct.getQuantity() + "|" + sportsProduct.getPrice()
                            + "|" + sportsProduct.getSize() + "|" + sportsProduct.getColor()
            );
        }
        closeFileAfterWrite(fileName);
    }

    public void updateTicketInFile(String fileName, List<Ticket> ticketList) {
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        openFileToWrite(fileName);
        for (Ticket ticket: ticketList) {
            printWriter.println(
                    ticket.getId() + "|" + ticket.getName() + "|" + ticket.getProductType()
                            + "|" + ticket.getQuantity() + "|" + ticket.getPrice()
                            + "|" + ticket.getTicketType()
                    );
        }
        closeFileAfterWrite(fileName);
    }
}
