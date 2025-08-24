
public class Demo04 {
    public static void main(String[] args) {
        PaymentService card = new CardPaymentService();
        System.out.println(card.pay(new Payment("CARD", 599)));

        PaymentService upi = new UPIPaymentService();
        System.out.println(upi.pay(new Payment("UPI", 499)));

        PaymentService wallet = new WalletPaymentService();
        System.out.println(wallet.pay(new Payment("WALLET", 299)));
    }
}
