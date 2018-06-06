import Areas.Paddock;
import Enum.PaddockType;
import Human.Visitor;
import Dinosaur.Ankylosaurus;
import Dinosaur.Specie;
import Enum.DinosaurType;
import Dinosaur.TyrannosaurusRex;
import ThemePark.Park;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {

    Park park;
    Paddock paddock1, paddock2, paddock3;
    Specie specie1, specie2, specie3;
    Visitor visitor1, visitor2;

    @Before
    public void setup() {
        park = new Park();

        paddock1 = new Paddock("Galliminus Valley", PaddockType.FREE_FROM_PREDATORS);
        paddock2 = new Paddock("Galliminus Valley", PaddockType.FREE_FROM_PREDATORS);
        paddock3 = new Paddock("T-Rex Paddock", PaddockType.PREDATORS);

        specie1 = new Ankylosaurus(4, 2, DinosaurType.HERBIVORE);
        specie2 = new Ankylosaurus(6, 4, DinosaurType.HERBIVORE);
        specie3 = new TyrannosaurusRex(5, 7, DinosaurType.CARNIVORE);

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
        paddock1.addDinosaur(specie1);
        paddock1.removeDinosaur();
        paddock2.addDinosaur(specie1);
        assertEquals(2, park.getCount());
        assertEquals(0, paddock1.getCount());
        assertEquals(1, paddock2.getCount());
    }

    @Test
    public void canTransferOnlyHerbivoreDinosaur__TRUE() {
        park.addPaddock(paddock1);
        park.addPaddock(paddock2);
        paddock1.addDinosaur(specie1);
        paddock2.addDinosaur(specie2);
        park.transferOnlyHerbivoreDinosaur(specie1, paddock1, paddock2);
        assertEquals(2, park.getCount());
        assertEquals(0, paddock1.getCount());
        assertEquals(2, paddock2.getCount());
    }

    @Test
    public void canTransferOnlyHerbivoreDinosaur__FALSE() {
        park.addPaddock(paddock1);
        park.addPaddock(paddock3);
        paddock1.addDinosaur(specie1);
        paddock3.addDinosaur(specie3);
        park.transferOnlyHerbivoreDinosaur(specie3, paddock3, paddock1);
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
