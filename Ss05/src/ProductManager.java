import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public Optional<Product> findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public void addProduct(Product product) {
        if(findById(product.getId()).isPresent()){
            throw new IllegalArgumentException("ID đã tồn tại !!");
        }
        products.add(product);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào.");
            return;
        }
        products.forEach(System.out::println);
    }

    public void updateQuantity(int id, int quantity) throws InvalidProductException {
        Product product = findById(id)
                .orElseThrow(() -> new InvalidProductException("Không tìm thấy sản phẩm"));

        product.setQuantity(quantity);
    }

    public void deleteOutOfStock() {
        products.removeIf(p -> p.getQuantity() == 0);
    }
}
