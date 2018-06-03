import Areas.Paddock;
import Areas.PaddockType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {

    Park park;
    Paddock paddock1, paddock2, paddock3;

    @Before
    public void setup() {
        park = new Park(20);
        paddock1 = new Paddock("Gyrosphere", PaddockType.ATTRACTIONS) {};
        paddock2 = new Paddock("Galliminus Valley", PaddockType.FREE_FROM_PREDATORS) {};
        paddock3 = new Paddock("Velociraptor Paddock", PaddockType.PREDATORS){};
    }

    @Test
    public void parkHasFood() {
        assertEquals(20, park.getFood());
    }

    @Test
    public void parkCanAddFood() {
        park.addFood();
        park.addFood();
        assertEquals(22, park.getFood());
    }


// THIS METHOD WILL ALLOW TO FEED DINOSAURS
    @Test
    public void parkCanRemoveFood() {
        park.removeFood();
        assertEquals(19, park.getFood());
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

}
