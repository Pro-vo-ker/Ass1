import java.util.*;

public class LadderAndSnake {

    private static Dice die1 = new Dice();


    public static void play(int numPlayers) {


        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Enter your usernames: ");
        for (int i = 0; i < numPlayers; i++) {
            Scanner keyboard = new Scanner(System.in);
            Player player = new Player(keyboard.next());
            players.add(player);
        }

        System.out.println("The order is as follows: ");

        Map<Integer, Player> tm = new TreeMap<>(Collections.reverseOrder());

        ArrayList<Player> playerOrd = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            players.get(i).setPlayerOrd(die1.flipDice());
            System.out.println(players.get(i) + " rolled a " + players.get(i).getPlayerOrd());
            for (int j = 0; j < numPlayers - 1; j++) {
                if (i != j) {
                    if (players.get(i).getPlayerOrd() == players.get(j).getPlayerOrd()) {
                        players.get(i).setPlayerOrd(die1.flipDice());
                        System.out.println(players.get(i) + " rolled a " + players.get(i).getPlayerOrd());
                        players.get(j).setPlayerOrd(die1.flipDice());
                        System.out.println(players.get(j) + " rolled a " + players.get(j).getPlayerOrd());
                        j = 0;
                    }

                }

            }
        }

        System.out.println();

        Object game = new Object(players);


        boolean win = false;
        int playerNext = 0;
        while (!win) {
            Player currentPlayer = players.get(playerNext);
            int rolls = currentPlayer.playerRoll();
            win = game.playerMove(currentPlayer, rolls);
            if (!win) {
                System.out.println("The journey continues. Everyone get ready!\n");
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

    }

    public LadderAndSnake() {
    }
}


