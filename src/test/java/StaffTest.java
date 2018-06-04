import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaffTest {

    Staff staff1, staff2;

    @Before
    public void setup() {
        staff1 = new Staff("Hannah", 7,10, PositionType.BIOENGINEER);
        staff2 = new Staff("Colin", 10, 20, PositionType.ZOOKEEPER);
    }

    @Test
    public void staffHasName() {
        assertEquals("Hannah", staff1.getName());
    }

    @Test
    public void staffHasExperience() {
        assertEquals(7, staff1.getExperince());
    }

    @Test
    public void staffHasFood() {
        assertEquals(20, staff2.getFood());
    }

    @Test
    public void staffHasAJodPosition() {
        assertEquals(PositionType.ZOOKEEPER, staff2.getJobPosition());
    }
}
