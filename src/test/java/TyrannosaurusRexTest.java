import Enum.DinosaurType;
import Dinosaur.TyrannosaurusRex;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TyrannosaurusRexTest {

    TyrannosaurusRex tyrannosaurusRex;

    @Before
    public void setup() {
        tyrannosaurusRex = new TyrannosaurusRex(5, 4, DinosaurType.CARNIVORE);
    }

    @Test
    public void dinosaurHasType() {
        assertEquals(DinosaurType.CARNIVORE, tyrannosaurusRex.getType());
    }

    @Test
    public void dinosaurHasStomach() {
        assertEquals(5, tyrannosaurusRex.getStomach());
    }

    @Test
    public void dinosaurCanBeFed() {
        tyrannosaurusRex.dinosaurIsFed();
        assertEquals(6, tyrannosaurusRex.getStomach());
    }


}
