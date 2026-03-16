package bt04;

import java.util.*;

public class FileOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
        System.out.println("Lưu đơn hàng vào file: " + order.getOrderId());
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
}