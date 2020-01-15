import java.util.Objects;

public class KnapsackItem implements Comparable<KnapsackItem>{
    private double value;
    private double weight;
    private double ratio;

    // constructor
    public KnapsackItem(double value, double weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }

    // getters and setters
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnapsackItem that = (KnapsackItem) o;
        return value == that.value &&
                weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, weight);
    }

    @Override
    public String toString() {
        return "KnapsackItem{" +
                "value=" + value +
                ", weight=" + weight +
                ", ratio=" + ratio +
                '}';
    }

    @Override
    public int compareTo(KnapsackItem knapsackItem) {
        if (this.getRatio() > knapsackItem.getRatio()) {
            return 1;
        }
        if (this.getRatio() == knapsackItem.getRatio()) {
            return 0;
        }
        // less than other
        return -1;
    }
}
