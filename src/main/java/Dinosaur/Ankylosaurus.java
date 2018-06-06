package Dinosaur;

import Areas.Paddock;
import Enum.DinosaurType;

public class Ankylosaurus extends Specie {

    public Ankylosaurus(int stomach, int rampage, DinosaurType dinosaurType) {
        super(stomach, rampage, dinosaurType);
    }

    public void hunt(Paddock paddock) {
        if (getRampage() >= this.rampage ) {
            paddock.removeDinosaur();
        }
    }



}
