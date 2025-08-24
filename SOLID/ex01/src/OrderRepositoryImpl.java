public class OrderRepositoryImpl implements IOrderRepository {
    @Override
    public void saveOrder(String customerEmail, double total) {
        System.out.println("Order saved (pretend DB): " + customerEmail + ", " + total);
    }
}
