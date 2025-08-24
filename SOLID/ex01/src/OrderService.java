public class OrderService {
    double taxRate = 0.18;
    private IEmailClient emailClient;
    private ITaxService taxService;
    private IOrderRepository orderRepository;

    public OrderService(IEmailClient emailClient, ITaxService taxService, IOrderRepository orderRepository) {
        this.emailClient = emailClient;
        this.taxService = taxService;
        this.orderRepository = orderRepository;
    }

    void checkout(String customerEmail, double subtotal) {
        double total = taxService.calculateTax(subtotal);
        emailClient.sendEmail(customerEmail, "Thanks! Your total is " + total);
        orderRepository.saveOrder(customerEmail, total);
    }
}