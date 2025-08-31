import com.example.orders.*;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
    Order o = new Order.Builder("o2", "a@b.com").addLine(l1).addLine(l2).discountPercent(10).build();
    System.out.println("Before: " + o.totalAfterDiscount());
    OrderLine changed = new OrderLine(l1.getSku(), 999, l1.getUnitPriceCents());
    System.out.println("Changed line quantity: " + changed.getQuantity());
    System.out.println("After:  " + o.totalAfterDiscount());
    }
}
