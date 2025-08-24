public class WalletPaymentService implements PaymentService {
    @Override
    public String pay(Payment p) {
        return "Wallet debit: " + p.amount;
    }
}
