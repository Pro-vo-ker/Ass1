import java.util.*;

public class LadderAndSnake {

    //Declare instance variables
    private static Dice die1 = new Dice();


    /**
     * Start the core of the game
     * @param numPlayers number of players
     */
    public static void play(int numPlayers) {


        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Enter your usernames: "); //Prompt the users to enter their names
        for (int i = 0; i < numPlayers; i++) {
            Scanner keyboard = new Scanner(System.in);
            Player player = new Player(keyboard.next());
            players.add(player); //Add the names into the player list
        }

        System.out.println("Now it's time to decide who will go first.\n");
        for (int i = 0; i < numPlayers; i++)
        {
            players.get(i).setPlayerOrd(die1.flipDice());//Roll the die to get the order to play
            System.out.println(players.get(i) + " rolled a " + players.get(i).getPlayerOrd()); //Display the values
        }

        Collections.sort(players); //compareTo()
        Collections.reverse(players); //Since compareTo() sorts from lowest to highest, reverse the order
        System.out.println("\n");
        System.out.println("The order is as follows: ");
        for (int i = 0; i < numPlayers; i++){
            System.out.print(players.get(i) + "\t");
        }

        System.out.println("\n");

        Object game = new Object(players);


        //If win = true, a player has reached 100 thus ending the game
        boolean win = false;
        int playerNext = 0; //Record whose turn it is
        int turn = 0; //Record the round
        while (!win) {
            Player currentPlayer = players.get(playerNext);
            int rolls = currentPlayer.playerRoll();
            win = game.playerMove(currentPlayer, rolls);
            if (!win) {
                System.out.println();
                System.out.println("-----------------------\n");
            }

            if (win) {
                System.out.println(currentPlayer + " has reached the finish line. Congratulation!!!");
                System.out.println("\n***********************");
            }
            playerNext++;

            if (playerNext == numPlayers) {
                playerNext = 0;
                turn++;
                if (!win) {
                    System.out.println("That is the end of round " + turn + ".\n");
                    System.out.println("Because no one has made it to the top of mount Bungaloo yet, the journey continues. Everyone roll your die!\n");
                    System.out.println("-----------------------\n");
                }
            }

        }

    }

    public LadderAndSnake() {
    }
}


