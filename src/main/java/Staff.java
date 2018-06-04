public class Staff {
    
    private String name;
    private int experience;
    private int food;
    private PositionType positionType;
    
    public Staff(String name, int experience, int food, PositionType positionType) {
        this.name = name;
        this.experience = experience;
        this.food = food;
        this.positionType = positionType;
    }

    public String getName() {
        return this.name;
    }

    public int getExperince() {
        return this.experience;
    }

    public int getFood() {
        return food;
    }

    public PositionType getJobPosition() {
        return positionType;
    }
}
