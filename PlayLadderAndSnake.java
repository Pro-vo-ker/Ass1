import java.util.Scanner;

public class PlayLadderAndSnake {

    public static void main(String[] args) {
        LadderAndSnake game = new LadderAndSnake();
        System.out.println("Welcome to Snakes & Ladders");

        Scanner scan = new Scanner(System.in);

        int numPlayers = 0;
        int restrict = 4;

        while (numPlayers <= 0 || numPlayers > 4) {
            System.out.print("Please enter the number of player (2-4): ");
            numPlayers = scan.nextInt();

            if (numPlayers <= 0 || numPlayers > 4) {
                System.out.println("Please read the instruction carefully. Enter the number of player between TWO and FOUR.");
                System.out.println("You have " + restrict + " attempts left.");
                restrict--;
            }
            if (restrict < 0){
                System.out.println("You have failed to follow instruction. Maybe this game is not for you :(");
                System.exit(0);
            }
        }


            game.play(numPlayers);
        }


}

