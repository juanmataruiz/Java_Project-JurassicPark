import Areas.Paddock;
import Areas.PaddockType;
import Species.DinosaurType;
import Species.Velociraptor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VelociraptorTest {

    Velociraptor velociraptor1, velociraptor2;
    Paddock paddock;

    @Before
    public void setup() {
        velociraptor1 = new Velociraptor(3, 7, DinosaurType.OMNIVORE);
        velociraptor2 = new Velociraptor(6, 4, DinosaurType.OMNIVORE);
        paddock = new Paddock("Velociraptor Paddock", PaddockType.PREDATORS);
    }

    @Test
    public void dinosaurHasType() {
        assertEquals(DinosaurType.OMNIVORE, velociraptor1.getType());
    }

    @Test
    public void dinosaurHasStomach() {
        assertEquals(3, velociraptor1.getStomach());
    }

    @Test
    public void dinosaurCanBeFed() {
        velociraptor1.dinosaurIsFed();
        assertEquals(4, velociraptor1.getStomach());
    }

    @Test
    public void dinosaurCanRampage() {
        assertEquals(7, velociraptor1.getRampage());
    }

    @Test
    public void dinosaurCanHunt(){
        paddock.addDinosaur(velociraptor1);
        velociraptor1.getHunt(paddock);
        assertEquals(0, paddock.getCount());
        assertEquals(4, velociraptor1.getStomach());
    }

    @Test
    public void dinosaurCannotHunt() {
        paddock.addDinosaur(velociraptor2);
        velociraptor2.getHunt(paddock);
        assertEquals(1,paddock.getCount());
        assertEquals(6, velociraptor2.getStomach());
    }



}
