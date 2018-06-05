package People;

public class Visitor {

    private String name;
    private int speed;

    public Visitor(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
