import People.JobPositionType;
import People.Staff;
import Species.Ankylosaurus;
import Species.Dinosaur;
import Species.DinosaurType;
import Species.TyrannosaurusRex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaffTest {

    Staff staff1, staff2;
    Dinosaur dino1, dino2;

    @Before
    public void setup() {
        staff1 = new Staff("Hannah", 7, JobPositionType.BIOENGINEER);
        staff2 = new Staff("Colin", 10, JobPositionType.ZOOKEEPER);
        dino1 = new Ankylosaurus(5, 3, DinosaurType.HERBIVORE);
        dino2 = new TyrannosaurusRex(5,9, DinosaurType.CARNIVORE);

    }

    @Test
    public void staffHasName() {
        assertEquals("Hannah", staff1.getName());
    }

    @Test
    public void staffHasExperience() {
        assertEquals(7, staff1.getExperience());
    }

    @Test
    public void staffHasAJodPosition() {
        assertEquals(JobPositionType.ZOOKEEPER, staff2.getJobPosition());
    }

    @Test
    public void staffHasFood() {
        assertEquals(10, staff2.getFood());
    }

    @Test
    public void canIncreaseFoodAmount() {
        staff1.addFood();
        assertEquals(11, staff1.getFood());
    }

    @Test
    public void canReduceFoodAmount() {
        staff1.removeFood();
        assertEquals(9, staff1.getFood());
    }

    @Test
    public void staffCanFeedDinosaur__TRUE() {
        staff2.feedDinosaur(dino1);
        assertEquals(9, staff2.getFood());
        assertEquals(6, dino1.getStomach());
    }

    @Test
    public void staffCanFeedDinosaur__FALSE_NOZOOKEEPER() {
        staff1.feedDinosaur(dino2);
        assertEquals(10, staff1.getFood());
        assertEquals(5, dino2.getStomach());
    }

    @Test
    public void staffCanFeedDinosaur__FALSE_NOENOUGHTEXPERIENCE() {
        staff1.feedDinosaur(dino2);
        assertEquals(10, staff1.getFood());
        assertEquals(5, dino2.getStomach());
    }

    @Test
    public void staffCanFeedDinosaur__FALSE() {
        Staff staff3 = new Staff("Daniel", 5, JobPositionType.SECURITY_GUARD);
        staff3.feedDinosaur(dino2);
        assertEquals(10, staff3.getFood());
        assertEquals(5, dino2.getStomach());
    }


}
