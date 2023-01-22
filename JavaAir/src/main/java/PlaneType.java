public enum PlaneType {

    BIGPLANE(500, 200000),
    MEDIUMPLANE(200, 14500),
    SMALLPLANE(4,1500);

    private final int capacity;
    private final double weight;

    PlaneType(int capacity, double weight) {
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getWeight() {
        return weight;
    }
}
