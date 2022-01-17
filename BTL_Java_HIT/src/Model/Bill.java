package Model;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private long idBill;
    private int customerID;
    private String customerName;
    private String purchaseDate;
    //private List<SportsProduct> purchasedProduct = new ArrayList<>();
    //private List<Ticket> purchasedTicket = new ArrayList<>();
    //private double totalMoney;

    public Bill() {
    }

//    public Bill(long idBill, String customerName, String purchaseDate, List<SportsProduct> purchasedProduct, List<Ticket> purchasedTicket, double totalMoney) {
//        this.idBill = idBill;
//        this.customerName = customerName;
//        this.purchaseDate = purchaseDate;
//        this.purchasedProduct = purchasedProduct;
//        this.purchasedTicket = purchasedTicket;
//        this.totalMoney = totalMoney;
//    }


    public Bill(long idBill, int customerID, String customerName, String purchaseDate) {
        this.idBill = idBill;
        this.customerID = customerID;
        this.customerName = customerName;
        this.purchaseDate = purchaseDate;
    }

    public long getIdBill() {
        return idBill;
    }

    public void setIdBill(long idBill) {
        this.idBill = idBill;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

//    public List<SportsProduct> getPurchasedProduct() {
//        return purchasedProduct;
//    }
//
//    public void setPurchasedProduct(List<SportsProduct> purchasedProduct) {
//        this.purchasedProduct = purchasedProduct;
//    }
//
//    public List<Ticket> getPurchasedTicket() {
//        return purchasedTicket;
//    }
//
//    public void setPurchasedTicket(List<Ticket> purchasedTicket) {
//        this.purchasedTicket = purchasedTicket;
//    }

//    public double getTotalMoney() {
//        return totalMoney;
//    }
//
//    public void setTotalMoney(double totalMoney) {
//        this.totalMoney = totalMoney;
//    }
}
