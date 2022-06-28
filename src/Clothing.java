public abstract class Clothing implements Buyable, Comparable<Clothing> {
    protected double price;

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int compareTo(Clothing c) {
        return (Double.compare(this.price, c.price));
    }

    public abstract String toString();
}