package beverages_decorator;

public class ChocolateDecorator extends Beverage {

    private final Beverage beverage;

    public ChocolateDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public int cost() {
        return this.beverage.cost() + 100;
    }
    
}
