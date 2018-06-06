import Areas.Paddock;
import Dinosaur.Ankylosaurus;
import Enum.DinosaurType;
import Enum.PaddockType;
import ThemePark.Park;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class AnkylosaurusTest {

    Ankylosaurus ankylosaurus;
    Paddock paddock;

    @Before
    public void setup() {
        ankylosaurus = new Ankylosaurus(1, 5, DinosaurType.HERBIVORE);
        paddock = new Paddock("Galliminus Valley", PaddockType.FREE_FROM_PREDATORS);
    }

    @Test
    public void dinosaurHasType() {
        assertEquals(DinosaurType.HERBIVORE, ankylosaurus.getType());
    }

    @Test
    public void dinosaurHasStomach() {
        assertEquals(1, ankylosaurus.getStomach());
    }

    @Test
    public void dinosaurCanBeFed() {
        ankylosaurus.dinosaurIsFed();
        assertEquals(2, ankylosaurus.getStomach());
    }

    @Test
    public void dinosaurCanRampage() {
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus);
        Mockito.when(spyAnkylosaurus.getRampage()).thenReturn(5);

        assertEquals(5, spyAnkylosaurus.getRampage());
    }

    @Test
    public void dinosaurCanHunt(){
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus);
        Mockito.when(spyAnkylosaurus.getRampage()).thenReturn(7);

        paddock.addDinosaur(spyAnkylosaurus);
        spyAnkylosaurus.hunt(paddock);
        assertEquals(0, paddock.getCount());
    }

    @Test
    public void dinosaurCannotHunt() {
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus);
        Mockito.when(spyAnkylosaurus.getRampage()).thenReturn(4);

        paddock.addDinosaur(spyAnkylosaurus);
        spyAnkylosaurus.hunt(paddock);
        assertEquals(1, paddock.getCount());
    }


}
