import Human.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor1, visitor2, visitor3, visitor4, visitor5, visitor6;

    @Before
    public void setup() {
        visitor1 = new Visitor("Ian Malcolm", 5);
        visitor2 = new Visitor("Alan Grant",6);
        visitor3 = new Visitor("Ellie Sattler", 8);
        visitor4 = new Visitor("John Hammond", 3);
        visitor5 = new Visitor("Lex Murphy",7);
        visitor6 = new Visitor("Tim Murphy",5);
    }


    @Test
    public void visitorHasName() {
        assertEquals("Ian Malcolm", visitor1.getName());
    }

    @Test
    public void visitorCanRun() {
        assertEquals(8, visitor3.getSpeed());
    }
}
