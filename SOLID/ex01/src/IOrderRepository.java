public interface IOrderRepository {
    void saveOrder(String customerEmail, double total);
}
