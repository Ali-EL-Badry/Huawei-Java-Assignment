package all;
import java.util.Random;
public class item{

    protected int x, y, z;
    public item() {
        Random r = new Random();
        int x , y , z;
        do {
            x = r.nextInt(10);
            y = r.nextInt(10);
        } while (x == 0 && y == 0);
        this.x = x;
        this.y = y;

    }

}
