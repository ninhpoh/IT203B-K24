package bt04;

public class Main {
    public static void main(String[] args) {

        OrderRepository fileRepo = new FileOrderRepository();
        NotificationService emailService = new EmailService();
        OrderService orderService1 = new OrderService(fileRepo, emailService);

        Order order1 = new Order("ORD001", "a@example.com");
        orderService1.createOrder(order1);
        
        OrderRepository dbRepo = new DatabaseOrderRepository();
        NotificationService smsService = new SMSNotification();
        OrderService orderService2 = new OrderService(dbRepo, smsService);

        Order order2 = new Order("ORD002", "0123456789");
        orderService2.createOrder(order2);
    }
}