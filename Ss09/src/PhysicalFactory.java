public abstract class PhysicalFactory extends ProductFactory {
    @Override
    public Product createPhysical(String id, String name, double price, double weight) {
        System.out.println("PhysicalFactory: Đã tạo sản phẩm vật lý mới.");
        return new PhysicalProduct(id, name, price, weight);
    }
}
