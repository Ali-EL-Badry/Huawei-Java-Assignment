package all;
import java.util.Random;
public abstract class item extends Character {
  protected int x;
  public item(int  x)
    {
        this.x= x;
    }
  public iteem() {
        Random r = new Random();
        int x , y , z;
        do {
            x = r.nextInt(11);
            y = r.nextInt(11);
            z = r.nextInt(201);
        } while (x == 0 && y == 0);

        super(x, y, z);
    }
}
