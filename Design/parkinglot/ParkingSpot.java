//import parkinglot;
import java.util.*;

public class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;

    public ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    public boolean fit(Vehicle v) {
        return currentVehicle == null && (size.getSize() >= v.getSize().getSize()); // ??? how to convert enum to
    }

    public boolean park(Vehicle v) {
        if (currentVehicle == null) {
            currentVehicle = v;
            return true;
        }
        return false;
    }

    public void leave() {
        currentVehicle = null;
    }

    public Vehicle getVehicle() {
        return currentVehicle;
    }
}
