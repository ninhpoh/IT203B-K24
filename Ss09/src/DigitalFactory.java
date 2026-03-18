public abstract class DigitalFactory extends ProductFactory {
    @Override
    public Product createDigital(String id, String name, double price, double size) {
        System.out.println("DigitalFactory: Đã tạo sản phẩm kỹ thuật số mới.");
        return new DigitalProduct(id,name,price,size);
    }
}

