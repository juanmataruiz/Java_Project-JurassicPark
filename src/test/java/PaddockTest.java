import Areas.Paddock;
import Areas.PaddockType;
import Species.Dinosaur;
import Species.DinosaurType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PaddockTest {

    Paddock paddock;
    private ArrayList<Dinosaur> dinosaurs;
    Dinosaur ankylosaurus, brachiosaurus;

    @Before
    public void setup() {
        paddock = new Paddock("Galliminus Valey", PaddockType.FREE_FROM_PREDATORS);
        this.dinosaurs = new ArrayList<Dinosaur>();
        Dinosaur ankylosaurus = new Dinosaur(5, DinosaurType.HERBIVORE) {};
        Dinosaur brachiosaurus = new Dinosaur(7, DinosaurType.HERBIVORE) {};
    }

    @Test
    public void paddockHasName() {
        assertEquals("Galliminus Valey", paddock.getName());
    }

    @Test
    public void paddockHasType() {
        assertEquals(PaddockType.FREE_FROM_PREDATORS, paddock.getType());
    }

    @Test
    public void paddockStartEmpty() {
        assertEquals(0, paddock.getCount());
    }

    @Test
    public void paddockCanAddDinosaur() {
        paddock.addDinosaur(ankylosaurus);
        assertEquals(1, paddock.getCount());
    }

    @Test
    public void paddockCanRemoveDinosaur() {
        paddock.addDinosaur(ankylosaurus);
        paddock.addDinosaur(brachiosaurus);
        paddock.removeDinosaur();
        assertEquals(1, paddock.getCount());
    }

}
