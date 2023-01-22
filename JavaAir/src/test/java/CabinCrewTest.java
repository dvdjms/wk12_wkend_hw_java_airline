import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewTest {

    CabinCrew cabincrew;

    @Before
    public void before()  {
        cabincrew = new CabinCrew("Janice", "Leader");
    }

    @Test
    public void hasName(){
        assertEquals("Janice", cabincrew.getName());
    }

    @Test
    public void hasRank(){
        assertEquals("Leader", cabincrew.getRank());
    }

    @Test
    public void canRelayMessage(){
        assertEquals("Fasten your seatbelts", cabincrew.relayMessage());
    }

}

