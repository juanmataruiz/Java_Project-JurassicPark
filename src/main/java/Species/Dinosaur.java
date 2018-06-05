package Species;


import Areas.Paddock;
import ThemePark.Park;

public abstract class Dinosaur {

    private int stomach;
    private int rampage;
    private DinosaurType dinosaurType;

    public Dinosaur(int stomach, int rampage, DinosaurType dinosaurType) {
        this.stomach = stomach;
        this.rampage = rampage;
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

    // Method used for random rampage, no tested!

//    public int getRampage() {
//      Random rand = new Random();
//      int n = rand.nextInt(10) + 1;
//      return n;
//    }

    public int getRampage() {
        return rampage;
    }

    public void getHunt(Paddock paddock, Park park) {
        if (this.rampage >= 6) {
            paddock.removeDinosaur();
            park.removeVisitor();
            this.dinosaurIsFed();
        }
    }


}
