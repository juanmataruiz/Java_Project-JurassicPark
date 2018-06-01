import Areas.PaddockOne;
import Areas.PaddockType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaddockOneTest {

    PaddockOne paddockOne;

    @Before
    public void setup() {
        paddockOne = new PaddockOne("Galliminus Valey", PaddockType.FREE_FROM_PREDATORS);
    }

    @Test
    public void paddockHasName() {
        assertEquals("Galliminus Valey", paddockOne.getName());
    }

    @Test
    public void paddockHasType() {
        assertEquals(PaddockType.FREE_FROM_PREDATORS, paddockOne.getType());
    }
}
