import java.util.Scanner;
import all.*;

public class Main {
    public static void main(String[] args) {
        while (true){
            // Main menu
            System.out.println("# ===== Welcome to Maze Game ===== #");
            System.out.println("           1. Start Game           ");
            System.out.println("           2. Exit Game            ");
            System.out.print("Your choice is : ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            // The Main Game
            if (choice == 1){
                System.out.print("Please enter your name : ");
                String name = input.next();

                player user = new player(name);
                Maze maze = new Maze(user);

                while(true){
                    maze.printMaze();

                    break;
                }
            }
            // Exit game
            else if (choice == 2){
                System.out.println("Thank you for using Maze Game");
                break;
            }
            // Validation of Main menu
            else{
                System.out.println("Invalid choice");
                continue;
            }

            while(true){
                System.out.println("Do you want to continue? (Y/N): ");
                String choice2 = input.next();
                if (choice2.equals("N"))
                    return;
                else if(choice2.equals("Y"))
                    break;
                else
                    System.out.println("Invalid choice");
            }
        }

    }
}
