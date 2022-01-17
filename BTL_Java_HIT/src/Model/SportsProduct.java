package Model;

public class SportsProduct extends Product{
    private String size;
    private String color;

    public SportsProduct() {
    }

    public SportsProduct(String id, String name, String productType, int quantity, double price, String size, String color) {
        super(id, name, productType, quantity, price);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
