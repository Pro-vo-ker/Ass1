import java.util.Scanner;

public class PlayLadderAndSnake {

    public static void main(String[] args) {
        LadderAndSnake game = new LadderAndSnake();
        System.out.println("***\tWelcome to the dangerous adventure of Snakes & Ladders\t***");
        System.out.println("The rule is simple: The first person to reach the top of Mount Bungaloo wins.");
        System.out.println("There are certain objects along the road that you have to be careful about. Ladders will help you get closer to the finish line while Snakes will push you ALLLLL the way back.");

        Scanner scan = new Scanner(System.in);

        int numPlayers = 0;
        int restrict = 4;

        //If made more than 4 error inputs, terminate the game, if not then proceed to play
        while (numPlayers <= 0 || numPlayers > 4) {
            System.out.print("Please enter the number of player (2-4): ");
            numPlayers = scan.nextInt();

            if (numPlayers <= 0 || numPlayers > 4) {
                System.out.println("Please read the instruction carefully. Enter the number of player between TWO and FOUR.");
                System.out.println("You have " + restrict + " attempt(s) left.");
                restrict--;
            }
            if (restrict < 0 ){
                System.out.println("You have failed to follow instruction. Maybe this game is not for you :(");
                System.exit(0);
            }
        }


            game.play(numPlayers);
        }


}

