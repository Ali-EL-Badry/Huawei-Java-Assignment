package all;
import java.util.Random;

public class Maze {
    private static final char[][] maze = new char[10][10];
    private static final Random rand = new Random();
    private static final monster[] monsters = new monster[rand.nextInt(6)];
    private static final item[] items = new item[rand.nextInt(6)];

    private void items_define(int sum){
        double temp = (double) sum /items.length;
        int each = (int) Math.ceil(temp);
        for(int i = 0 ; i < items.length ; i++){
            while(true){
                items[i] = new item();
                if(maze[items[i].x][items[i].y] != 'M')
                    break;
            }
            items[i].z = each;
            if(i % 2 == 0)
                maze[items[i].x][items[i].y] = 'P';
            else
                maze[items[i].x][items[i].y] = 'H';
        }

    }

    public Maze(player name) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                maze[i][j] = '*';
        }

        maze[0][0] = name.name;
        int sum = 0;
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new monster();
            sum += monsters[i].power;
            maze[monsters[i].x][monsters[i].y] = 'M';
        }
        items_define(sum);
    }

    public void printMaze() {
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++){
                System.out.print(maze[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
