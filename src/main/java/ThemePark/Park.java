package ThemePark;

import Areas.Paddock;
import Human.Visitor;
import Dinosaur.Specie;
import Enum.DinosaurType;

import java.util.ArrayList;

public class Park {
    
    private ArrayList<Paddock> paddocks;
    private ArrayList<Specie> species;
    private ArrayList<Visitor> visitors;

    public Park() {
        this.paddocks = new ArrayList<>();
        this.species = new ArrayList<>();
        this.visitors = new ArrayList<>();
    }

    public int getCount() {
        return paddocks.size();
    }

    public void addPaddock(Paddock paddock) {
        this.paddocks.add(0, paddock);
    }

    public void removePaddock() {
        this.paddocks.remove(0);
    }

    public void transferOnlyHerbivoreDinosaur(Specie specie, Paddock origin, Paddock destination) {
            if (specie.getType() == DinosaurType.HERBIVORE) {
                if (destination.herbivoreOnly()) {
                    origin.removeDinosaur();
                    destination.addDinosaur(specie);
                }
            }
        }

    public int getVisitorCount() {
        return visitors.size();
    }

    public void addVisitor(Visitor visitor) {
        this.visitors.add(0, visitor);
    }

    public void removeVisitor() {
        this.visitors.remove(0);
    }
}
