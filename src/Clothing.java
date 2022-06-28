public abstract class Clothing implements Buyable, Comparable<Clothing> {
    protected double price;

    @Override
    public double getPrice() {
        return price;
    }

    public int compareTo(Clothing c) {
        return (Double.compare(this.price, c.price));
    }

    public abstract String toString();
}