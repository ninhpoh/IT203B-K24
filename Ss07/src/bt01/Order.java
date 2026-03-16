package bt01;

import java.util.*;

public class Order {
    private String orderId;
    private Customer customer;
    private Map<Product, Integer> products;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public Map<Product, Integer> getProducts() { return products; }
    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
}