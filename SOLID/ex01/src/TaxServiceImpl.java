public class TaxServiceImpl implements ITaxService {
    private static final double TAX_RATE = 0.18;

    @Override
    public double calculateTax(double amount) {
        return amount * TAX_RATE;
    }
}
