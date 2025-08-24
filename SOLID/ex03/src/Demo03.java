public class Demo03 {
    public static void main(String[] args) {

        ShippingCostCalculator standard = new StandardShippingCostCalculator();
        System.out.println(standard.cost(new Shipment("STANDARD", 2.0)));

        ShippingCostCalculator express = new ExpressShippingCostCalculator();
        System.out.println(express.cost(new Shipment("EXPRESS", 2.0)));

        ShippingCostCalculator overnight = new OvernightShippingCostCalculator();
        System.out.println(overnight.cost(new Shipment("OVERNIGHT", 2.0)));
    }
}
