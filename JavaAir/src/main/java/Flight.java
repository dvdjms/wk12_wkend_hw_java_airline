import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Flight extends Plane {

    private final ArrayList<Pilot> pilots;
    private final ArrayList<CabinCrew> cabinCrew;
    private final HashMap<Passenger, Integer> passengers;
    private final PlaneType planetype;
    private final String flightNo;
    private final String departureAirport;
    private final String arrivalAirport;
    private final String timeOfDeparture;

    private final Random random;


    public Flight(PlaneType planeType, String flightNo, String departureAirport, String arrivalAirport, String timeOfDeparture) {
        super(planeType.getCapacity(), planeType.getWeight());
        this.planetype = planeType;
        this.pilots = new ArrayList<>();
        this.cabinCrew = new ArrayList<>();
        this.passengers = new HashMap<>();
        this.flightNo = flightNo;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.timeOfDeparture = timeOfDeparture;
        this.random = new Random();
    }

    public int getAvailableSeats() {
        if (planetype.getCapacity() > this.passengerListSize() ) {
            return planetype.getCapacity() - passengers.size();
        }
        return 0;
    }

    public int pilotListSize() {
        return this.pilots.size();
    }

    public int cabinCrewListSize() {
        return this.cabinCrew.size();
    }

    public int passengerListSize() {
        return this.passengers.size();
    }

    public void addPilot(Pilot pilot) {
        this.pilots.add(pilot);
    }

    public void addCabinCrew(CabinCrew cabinCrew) {
        this.cabinCrew.add(cabinCrew);
    }

    public void AddPassengerAndRandomSeatToFlight(Passenger passenger, Flight flight) {

        int randomSeatNumber;
        int tries = 0;
        do {
            randomSeatNumber = random.nextInt(flight.getCapacityFromPlaneType())+ 1;
            tries++;
            if(tries > passengers.size()){
                break;
            }
        } while (this.passengers.containsValue(randomSeatNumber));
        this.passengers.put(passenger, randomSeatNumber);
    }


    public int getPassengerSeatNumberFromFlightDetails(Passenger passenger) {
        return this.passengers.get(passenger);
    }


    public String getPassengerName(Passenger passenger) {
        return passenger.getName();
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public int getCapacityFromPlaneType(){
        return planetype.getCapacity();
    }

    public Boolean getEmptyPassengersArray() {
        return passengers.isEmpty();
    }

    public Boolean passengerSeatsAreNotDuplicated() {
        return this.passengers.size() == new HashSet<>(this.passengers.values()).size();
    }
}
