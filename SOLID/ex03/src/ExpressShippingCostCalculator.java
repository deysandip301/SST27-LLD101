public class ExpressShippingCostCalculator implements ShippingCostCalculator {
    @Override
    public double cost(Shipment s) {
        return 80 + 8 * s.weightKg;
    }
}
