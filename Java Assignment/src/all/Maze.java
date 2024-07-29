package all;
     
public class Maze {
    private final char[][] maze = new char[10][10];
  
    public Maze() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                this.maze[i][j] = '*';
        }
    }
    public void printMaze() {
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++)
                System.out.print(this.maze[i][j]);
            System.out.println();
        }
    }

}
