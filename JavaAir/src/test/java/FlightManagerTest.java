import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    FlightManager flightManager;
    Passenger passenger1;
    Passenger passenger2;


    @Before
    public void before() {
        flightManager = new FlightManager("Maxine", "Flight Manager", PlaneType.SMALLPLANE);
        passenger1 = new Passenger("Philip", 4);
        passenger2 = new Passenger("Leslie", 2);
    }

    @Test
    public void canCalculateBaggageReservedPerPassenger() {
        assertEquals(187.5, flightManager.baggageReserved(),0.001);
    }

    @Test
    public void canGetSinglePassengerBagsWeight() {
        assertEquals(100, flightManager.getPassengerBagsWeight(passenger1));
    }

    @Test
    public void canCheckHowMuchBaggageSpaceHasBeenBooked() {
        ArrayList<Passenger> passengerList = new ArrayList<>();
        passengerList.add(passenger1);
        passengerList.add(passenger2);
        assertEquals(150, flightManager.baggageSpaceBooked(passengerList));
    }

    @Test
    public void canCheckRemainingBaggageSpace() {
        ArrayList<Passenger> passengerList = new ArrayList<>();
        passengerList.add(passenger1);
        passengerList.add(passenger2);
        assertEquals(600, flightManager.checkRemainingBaggageSpace(passengerList), 0.001);
    }
}

