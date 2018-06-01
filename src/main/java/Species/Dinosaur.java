package Species;


public abstract class Dinosaur {

    private int stomach;
    private DinosaurType dinosaurType;

    public Dinosaur(int stomach, DinosaurType dinosaurType) {
        this.stomach = stomach;
        this.dinosaurType = dinosaurType;
    }

    public DinosaurType getType() {
        return dinosaurType;
    }

    public int getStomach() {
        return stomach;
    }
}
