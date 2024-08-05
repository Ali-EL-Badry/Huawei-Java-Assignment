package all;

public class player extends Character {
    protected char name;
    protected int health;

    public int getHealth() {
        return health;
    }

    // Constructor of char
    public player(String play) {
        super(0, 0, 10);

        if(play.charAt(0) == 'M')
            this.name = 'm';
        else if(play.charAt(0) == 'H')
            this.name = 'h';
        else if (play.charAt(0) == 'P')
            this.name = 'p';
        else
            this.name = play.charAt(0);

        this.health = 100;
    }
}
