import java.util.ArrayList;

public class FlightManager extends AirlineEmployees {

    private final PlaneType planetype;

    public FlightManager(String name, String rank, PlaneType planetype) {
        super(name, rank);
        this.planetype = planetype;
    }

    public double baggageReserved() {
        return planetype.getWeight() / planetype.getCapacity() / 2;
    }

    public int getPassengerBagsWeight(Passenger passenger) {
        return passenger.getNumberOfBags() * 25;
    }

    public int baggageSpaceBooked(ArrayList<Passenger> passengersList) {
        int result = 0;
        for (int i = 0; i < passengersList.size(); i++) {
            result += passengersList.get(i).getNumberOfBags() * 25;
        }
        return result;
    }

    public double checkRemainingBaggageSpace(ArrayList<Passenger> passengersList) {
        int result = 0;
        for (int i = 0; i < passengersList.size(); i++) {
            result += passengersList.get(i).getNumberOfBags() * 25;
        }
        return  planetype.getWeight() / 2 - result;
    }
}

