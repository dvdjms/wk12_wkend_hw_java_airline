import java.util.HashMap;

public class Passenger {

    private final String name;
    private final int NumberOfBags;
    private final HashMap<Flight, Integer> flights;


    public Passenger(String name, int NumberOfBags){
        this.name = name;
        this.NumberOfBags = NumberOfBags;
        this.flights = new HashMap<>();
    }

    public int getPassengerFlights() {
        return this.flights.size();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBags() {
        return NumberOfBags;
    }

    public Boolean getEmptyFlightArray() {
        return flights.isEmpty();
    }

    public void addFlightAndSeatNumberToPassengerFlightHash(Passenger passenger, Flight flights) {
        int seatNumber = flights.getPassengerSeatNumberFromFlightDetails(passenger);
        this.flights.put(flights, seatNumber);
    }

    public int getPassengerSeatNumber(Flight flights) {
        return this.flights.get(flights);
    }

}
