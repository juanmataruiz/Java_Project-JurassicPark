import Areas.Paddock;
import Areas.PaddockType;
import People.Visitor;
import Species.Ankylosaurus;
import Species.Dinosaur;
import Species.DinosaurType;
import Species.TyrannosaurusRex;
import ThemePark.Park;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {

    Park park;
    Paddock paddock1, paddock2, paddock3;
    Dinosaur dinosaur1, dinosaur2, dinosaur3;
    Visitor visitor1, visitor2;

    @Before
    public void setup() {
        park = new Park();

        paddock1 = new Paddock("Galliminus Valley", PaddockType.FREE_FROM_PREDATORS);
        paddock2 = new Paddock("Galliminus Valley", PaddockType.FREE_FROM_PREDATORS);
        paddock3 = new Paddock("T-Rex Paddock", PaddockType.PREDATORS);

        dinosaur1 = new Ankylosaurus(4, 2, DinosaurType.HERBIVORE);
        dinosaur2 = new Ankylosaurus(6, 4, DinosaurType.HERBIVORE);
        dinosaur3 = new TyrannosaurusRex(5, 7, DinosaurType.CARNIVORE);

        visitor1 = new Visitor("Alan Grant",6);
        visitor2 = new Visitor("Ellie Sattler", 8);
    }


    @Test
    public void parkStartWithNoPaddock() {
        assertEquals(0, park.getCount());
    }

    @Test
    public void parkCanAddNewPaddock() {
        park.addPaddock(paddock1);
        assertEquals(1, park.getCount());
    }

    @Test
    public void parkCanRemovePaddock() {
        park.addPaddock(paddock2);
        park.addPaddock(paddock1);
        park.removePaddock();
        assertEquals(1, park.getCount());
    }

    @Test
    public void parkCanTransferDinosaurToAnotherPaddock() {
        park.addPaddock(paddock1);
        park.addPaddock(paddock2);
        paddock1.addDinosaur(dinosaur1);
        paddock1.removeDinosaur();
        paddock2.addDinosaur(dinosaur1);
        assertEquals(2, park.getCount());
        assertEquals(0, paddock1.getCount());
        assertEquals(1, paddock2.getCount());
    }

    @Test
    public void canTransferOnlyHerbivoreDinosaur__TRUE() {
        park.addPaddock(paddock1);
        park.addPaddock(paddock2);
        paddock1.addDinosaur(dinosaur1);
        paddock2.addDinosaur(dinosaur2);
        park.transferOnlyHerbivoreDinosaur(dinosaur1, paddock1, paddock2);
        assertEquals(2, park.getCount());
        assertEquals(0, paddock1.getCount());
        assertEquals(2, paddock2.getCount());
    }

    @Test
    public void canTransferOnlyHerbivoreDinosaur__FALSE() {
        park.addPaddock(paddock1);
        park.addPaddock(paddock3);
        paddock1.addDinosaur(dinosaur1);
        paddock3.addDinosaur(dinosaur3);
        park.transferOnlyHerbivoreDinosaur(dinosaur3, paddock3, paddock1);
        assertEquals(2, park.getCount());
        assertEquals(1,paddock1.getCount());
        assertEquals(1,paddock3.getCount());
    }

    @Test
    public void parkStartWithNoVisitors() {
        assertEquals(0, park.getVisitorCount());
    }

    @Test
    public void parkCanAddVisitor() {
        park.addVisitor(visitor1);
        assertEquals(1, park.getVisitorCount());
    }

    @Test
    public void parkCanRemoveVisitor() {
        park.addVisitor(visitor2);
        park.removeVisitor();
        assertEquals(0, park.getVisitorCount());
    }


}
