package Dinosaur;

import Areas.Paddock;
import Behaviour.IHunt;
import Enum.DinosaurType;
import ThemePark.Park;

public class TyrannosaurusRex extends Specie implements IHunt {

    public TyrannosaurusRex(int stomach, int rampage, DinosaurType dinosaurType) {
        super(stomach, rampage, dinosaurType);
    }

    public void hunt(Paddock paddock, Park park) {
        if (getRampage() >= this.rampage ) {
            paddock.removeDinosaur();
            park.removeVisitor();
            this.dinosaurIsFed();
        }
    }


}
