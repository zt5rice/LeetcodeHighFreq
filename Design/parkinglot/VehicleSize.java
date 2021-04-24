public enum VehicleSize { // !!! , SEPARATION!!!
    Compact(1),
    Large(2);

    private final int size; // !!! begin

    VehicleSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }                       // !!! end
}