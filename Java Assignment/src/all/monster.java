package all;
import java.util.Random;

public class monster extends Character{

    public monster() {
        Random rand = new Random();
        int x , y , z;
        do {
            x = rand.nextInt(11);
            y = rand.nextInt(11);
            z = rand.nextInt(201);
        } while (x == 0 && y == 0);

        super(x, y, z);
    }
}
