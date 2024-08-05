package all;

public class Character {
    protected int x, y, power;

    // Print Power
    public int getPower() {
        return power;
    }

    // Constructor of char
    public Character(int x, int y, int power){
        this.x = x;
        this.y = y;
        this.power = power;
    }
}
