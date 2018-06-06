import Areas.Paddock;
import Enum.PaddockType;
import Human.Visitor;
import Enum.DinosaurType;
import Dinosaur.Velociraptor;
import ThemePark.Park;
import org.junit.Before;
import org.junit.Test;

import org.mockito.*;

import static org.junit.Assert.assertEquals;

public class VelociraptorTest {

    Velociraptor velociraptor1, velociraptor2;
    Paddock paddock;
    Park park;
    Visitor visitor1, visitor2;

    @Before
    public void setup() {
        park =  new Park();

        velociraptor1 = new Velociraptor(3, 5, DinosaurType.OMNIVORE);
        velociraptor2 = new Velociraptor(6, 5, DinosaurType.OMNIVORE);

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
        Velociraptor spyVelociraptor = Mockito.spy(velociraptor1);
        Mockito.when(spyVelociraptor.getRampage()).thenReturn(7);

        assertEquals(7, spyVelociraptor.getRampage());
    }

    @Test
    public void dinosaurCanHunt(){
        Velociraptor spyVelociraptor = Mockito.spy(velociraptor2);
        Mockito.when(spyVelociraptor.getRampage()).thenReturn(7);

        paddock.addDinosaur(spyVelociraptor);
        park.addVisitor(visitor1);
        spyVelociraptor.getHunt(paddock, park);
        assertEquals(0, paddock.getCount());
        assertEquals(0,park.getVisitorCount());
        assertEquals(7, spyVelociraptor.getStomach());
    }

    @Test
    public void dinosaurCannotHunt() {
        Velociraptor spyVelociraptor = Mockito.spy(velociraptor2);
        Mockito.when(spyVelociraptor.getRampage()).thenReturn(4);

        paddock.addDinosaur(spyVelociraptor);
        park.addVisitor(visitor2);
        spyVelociraptor.getHunt(paddock, park);
        assertEquals(1,paddock.getCount());
        assertEquals(1,park.getVisitorCount());
        assertEquals(6, spyVelociraptor.getStomach());
    }

}
