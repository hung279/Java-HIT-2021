package Controller;

import Model.Product;
import Model.SportsProduct;
import Model.Ticket;

import java.util.*;

public class ProductController {
    Scanner sc = new Scanner(System.in);
    List<SportsProduct> sportsProductList = new ArrayList<>();
    List<Ticket> ticketList = new ArrayList<>();
    FileController fileController = new FileController();
    public void AddProduct() {
        int choose;
        do {
            System.out.println("Thêm sản phẩm");
            System.out.println("1. Thêm hàng thể thao");
            System.out.println("2. Thêm vé xem trận đấu");
            System.out.println("3. Thoát");
            System.out.print("Chon: ");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    AddSportsProduct();
                    break;
                case 2:
                    AddTicket();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public void AddSportsProduct() {
        SportsProduct sportsProduct = new SportsProduct();
        String id;
        sc.nextLine();
        do {
            System.out.print("Nhập id: ");
            id = sc.nextLine();
            if(CheckSportsProductID(id)) {
                System.out.println("Id sản phẩm đã tồn tại. Vui lòng nhập lại!!");
            } else {
                sportsProduct.setId(id);
            }
        } while (CheckSportsProductID(id));
        System.out.print("Nhập tên hàng thể thao: ");
        sportsProduct.setName(sc.nextLine());
        System.out.print("Nhap lọai hàng thể thao: ");
        sportsProduct.setProductType(sc.nextLine());
        System.out.print("Nhập size hàng the thao: ");
        sportsProduct.setSize(sc.nextLine());
        System.out.print("Nhập màu hàng thể thao: ");
        sportsProduct.setColor(sc.nextLine());
        System.out.print("Nhập số lượng: ");
        sportsProduct.setQuantity(sc.nextInt());
        System.out.print("Nhap giá bán: ");
        sportsProduct.setPrice(sc.nextDouble());
        sportsProductList.add(sportsProduct);
        fileController.writeSportsProductToFile("SPORTSPRODUCT.DAT", sportsProduct);
    }

    public void AddTicket() {
        Ticket ticket = new Ticket();
        String id;
        sc.nextLine();
        do {
            System.out.print("Nhập id vé: ");
            id = sc.nextLine();
            if(CheckTicketID(id)) {
                System.out.println("Id vé đã tồn tại. Vui lòng nhập lại!!");
            } else {
                ticket.setId(id);
            }
        } while (CheckTicketID(id));
        System.out.print("Nhập tên vé: ");
        ticket.setName(sc.nextLine());
        System.out.print("Nhập loại sản phẩm: ");
        ticket.setProductType(sc.nextLine());
        System.out.print("Nhập loại ve: ");
        ticket.setTicketType(sc.nextLine());
        System.out.print("Nhập số lượng vé: ");
        ticket.setQuantity(sc.nextInt());
        System.out.print("Nhập giá vé: ");
        ticket.setPrice(sc.nextDouble());
        ticketList.add(ticket);
        fileController.writeTicketToFile("TICKET.DAT", ticket);
    }

    public void ShowSportsProduct() {
        sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
        System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s | %-10s\n",
                "ID", "Tên sản phẩm", "Loại sản phẩm", "Size", "Màu", "Số lượng", "Đơn giá");
        for (SportsProduct sp: sportsProductList) {
            System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s | %-10s\n",
                    sp.getId(), sp.getName(), sp.getProductType(), sp.getSize(), sp.getColor(), sp.getQuantity(), sp.getPrice());
        }
    }

    public void ShowTicket() {
        ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
        System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s\n",
                "ID", "Tên vé", "Loại sản phẩm", "Loại vé", "Số lượng", "Đơn giá");
        for (Ticket tk: ticketList) {
            System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s\n",
                    tk.getId(), tk.getName(), tk.getProductType(), tk.getTicketType(), tk.getQuantity(), tk.getPrice());
        }
    }

    public boolean CheckSportsProductID(String id) {
        sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
        for (SportsProduct sp : sportsProductList) {
            if (sp.getId().compareTo(id) == 0) return true;
        }
        return false;
    }

    public boolean CheckTicketID(String id) {
        ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
        for (Ticket tk: ticketList) {
            if (tk.getId().compareTo(id) == 0) return true;
        }
        return false;
    }

    public boolean CheckQuantitySP(String id, int quantity) {
        sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
        for (SportsProduct sp: sportsProductList) {
            if(sp.getId().equals(id) && sp.getQuantity() >= quantity) {
                return true;
            }
        }
        return false;
    }
    public boolean CheckQuantityTK(String id, int quantity) {
        ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
        for (Ticket tk: ticketList) {
            if(tk.getId().equals(id) && tk.getQuantity() >= quantity) {
                return true;
            }
        }
        return false;
    }

    public void ReduceQuantitySP(String id, int quantity, SportsProduct sp) {
        sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
        sp.setQuantity(sp.getQuantity()-quantity);
        for (int i = 0; i < sportsProductList.size(); i++) {
            if(sportsProductList.get(i).getId().equals(id)) {
                sportsProductList.set(i, sp);
                break;
            }
        }
        fileController.updateSportsProductInFile("SPORTSPRODUCT.DAT", sportsProductList);
    }

    public void ReduceQuantityTK(String id, int quantity, Ticket tk) {
        ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
        tk.setQuantity(tk.getQuantity()-quantity);
        for (int i = 0; i < ticketList.size(); i++) {
            if(ticketList.get(i).getId().equals(id)) {
                ticketList.set(i,tk);
                break;
            }
        }
        fileController.updateTicketInFile("TICKET.DAT", ticketList);
    }

    public void fixProduct() {
        int choose;
        do {
            System.out.println("Sửa sản phẩm");
            System.out.println("1. Sản phẩm thể thao");
            System.out.println("2. Vé");
            System.out.println("3. Thoat");
            System.out.print("Chọn: ");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    fixSportsProduct();
                    break;
                case 2:
                    fixTicket();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public void fixSportsProduct() {
        sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
        sc.nextLine();
        String id;
        do {
            System.out.print("Nhập id sản phẩm muốn sửa: ");
            id = sc.nextLine();
            if (!CheckSportsProductID(id)) {
                System.out.println("ID sản phẩm không tồn tại. Vui lòng nhập lại!");
            }
        } while (!CheckSportsProductID(id));
        SportsProduct sp = new SportsProduct();
        for (int i = 0; i < sportsProductList.size(); i++) {
            if (sportsProductList.get(i).getId().compareTo(id) == 0) {
                sp = sportsProductList.get(i);
            }
        }
        int choose;
        do {
            System.out.println("Sửa sản phẩm: ");
            System.out.println("1. Sửa số lượng sản phẩm");
            System.out.println("2. Sửa giá sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("Nhập số lượng sản phẩm mới: ");
                    for (int i = 0; i < sportsProductList.size(); i++) {
                        if (sportsProductList.get(i).getId().compareTo(id) == 0) {
                            sportsProductList.get(i).setQuantity(sc.nextInt());
                            break;
                        }
                    }
                    fileController.updateSportsProductInFile("SPORTSPRODUCT.DAT", sportsProductList);
                    sc.nextLine();
                    break;
                case 2:
                    System.out.print("Nhập giá sản phẩm mới: ");
                    for (int i = 0; i < sportsProductList.size(); i++) {
                        if (sportsProductList.get(i).getId().compareTo(id) == 0) {
                            sportsProductList.get(i).setPrice(sc.nextDouble());
                            break;
                        }
                    }
                    fileController.updateSportsProductInFile("SPORTSPRODUCT.DAT", sportsProductList);
                    sc.nextLine();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public void fixTicket() {
        ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
        sc.nextLine();
        String id;
        do {
            System.out.print("Nhập id vé muốn sửa: ");
            id = sc.nextLine();
            if (!CheckTicketID(id)) {
                System.out.println("ID sản phẩm không tồn tại. Vui lòng nhập lại!");
            }
        } while (!CheckTicketID(id));
        Ticket ticket = new Ticket();
        for (int i = 0; i < ticketList.size(); i++) {
            if (ticketList.get(i).getId().compareTo(id) == 0) {
                ticket = ticketList.get(i);
            }
        }
        int choose;
        do {
            System.out.println("Sửa vé: ");
            System.out.println("1. Sửa số lượng vé");
            System.out.println("2. Sửa giá vé");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("Nhập số lượng vé mới: ");
                    for (int i = 0; i < ticketList.size(); i++) {
                        if (ticketList.get(i).getId().compareTo(id) == 0) {
                            ticketList.get(i).setQuantity(sc.nextInt());
                            break;
                        }
                    }
                    fileController.updateTicketInFile("TICKET.DAT", ticketList);
                    sc.nextLine();
                    break;
                case 2:
                    System.out.print("Nhập giá sản phẩm mới: ");
                    for (int i = 0; i < ticketList.size(); i++) {
                        if (ticketList.get(i).getId().compareTo(id) == 0) {
                            ticketList.get(i).setPrice(sc.nextDouble());
                            break;
                        }
                    }
                    fileController.updateTicketInFile("TICKET.DAT", ticketList);
                    sc.nextLine();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public void removeProduct() {
        int choose;
        do {
            System.out.println("Xóa sản phẩm");
            System.out.println("1. Sản phẩm thể thao");
            System.out.println("2. Vé");
            System.out.println("3. Thoat");
            System.out.print("Chọn: ");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    removeSportsProduct();
                    break;
                case 2:
                    removeTicket();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public void removeSportsProduct() {
        sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
        sc.nextLine();
        String id;
        do {
            System.out.print("Nhập id sản phẩm muốn xóa: ");
            id = sc.nextLine();
            if (!CheckSportsProductID(id)) {
                System.out.println("ID sản phẩm không tồn tại. Vui lòng nhập lại!");
            }
        } while (!CheckSportsProductID(id));
        SportsProduct sp = new SportsProduct();
        for (int i = 0; i < sportsProductList.size(); i++) {
            if (sportsProductList.get(i).getId().compareTo(id) == 0) {
                sportsProductList.remove(i);
            }
        }
        fileController.updateSportsProductInFile("SPORTSPRODUCT.DAT", sportsProductList);
    }

    public void removeTicket() {
        ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
        sc.nextLine();
        String id;
        do {
            System.out.print("Nhập id vé muốn sửa: ");
            id = sc.nextLine();
            if (!CheckTicketID(id)) {
                System.out.println("ID sản phẩm không tồn tại. Vui lòng nhập lại!");
            }
        } while (!CheckTicketID(id));
        Ticket ticket = new Ticket();
        for (int i = 0; i < ticketList.size(); i++) {
            if (ticketList.get(i).getId().compareTo(id) == 0) {
                ticketList.remove(i);
            }
        }
        fileController.updateTicketInFile("TICKET.DAT", ticketList);
    }

    public void sortProduct() {
        int choose;
        do {
            System.out.println("Sắp xếp sản phẩm");
            System.out.println("1. Hàng thể thao");
            System.out.println("2. Vé trận đấu");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    sortSportsProduct();
                    break;
                case 2:

                    sortTicket();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public void sortSportsProduct() {
        int choose;
        do {
            System.out.println("Sắp xếp hàng thể thao");
            System.out.println("1. Theo tên");
            System.out.println("2. Theo số lượng");
            System.out.println("3. Theo giá");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    SortSportsProductByName();
                    break;
                case 2:
                    SortSportsProductByQuantity();
                    break;
                case 3:
                    SortSportsProductByPrice();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public void sortTicket() {
        int choose;
        do {
            System.out.println("Sắp xếp vé");
            System.out.println("1. Theo tên");
            System.out.println("2. Theo số lượng");
            System.out.println("3. Theo giá");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    SortTicketByName();
                    break;
                case 2:
                    SortTicketByQuantity();
                    break;
                case 3:
                    SortTicketByPrice();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public void showSortSportsProduct(List<SportsProduct> sportsProductList) {
        System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s | %-10s\n",
                "ID", "Tên sản phẩm", "Loại sản phẩm", "Size", "Màu", "Số lượng", "Đơn giá");
        for (SportsProduct sp: sportsProductList) {
            System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s | %-10s\n",
                    sp.getId(), sp.getName(), sp.getProductType(), sp.getSize(), sp.getColor(), sp.getQuantity(), sp.getPrice());
        }
    }

    public void showSortTicket(List<Ticket> ticketList) {
        System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s\n",
                "ID", "Tên vé", "Loại sản phẩm", "Loại vé", "Số lượng", "Đơn giá");
        for (Ticket tk: ticketList) {
            System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s\n",
                    tk.getId(), tk.getName(), tk.getProductType(), tk.getTicketType(), tk.getQuantity(), tk.getPrice());
        }
    }

    public void SortSportsProductByName() {
        sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
        Collections.sort(sportsProductList, new Comparator<SportsProduct>() {
            @Override
            public int compare(SportsProduct o1, SportsProduct o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        showSortSportsProduct(sportsProductList);
    }

    public void SortTicketByName() {
        ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
        Collections.sort(ticketList, new Comparator<Ticket>() {
            @Override
            public int compare(Ticket o1, Ticket o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        showSortTicket(ticketList);
    }


    public void SortSportsProductByQuantity() {
        sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
        Collections.sort(sportsProductList, new Comparator<SportsProduct>() {
            @Override
            public int compare(SportsProduct o1, SportsProduct o2) {
                return o1.getQuantity() - o2.getQuantity();
            }
        });
        showSortSportsProduct(sportsProductList);
    }

    public void SortTicketByQuantity() {
        ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
        Collections.sort(ticketList, new Comparator<Ticket>() {
            @Override
            public int compare(Ticket o1, Ticket o2) {
                return o1.getQuantity() - o2.getQuantity();
            }
        });
        showSortTicket(ticketList);
    }

    public void SortSportsProductByPrice() {
        sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
        Collections.sort(sportsProductList, new Comparator<SportsProduct>() {
            @Override
            public int compare(SportsProduct o1, SportsProduct o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        showSortSportsProduct(sportsProductList);
    }

    public void SortTicketByPrice() {
        ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
        Collections.sort(ticketList, new Comparator<Ticket>() {
            @Override
            public int compare(Ticket o1, Ticket o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        showSortTicket(ticketList);
    }

    public void findProduct() {
        int choose;
        do {
            System.out.println("Tìm kiếm sản phẩm");
            System.out.println("1. Sản phẩm thể thao");
            System.out.println("2. Vé");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    findSportsProduct();
                    break;
                case 2:
                    findTicket();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public void findTicket() {
        int choose;
        do {
            System.out.println("Tìm kiếm vé");
            System.out.println("1. Theo tên");
            System.out.println("2. Theo loại vé");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    findTicketByName();
                    break;
                case 2:
                    findTicketByTicketType();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public void findSportsProduct() {
        int choose;
        do {
            System.out.println("Tìm kiếm sản phẩm");
            System.out.println("1. Theo tên");
            System.out.println("2. Theo loại sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    findSportsProductByName();
                    break;
                case 2:
                    findSportsProductByProductType();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public void findSportsProductByName() {
        sc.nextLine();
        sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String name = sc.nextLine();
        System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s | %-10s\n",
                "ID", "Tên sản phẩm", "Loại sản phẩm", "Size", "Màu", "Số lượng", "Đơn giá");
        for (SportsProduct sp: sportsProductList) {
            if(sp.getName().compareTo(name) == 0)
                System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s | %-10s\n",
                    sp.getId(), sp.getName(), sp.getProductType(), sp.getSize(), sp.getColor(), sp.getQuantity(), sp.getPrice());
        }
    }

    public void findSportsProductByProductType() {
        sc.nextLine();
        sportsProductList = fileController.ReadSportsProductFromFile("SPORTSPRODUCT.DAT");
        System.out.println("Nhập loại sản phẩm cần tìm: ");
        String productType = sc.nextLine();
        System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s | %-10s\n",
                "ID", "Tên sản phẩm", "Loại sản phẩm", "Size", "Màu", "Số lượng", "Đơn giá");
        for (SportsProduct sp: sportsProductList) {
            if(sp.getProductType().compareTo(productType) == 0)
                System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s | %-10s\n",
                        sp.getId(), sp.getName(), sp.getProductType(), sp.getSize(), sp.getColor(), sp.getQuantity(), sp.getPrice());
        }
    }

    public void findTicketByName() {
        sc.nextLine();
        ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
        System.out.println("Nhập tên vé cần tìm: ");
        String name = sc.nextLine();
        System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s\n",
                "ID", "Tên vé", "Loại sản phẩm", "Loại vé", "Số lượng", "Đơn giá");
        for (Ticket tk: ticketList) {
            if(tk.getName().compareTo(name) == 0)
                System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s\n",
                    tk.getId(), tk.getName(), tk.getProductType(), tk.getTicketType(), tk.getQuantity(), tk.getPrice());
        }
    }

    public void findTicketByTicketType() {
        sc.nextLine();
        ticketList = fileController.ReadTicketFromFile("TICKET.DAT");
        System.out.println("Nhập loại vé cần tìm: ");
        String ticketType = sc.nextLine();
        System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s\n",
                "ID", "Tên vé", "Loại sản phẩm", "Loại vé", "Số lượng", "Đơn giá");
        for (Ticket tk: ticketList) {
            if(tk.getTicketType().compareTo(ticketType) == 0)
                System.out.printf("%-10s | %-25s | %-15s | %-10s | %-10s | %-10s\n",
                        tk.getId(), tk.getName(), tk.getProductType(), tk.getTicketType(), tk.getQuantity(), tk.getPrice());
        }
    }

}
