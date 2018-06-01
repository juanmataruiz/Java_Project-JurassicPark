package Areas;

import Species.Dinosaur;

import java.util.ArrayList;

public abstract class Paddock  {

    private String name;
    PaddockType paddockType;
    private ArrayList<Dinosaur> dinosaurs;

    public Paddock(String name, PaddockType paddockType) {
        this.name = name;
        this.paddockType = paddockType;
        this.dinosaurs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public PaddockType getType() {
        return paddockType;
    }
}
