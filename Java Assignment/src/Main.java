import java.util.Random;
import java.util.Scanner;
import all.*;
public class Main {
    public static void main(String[] args) {
        while (true){
            // Main menu
            System.out.println("# ===== Welcome to Maze Game ===== #");
            System.out.println("           1. Start Game           ");
            System.out.println("           2. Exit Game            ");
            System.out.println("Your choice is : ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            // The Main Game
            if (choice == 1){
                System.out.println("Please enter your name : ");
                String name = input.next();
                char pl = name.charAt(0);
                player play = new player(pl);
                Maze maze = new Maze();
                Random rand = new Random();
                int num = rand.nextInt(5);
                monster[] monsters = new monster[num];
                
                while(true){
                    maze.printMaze();
System.out.print("1.w=up/n2.s=down/n3.a=left/n4.d=right");
                    char character=Scanner.next();
                    player.move(character);
                }
            }
            // Exit game
            else if (choice == 2){
                System.out.println("Thank you for using Maze Game");
                break;
            }
            // Validation of Main menu
            else
                System.out.println("Invalid choice");
        }

    }
}
