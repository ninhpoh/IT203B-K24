import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }
    public List<Product> getProducts() {
        return products;
    }

     public void displayAllProducts() {
        for (Product product : products) {
            product.displayInfo();
            System.out.println();
        }
    }

    public Product findProductById(String id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeProductById(String id) {
        products.removeIf(product -> product.getId() == id);
    }

    public void updateProduct(Product product) {

    }
}
