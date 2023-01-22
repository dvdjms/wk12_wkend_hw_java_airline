import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    Pilot pilot;

    @Before
    public void before()  {
        pilot = new Pilot("Thomas", "Captain", 63495);
    }

    @Test
    public void hasName(){
        assertEquals("Thomas", pilot.getName());
    }

    @Test
    public void hasRank(){
        assertEquals("Captain", pilot.getRank());
    }

    @Test
    public void hasPilotLicenseNumber(){
        assertEquals(63495, pilot.getPilotLicenseNumber());
    }

    @Test
    public void canflyPlane(){
        assertEquals("...and we're off!", pilot.flyPlane());
    }
}
