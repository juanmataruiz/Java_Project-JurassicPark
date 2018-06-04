import Species.Dinosaur;
import Species.DinosaurType;
import Species.TyrannosaurusRex;

public class Staff {
    
    private String name;
    private int experience;
    private int food;
    private JobPositionType jobPositionType;
    
    public Staff(String name, int experience, JobPositionType jobPositionType) {
        this.name = name;
        this.experience = experience;
        this.food = 10;
        this.jobPositionType = jobPositionType;
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

    public JobPositionType getJobPosition() {
        return jobPositionType;
    }

    public void addFood() {
        this.food ++;
    }

    public void removeFood() {
        this.food --;
    }

    public void feedDinosaur(Dinosaur dino1) {
        if (this.jobPositionType == JobPositionType.ZOOKEEPER && this.experience >= 7) {
            this.removeFood();
            dino1.dinosaurIsFed();
        }
    }

}
