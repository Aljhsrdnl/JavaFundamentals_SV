public class Pastry {
    String productName;
    long price;
    String type;

    public Pastry(String productName, long price, String type) {
        this.productName = productName;
        this.price = price;
        this.type = type;
    }

    //getter methods
    public String getProductName() {
        return this.productName;
    }
    public long getPrice() {
        return this.price;
    }
    public String getType() {
        return this.type;
    }
}
