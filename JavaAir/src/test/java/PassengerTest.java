import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PassengerTest {

    Passenger passenger1;
    Passenger passenger2;
    Flight flight1;
    Flight flight2;


    @Before
    public void before()  {
        passenger1 = new Passenger("Bruce",2);
        passenger2 = new Passenger("Tom",4);
        flight1 = new Flight(PlaneType.SMALLPLANE, "F167", "Edinburgh", "Singapore", "15:55");
        flight2 = new Flight(PlaneType.BIGPLANE, "Z567", "London", "New York", "20:30");
    }

    @Test
    public void hasName(){
        assertEquals("Bruce", passenger1.getName());
    }

    @Test
    public void hasNumberOfBags(){
        assertEquals(2, passenger1.getNumberOfBags());
    }

    @Test
    public void hasEmptyFlightArray(){
        assertEquals(true, passenger1.getEmptyFlightArray());
    }

    @Test
    public void canAddFlightAndSeatNumberToPassengerFlightHash() {
        flight2.AddPassengerAndRandomSeatToFlight(passenger1, flight2);
        passenger1.addFlightAndSeatNumberToPassengerFlightHash(passenger1, flight2);
        assertEquals(false, passenger1.getEmptyFlightArray());
        assertEquals(1, passenger1.getPassengerFlights());
        assertTrue(1 <= passenger1.getPassengerSeatNumber(flight2) && passenger1.getPassengerSeatNumber(flight2) <= flight2.getCapacityFromPlaneType());
    }
}
