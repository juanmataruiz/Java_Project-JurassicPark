import Areas.Paddock;
import Areas.PaddockType;
import Species.DinosaurType;
import Species.Velociraptor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VelociraptorTest {

    Velociraptor velociraptor;
    Paddock paddock;

    @Before
    public void setup() {
        velociraptor = new Velociraptor(3, 7, DinosaurType.OMNIVORE);
        paddock = new Paddock("Velociraptor Paddock", PaddockType.PREDATORS);
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
    public void dinosaurCanRampage() {
        assertEquals(7, velociraptor.getRampage());
    }

    @Test
    public void dinosaurCanHunt(){
        paddock.addDinosaur(velociraptor);
        velociraptor.getHunt(paddock);
        assertEquals(0, paddock.getCount());
        assertEquals(4, velociraptor.getStomach());
    }

//    @Test
//    public void dinosaurCannotHunt() {
//        paddock.addDinosaur();
//        velociraptor.getRampage();
//        assertEquals(3, velociraptor.getStomach());
//    }



}
