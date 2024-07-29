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
                Maze maze = new Maze();
                maze.printMaze();
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
