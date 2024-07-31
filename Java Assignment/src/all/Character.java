package all;

public class Character {
    protected int x, y, power;

    public void setPower(int power) {
        this.power = power;
    }


    public int getPower() {
        return power;
    }

    public Character(int x, int y, int power){
        this.x = x;
        this.y = y;
        this.power = power;
    }
}
