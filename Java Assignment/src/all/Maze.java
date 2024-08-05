package all;
import java.util.*;

public class Maze {
    // Defining all the needed Variables
    private static final char[][] maze = new char[10][10];
    private static final Random rand = new Random();
    private static final List<monster> monsters = new ArrayList<>();
    private static final List<item> items = new ArrayList<>();
    private static player user = null;
    private static final Scanner scanner = new Scanner(System.in);

    // Player wins if he kill all monsters
    public boolean win(){
        return monsters.isEmpty();
    }

    // To print Player details
    public static player getUser() {
        return user;
    }

    
    private void items_define(int sum){
        int size = rand.nextInt(5) + 1;
        double temp = (double) sum /size;
        int each = (int) Math.ceil(temp);

        for(int i = 0 ; i < size ; i++){
            while(true){
                items.add(new item());
                if(maze[items.get(i).x][items.get(i).y] != 'M')
                    break;
                items.removeLast();
            }
            items.get(i).z = each;
            if(i % 2 == 0)
                maze[items.get(i).x][items.get(i).y] = 'P';
            else
                maze[items.get(i).x][items.get(i).y] = 'H';
        }

    }

    // To define the Main Maze and set all the monsters and items on it
    public Maze(player name) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                maze[i][j] = '*';
        }
        user = name;
        maze[0][0] = user.name;
        int size = rand.nextInt(5) + 1;
        int sum = 0;

        for (int i = 0; i < size; i++) {
            monsters.add(new monster());
            sum += monsters.get(i).power;
            maze[monsters.get(i).x][monsters.get(i).y] = 'M';
        }
        
        // To check that items have the same power of monsters
        items_define(sum);
    }

    public void moves(String c) throws Exception{
        // To check that the string not more than one char
        if(c.length() != 1)
            throw new Exception("Must be a single character");
        // To check that only four directions
        c = c.toUpperCase();
        if(!c.equals("W") && !c.equals("S") && !c.equals("A") && !c.equals("D"))
            throw new Exception("Please enter a Valid character");

        // To make sure that player still in the Maze and identify the rows and cols of the next char
        int col,row;
        switch(c){
            case "W":
                if(user.x == 0)
                    throw new Exception("You Cant Move up");
                else{
                    col = user.y;
                    row = user.x -1;
                    break;
                }
            case "S":
                if(user.x == 9)
                    throw new Exception("You Cant Move down");
                else{
                    col = user.y;
                    row = user.x+1;
                    break;
                }
            case "D":
                if(user.y == 9)
                    throw new Exception("You Cant Move right");
                else{
                    col = user.y+1;
                    row = user.x;
                    break;
                }
            default:
                if(user.y == 0)
                    throw new Exception("You Cant Move left");
                else{
                    col = user.y-1;
                    row = user.x;
                    break;
                }
        }

        // If player goes to Power items
        if(maze[row][col] == 'P'){
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).x == row && items.get(i).y == col) {
                    user.power += items.get(i).z;
                    items.remove(i);
                    break;
                }
            }
        }
        // If player goes to Health items
        else if(maze[row][col] == 'H'){
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).x == row && items.get(i).y == col) {
                    user.health += items.get(i).z;
                    items.remove(i);
                    break;
                }
            }
        }
        // If player goes to Monsters
        else if (maze[row][col] == 'M'){
            // to make sure that not two monsters have the same coordinate
            boolean check = true;
            for (int i = 0; i < monsters.size(); i++) {
                // To make sure that player know monster powers and decide to kill it or no
                if (monsters.get(i).x == row && monsters.get(i).y == col){
                    while (check){
                        System.out.println(STR."The power of Monster is \{monsters.get(i).power}");
                        System.out.print("Do u want to kill this Monster(Y/N): ");
                        String answer = scanner.next();
                        answer  = answer.toUpperCase();
                        if(Objects.equals(answer, "Y"))
                            break;
                        else if(Objects.equals(answer, "N"))
                            return;
                        else
                            System.out.println("Please enter a valid character");
                    }
                    // If power of monster is higher than power of player
                    if(monsters.get(i).power > user.power && check)
                        user.health -= monsters.get(i).power-user.power;
                    check = false;
                    monsters.remove(i);
                }
            }
        }
        // Give Player the new coordinate
        maze[row][col] = maze[user.x][user.y];
        maze[user.x][user.y] = '*';
        user.x = row;
        user.y = col;
    }

    // To print the Maze 
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
