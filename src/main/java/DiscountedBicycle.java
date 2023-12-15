public class DiscountedBicycle extends Bicycle {
    private int discount;

    public DiscountedBicycle(String name, int price, int quantity, int discount) {
        super(name, price, quantity);
        this.discount = discount;
    }

    public int getDiscount(){
        return discount;
    }

    @Override
    public String toString() {
        return "DiscountedBicycle{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", discount=" + discount +
                '}';
    }
}