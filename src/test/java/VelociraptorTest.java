import Species.DinosaurType;
import Species.Velociraptor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VelociraptorTest {

    Velociraptor velociraptor;

    @Before
    public void setup() {
        velociraptor = new Velociraptor(3, DinosaurType.OMNIVORE);
    }

    @Test
    public void dinosaurHasType() {
        assertEquals(DinosaurType.OMNIVORE, velociraptor.getType());
    }

    @Test
    public void dinosaurHasStomach() {
        assertEquals(3, velociraptor.getStomach());
    }

    @Test
    public void dinosaurCanBeFed() {
        velociraptor.dinosaurIsFed();
        assertEquals(4, velociraptor.getStomach());
    }

    @Test
    public void canMockRampage_True() {
        velociraptor.isMockRampaging_True();
        assertEquals(4, velociraptor.getStomach());
    }

    @Test
    public void canMockRampage_False() {
       velociraptor.isMockRampaging_False();
       assertEquals(3, velociraptor.getStomach());
    }

}
