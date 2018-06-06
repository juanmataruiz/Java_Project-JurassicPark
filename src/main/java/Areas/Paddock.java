package Areas;

import Dinosaur.Specie;
import Enum.DinosaurType;
import Enum.PaddockType;

import java.util.ArrayList;

public class Paddock {

    private String name;
    PaddockType paddockType;
    private ArrayList<Specie> species;

    public Paddock(String name, PaddockType paddockType) {
        this.name = name;
        this.paddockType = paddockType;
        this.species = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public PaddockType getType() {
        return paddockType;
    }

    public int getCount() {
        return species.size();
    }


    public void addDinosaur(Specie specie) {
        this.species.add(specie);
    }

    public void removeDinosaur() {
        this.species.remove(0);
    }

    public boolean herbivoreOnly(){
        for (Specie specie : this.species) {
            if (specie.getType() == DinosaurType.HERBIVORE) {
            }
        }
        return true;
    }
}
