public class CardPaymentService implements PaymentService {
    @Override
    public String pay(Payment p) {
        return "Charged card: " + p.amount;
    }
}
