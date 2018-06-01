import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {

    Park park;

    @Before
    public void setup() {
        park = new Park(20);
    }

    @Test
    public void parkHasFood() {
        assertEquals(20, park.getFood());
    }

    @Test
    public void parkCanAddFood() {
        park.addFood();
        park.addFood();
        assertEquals(22, park.getFood());
    }

}
