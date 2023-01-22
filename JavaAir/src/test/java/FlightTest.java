import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightTest {

    Flight flight1;
    Flight flight2;
    Pilot pilot1;
    Pilot pilot2;
    CabinCrew cabinCrew1;
    CabinCrew cabinCrew2;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;

    @Before
    public void before(){
        flight1 = new Flight(PlaneType.SMALLPLANE, "F167", "Edinburgh", "Singapore", "15:55");
        flight2 = new Flight(PlaneType.MEDIUMPLANE, "K3456", "Birmingham", "Edinburgh", "09:20");
        pilot1 = new Pilot("Jemimah", "Captain", 65784);
        pilot2 = new Pilot("Joe", "Co-Pilot", 98684);
        cabinCrew1 = new CabinCrew("Mary", "First Officer");
        cabinCrew2 = new CabinCrew("John", "Flight Attendant");
        passenger1 = new Passenger("Philip", 4);
        passenger2 = new Passenger("Leslie", 2);
        passenger3 = new Passenger("Martin", 3);
        passenger4 = new Passenger("Treasa", 2);
        passenger5 = new Passenger("Fiona", 3);
    }

    @Test
    public void hasFlightNo() {
        assertEquals("F167", flight1.getFlightNo());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals("Edinburgh", flight1.getDepartureAirport());
    }

    @Test
    public void hasArrivalAirport() {
        assertEquals("Singapore", flight1.getArrivalAirport());
    }

    @Test
    public void hasTimeOfDeparture() {
        assertEquals("15:55", flight1.getTimeOfDeparture());
    }

    @Test
    public void hasAvailableSeats() {
        flight1.AddPassengerAndRandomSeatToFlight(passenger1, flight1);
        flight1.AddPassengerAndRandomSeatToFlight(passenger2, flight1);
        assertEquals(2, flight1.getAvailableSeats());
    }

    @Test
    public void hasNotGotAvailableSeats() {
        flight1.AddPassengerAndRandomSeatToFlight(passenger1, flight1);
        flight1.AddPassengerAndRandomSeatToFlight(passenger2, flight1);
        flight1.AddPassengerAndRandomSeatToFlight(passenger3, flight1);
        flight1.AddPassengerAndRandomSeatToFlight(passenger4, flight1);
        flight1.AddPassengerAndRandomSeatToFlight(passenger5, flight1);
        assertEquals(0, flight1.getAvailableSeats());
    }

    @Test
    public void getPassengerListSize() {
        assertEquals(0, flight1.passengerListSize());
    }

    @Test
    public void getPilotListSize() {
        assertEquals(0, flight1.pilotListSize());
    }

    @Test
    public void getCabinCrewListSize() {
        assertEquals(0, flight1.cabinCrewListSize());
    }

    @Test
    public void canGetCapacityFromPlaneType() {
        assertEquals(4, flight1.getCapacityFromPlaneType());
    }

    @Test
    public void canAddAPilot() {
        flight1.addPilot(pilot2);
        assertEquals(1, flight1.pilotListSize());
    }

    @Test
    public void canAddCabinCrew() {
        flight1.addCabinCrew(cabinCrew1);
        flight1.addCabinCrew(cabinCrew2);
        assertEquals(2, flight1.cabinCrewListSize());
    }


    @Test
    public void canAddPassengerAndRandomSeatToFlight() {
        flight2.AddPassengerAndRandomSeatToFlight(passenger1, flight2);
        flight2.AddPassengerAndRandomSeatToFlight(passenger2, flight2);
        assertEquals(2, flight2.passengerListSize());
        assertEquals(false, flight2.getEmptyPassengersArray());
        assertEquals(false, flight2.getEmptyPassengersArray());
        assertTrue(1 <= flight2.getPassengerSeatNumberFromFlightDetails(passenger1) && flight2.getPassengerSeatNumberFromFlightDetails(passenger1) <= flight2.getCapacityFromPlaneType() );
        assertTrue(1 <= flight2.getPassengerSeatNumberFromFlightDetails(passenger2) && flight2.getPassengerSeatNumberFromFlightDetails(passenger2) <= flight2.getCapacityFromPlaneType() );
    }

    @Test
    public void canGetPassengerName() {
        assertEquals("Leslie", flight1.getPassengerName(passenger2));
    }

    @Test
    public void canGetPassengerSeatNumberFromFlightDetails() {
        flight1.AddPassengerAndRandomSeatToFlight(passenger1, flight1);
        assertTrue(1 <= flight1.getPassengerSeatNumberFromFlightDetails(passenger1) && flight1.getPassengerSeatNumberFromFlightDetails(passenger1) <= flight1.getCapacityFromPlaneType());
    }

//    @Test
//    public void checkPassengerSeatsAreNotDuplicated() {
//        flight1.AddPassengerAndRandomSeatToFlight(passenger1, flight1);
//        flight1.AddPassengerAndRandomSeatToFlight(passenger2, flight1);
//        flight1.AddPassengerAndRandomSeatToFlight(passenger3, flight1);
//        flight1.AddPassengerAndRandomSeatToFlight(passenger4, flight1);
//        System.out.println(flight1.getPassengerSeatNumberFromFlightDetails(passenger1));
//        System.out.println(flight1.getPassengerSeatNumberFromFlightDetails(passenger2));
//        System.out.println(flight1.getPassengerSeatNumberFromFlightDetails(passenger3));
//        System.out.println(flight1.getPassengerSeatNumberFromFlightDetails(passenger4));
//        assertEquals(true, flight1.passengerSeatsAreNotDuplicated());
//    }

}

