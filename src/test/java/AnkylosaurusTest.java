import Dinosaur.Ankylosaurus;
import Enum.DinosaurType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnkylosaurusTest {

    Ankylosaurus ankylosaurus;

    @Before
    public void setup() {
        ankylosaurus = new Ankylosaurus(1, 5, DinosaurType.HERBIVORE);
    }

    @Test
    public void dinosaurHasType() {
        assertEquals(DinosaurType.HERBIVORE, ankylosaurus.getType());
    }

    @Test
    public void dinosaurHasStomach() {
        assertEquals(1, ankylosaurus.getStomach());
    }

    @Test
    public void dinosaurCanBeFed() {
        ankylosaurus.dinosaurIsFed();
        assertEquals(2, ankylosaurus.getStomach());
    }
}
