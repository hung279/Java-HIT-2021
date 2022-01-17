package Controller;

import Model.Bill;
import Model.SportsProduct;

import java.util.ArrayList;
import java.util.List;

public class BillController {
    List<Bill> billList = new ArrayList<>();

    public void Show() {
        for (Bill bill: billList) {
            System.out.println(bill);
        }
    }
}
