public class Demo01 {
    public static void main(String[] args) {
        IEmailClient emailClient = new EmailClientImpl();
        ITaxService taxService = new TaxServiceImpl();
        IOrderRepository orderRepository = new OrderRepositoryImpl();
        OrderService orderService = new OrderService(emailClient, taxService, orderRepository);
        orderService.checkout("a@shop.com", 100.0);
    }
}