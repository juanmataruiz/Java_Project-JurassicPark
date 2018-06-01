import Areas.Paddock;

import java.util.ArrayList;

public class Park {
    
    private ArrayList<Paddock> paddocks;
    private int food;

    public Park(int food) {
        this.paddocks = new ArrayList<>();
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addFood() {
        this.food ++;
    }

    public void removeFood() {
        this.food --;
    }
}
