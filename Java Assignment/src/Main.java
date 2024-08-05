import java.util.Scanner;
import all.*;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Main menu
            System.out.println("# ===== Welcome to Maze Game ===== #");
            System.out.println("           1. Start Game           ");
            System.out.println("           2. Exit Game            ");
            System.out.print("Your choice is : ");
            int choice = input.nextInt();

            // The Main Game
            if (choice == 1) {
                System.out.print("Please enter your name : ");
                String name = input.next();

                // Set up the game
                player user = new player(name);
                Maze maze = new Maze(user);

                // To keep code running
                while (true) {
                    try {
                        // Print the details of game
                        maze.printMaze();
                        System.out.println("Your health is : " + maze.getUser().getHealth());
                        System.out.println("Your power is : " + maze.getUser().getPower());

                        // Get the Directions of movement
                        System.out.print("Enter The Direction(W/D/S/A): ");
                        String direction = input.next();
                        maze.moves(direction);

                        // Check the losing case
                        if(maze.getUser().getHealth() <= 0){
                            System.out.println("You are dead.");
                            break;
                        }
                        // Check the winning case
                        else if(maze.win()){
                            System.out.println("You win!");
                            break;
                        }

                    }
                    // Catch exception
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
                // To see if he wants to continue or no
                while (true) {
                    System.out.println("Do you want to continue? (Y/N): ");
                    String choice2 = input.next();
                    choice2 = choice2.toUpperCase();
                    if (choice2.equals("N"))
                        return;
                    else if (choice2.equals("Y"))
                        break;
                    else
                        System.out.println("Invalid choice");
                }
            }
            // Exit game
            else if (choice == 2) {
                System.out.println("Thank you for using Maze Game");
                break;
            }
            // Validation of Main menu
            else
                System.out.println("Invalid choice");
        }
    }
}
