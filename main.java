import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        System.out.println("Welcome to Snakes & Ladders");

        Scanner scan = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);

        int numPlayers = 0;
        int restrict = 4;

        boolean terminate = false;
        while (!terminate) {
            System.out.print("Please enter the number of player (2-4): ");
            numPlayers = scan.nextInt();

            if (numPlayers <= 0 || numPlayers > 4) {
                System.out.println("Please read the instruction carefully. Enter the number of player between TWO and FOUR): ");
                System.out.println("You have " + restrict + " attempts left.");
                restrict--;
            }

            if (restrict <= 0)
            {
                terminate = true;
                break;
            }
            break;
        }


        if (!terminate) {
            List<Player> players = new ArrayList<Player>();
            System.out.println("Enter your usernames: ");
            for (int i = 0; i < numPlayers; i++) {
                Player player = new Player(keyboard.next());
                players.add(player);
            }

            Object game = new Object(players);


            boolean win = false;
            int playerNext = 0;
            while (!win) {
                Player currentPlayer = players.get(playerNext);
                int roll = currentPlayer.takeTurn();
                win = game.playerMove(currentPlayer, roll);
                if (!win) {
                    System.out.println("The game continues. Everyone roll your die.\n");
                    System.out.println("-----------------------\n");
                }

                if (win) {
                    System.out.println(currentPlayer + " wins");

                }

                playerNext++;
                if (playerNext == numPlayers) {
                    playerNext = 0;
                }

            }
        } else {
            System.out.println("You have made 4 attempts. The program will now be terminated. ");
        }
    }
}