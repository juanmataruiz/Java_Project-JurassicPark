package Species;


import java.util.Random;

public abstract class Dinosaur {

    private int stomach;
    private int rampage;
    private DinosaurType dinosaurType;

    public Dinosaur(int stomach, DinosaurType dinosaurType) {
        this.stomach = stomach;
        this.rampage = 5;
        this.dinosaurType = dinosaurType;
    }

    public DinosaurType getType() {
        return dinosaurType;
    }

    public int getStomach() {
        return stomach;
    }

    public void dinosaurIsFed() {
        this.stomach++;
    }

    public int getRampage() {
      Random rand = new Random();
      int n = rand.nextInt(10) + 1;
      return n;
    }

    public void getHunt() {
        if (this.rampage >= getRampage()) {
            this.dinosaurIsFed();
        }
    }

    // mock methods

    public int getMockRampage(int mock) {
        return mock;
    }

    public void isMockRampaging_True() {
        if (this.rampage <= getMockRampage(7)) {
            this.dinosaurIsFed();
        }
    }

    public void isMockRampaging_False() {
        if (this.rampage <= getMockRampage(4)) {
            this.dinosaurIsFed();
        }
    }

    //
}
