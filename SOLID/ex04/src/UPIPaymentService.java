public class UPIPaymentService implements PaymentService {
    @Override
    public String pay(Payment p) {
        return "Paid via UPI: " + p.amount;
    }
}
