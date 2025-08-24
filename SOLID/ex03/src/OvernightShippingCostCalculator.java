public class OvernightShippingCostCalculator implements ShippingCostCalculator {
    @Override
    public double cost(Shipment s) {
        return 120 + 10 * s.weightKg;
    }
}
