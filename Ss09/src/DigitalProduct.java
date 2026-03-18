public class DigitalProduct extends Product {
    private double size;

    public DigitalProduct(String id, String name, double price, double size) {
        super(id, name, price);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String toString() {
        return "DigitalProduct{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", size=" + size +
                '}';
    }
}
