public class Beverage {
    String productName;
    long price;
    String size;
    String type;

    public Beverage(String productName, long price, String size, String type) {
        this.productName = productName;
        this.price = price;
        this.size = size;
        this.type = type;
    }

    // getter methods
    public String getProductName() {
        return this.productName;
    }
    public long getPrice() {
        return this.price;
    }
    public String getSize() {
        return this.size;
    }
    public String getType() {
        return this.type;
    }

}
