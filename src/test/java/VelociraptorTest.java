import Areas.Paddock;
import Areas.PaddockType;
import People.Visitor;
import Species.DinosaurType;
import Species.Velociraptor;
import ThemePark.Park;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VelociraptorTest {

    Velociraptor velociraptor1, velociraptor2;
    Paddock paddock;
    Park park;
    Visitor visitor1, visitor2;

    @Before
    public void setup() {
        park =  new Park();

        velociraptor1 = new Velociraptor(3, 7, DinosaurType.OMNIVORE);
        velociraptor2 = new Velociraptor(6, 4, DinosaurType.OMNIVORE);

        paddock = new Paddock("Velociraptor Paddock", PaddockType.PREDATORS);

        visitor1 = new Visitor("Alan Grant",6);
        visitor2 = new Visitor("Ellie Sattler", 8);
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
        park.addVisitor(visitor1);
        velociraptor1.getHunt(paddock, park);
        assertEquals(0, paddock.getCount());
        assertEquals(0,park.getVisitorCount());
        assertEquals(4, velociraptor1.getStomach());
    }

    @Test
    public void dinosaurCannotHunt() {
        paddock.addDinosaur(velociraptor2);
        park.addVisitor(visitor2);
        velociraptor2.getHunt(paddock, park);
        assertEquals(1,paddock.getCount());
        assertEquals(1,park.getVisitorCount());
        assertEquals(6, velociraptor2.getStomach());
    }



}
