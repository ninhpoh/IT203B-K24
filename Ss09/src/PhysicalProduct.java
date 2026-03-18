public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String id, String name, double price, double weight) {
        super(id, name, price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "PhysicalProduct{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", weight=" + weight +
                '}';
    }
}
