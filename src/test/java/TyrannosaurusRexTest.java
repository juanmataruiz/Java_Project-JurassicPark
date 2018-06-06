import Areas.Paddock;
import Enum.DinosaurType;
import Dinosaur.TyrannosaurusRex;
import Enum.PaddockType;
import Human.Visitor;
import ThemePark.Park;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TyrannosaurusRexTest {

    TyrannosaurusRex tyrannosaurusRex1, tyrannosaurusRex2;
    Park park;
    Paddock paddock;
    Visitor visitor1, visitor2;

    @Before
    public void setup() {
        park = new Park();

        tyrannosaurusRex1 = new TyrannosaurusRex(4, 5, DinosaurType.CARNIVORE);
        tyrannosaurusRex2 = new TyrannosaurusRex(6, 5, DinosaurType.CARNIVORE);

        paddock = new Paddock("Velociraptor Paddock", PaddockType.PREDATORS);

        visitor1 = new Visitor("Alan Grant",6);
        visitor2 = new Visitor("Ellie Sattler", 8);
    }

    @Test
    public void dinosaurHasType() {
        assertEquals(DinosaurType.CARNIVORE, tyrannosaurusRex1.getType());
    }

    @Test
    public void dinosaurHasStomach() {
        assertEquals(4, tyrannosaurusRex1.getStomach());
    }

    @Test
    public void dinosaurCanBeFed() {
        tyrannosaurusRex1.dinosaurIsFed();
        assertEquals(5, tyrannosaurusRex1.getStomach());
    }

    @Test
    public void dinosaurCanRampage() {
        TyrannosaurusRex spyTyrannosaurusRex = Mockito.spy(tyrannosaurusRex2);
        Mockito.when(spyTyrannosaurusRex.getRampage()).thenReturn(5);

        assertEquals(5, spyTyrannosaurusRex.getRampage());
    }

    @Test
    public void dinosaurCanHunt(){
        TyrannosaurusRex spyTyrannosaurusRex = Mockito.spy(tyrannosaurusRex1);
        Mockito.when(spyTyrannosaurusRex.getRampage()).thenReturn(7);

        paddock.addDinosaur(spyTyrannosaurusRex);
        park.addVisitor(visitor1);
        spyTyrannosaurusRex.hunt(paddock, park);
        assertEquals(0, paddock.getCount());
        assertEquals(0,park.getVisitorCount());
        assertEquals(5, spyTyrannosaurusRex.getStomach());
    }

    @Test
    public void dinosaurCannotHunt() {
        TyrannosaurusRex spyTyrannosaurusRex = Mockito.spy(tyrannosaurusRex2);
        Mockito.when(spyTyrannosaurusRex.getRampage()).thenReturn(4);

        paddock.addDinosaur(spyTyrannosaurusRex);
        park.addVisitor(visitor2);
        spyTyrannosaurusRex.hunt(paddock, park);
        assertEquals(1,paddock.getCount());
        assertEquals(1,park.getVisitorCount());
        assertEquals(6, spyTyrannosaurusRex.getStomach());
    }


}
