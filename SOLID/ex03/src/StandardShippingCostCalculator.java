public class StandardShippingCostCalculator implements ShippingCostCalculator {
    @Override
    public double cost(Shipment s) {
        return 50 + 5 * s.weightKg;
    }
}
