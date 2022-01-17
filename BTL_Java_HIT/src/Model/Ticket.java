package Model;

public class Ticket extends Product{
    private String ticketType;

    public Ticket() {
    }

    public Ticket(String id, String name, String productType, int quantity, double price, String ticketType) {
        super(id, name, productType, quantity, price);
        this.ticketType = ticketType;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}
