import Species.Dinosaur;

public class Staff {
    
    private String name;
    private int experience;
    private int food;
    private PositionType positionType;
    
    public Staff(String name, int experience, PositionType positionType) {
        this.name = name;
        this.experience = experience;
        this.food = 10;
        this.positionType = positionType;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getFood() {
        return food;
    }

    public PositionType getJobPosition() {
        return positionType;
    }

    public void addFood() {
        this.food ++;
    }

    public void removeFood() {
        this.food --;
    }

    public void feedDinosaur(Dinosaur dino1) {
        this.removeFood();
        dino1.dinosaurIsFed();
    }
}
