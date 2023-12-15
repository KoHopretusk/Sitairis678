public class UsedBicycle extends Bicycle {
    private String condition;

    public UsedBicycle(String name, int price, int quantity, String condition) {
        super(name, price, quantity);
        this.condition = condition;
    }

    // Геттеры и сеттеры

    @Override
    public String toString() {
        return "UsedBicycle{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", condition='" + condition + '\'' +
                '}';
    }
}