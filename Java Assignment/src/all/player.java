package all;

public class player extends Character {
    protected char name;
    protected int health;

    public player(String play) {
        super(0, 0, 10);
        this.name = play.charAt(0);
        this.health = 100;
    }
}
