package bt02;

public class HolidayDiscount implements DiscountStrategy {
    private double percent;

    public HolidayDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - (totalAmount * percent / 100);
    }
}