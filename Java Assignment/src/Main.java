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

                player user = new player(name);
                Maze maze = new Maze(user);

                while (true) {
                    try {
                        maze.printMaze();
                        System.out.println("Your health is : " + maze.getUser().getHealth());
                        System.out.println("Your power is : " + maze.getUser().getPower());
                        System.out.print("Enter The Direction(W/D/S/A): ");
                        String direction = input.next();
                        maze.moves(direction);
                        if(maze.getUser().getHealth() <= 0){
                            System.out.println("You are dead.");
                            break;
                        }
                        else if(maze.win()){
                            System.out.println("You win!");
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
            // Exit game
            else if (choice == 2) {
                System.out.println("Thank you for using Maze Game");
                break;
            }
            // Validation of Main menu
            else {
                System.out.println("Invalid choice");
                continue;
            }

            while (true) {
                System.out.println("Do you want to continue? (Y/N): ");
                String choice2 = input.next();
                if (choice2.equals("N"))
                    return;
                else if (choice2.equals("Y"))
                    break;
                else
                    System.out.println("Invalid choice");
            }
        }
    }
}
