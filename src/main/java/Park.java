import Areas.Paddock;
import Species.Dinosaur;
import Species.DinosaurType;

import java.util.ArrayList;

public class Park {
    
    private ArrayList<Paddock> paddocks;
    private ArrayList<Dinosaur> dinosaurs;

    public Park() {
        this.paddocks = new ArrayList<>();
        this.dinosaurs = new ArrayList<>();
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

    public void transferOnlyHerbivoreDinosaur(Dinosaur dinosaur, Paddock origin, Paddock destination) {
            if (dinosaur.getType() == DinosaurType.HERBIVORE) {
                if (destination.herbivoreOnly()) {
                    origin.removeDinosaur();
                    destination.addDinosaur(dinosaur);
                }
            }
        }

}
