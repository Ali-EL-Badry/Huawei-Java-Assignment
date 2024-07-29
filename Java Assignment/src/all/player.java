package all;

public class player extends Character {
    protected String name;
    protected int health;

    public player(String name) {
        super(0, 0, 10);
        this.name = name;
        this.health = 100;
    }

    public void move(char direction) throws Exception {
        switch (direction) {
            case 'w':
                if (x > 0) x--;
                else throw new Exception("Cannot move up, out of bounds.");
                break;
            case 's':
                if (x < 9) x++;
                else throw new Exception("Cannot move down, out of bounds.");
                break;
            case 'a':
                if (y > 0) y--;
                else throw new Exception("Cannot move left, out of bounds.");
                break;
            case 'd':
                if (y < 9) y++;
                else throw new Exception("Cannot move right, out of bounds.");
                break;
            default:
                throw new Exception("Invalid move direction.");
        }
    }
}
