import java.util.ArrayList;

public class Player extends ArrayList<Player> {

    private String playerName;
    private static  Dice die = new Dice();
    private int playerOrd;
    private int playerPosition;


    public Player(String name)
    {
        this.playerName = name;
        this.playerOrd = 0;
        this.playerPosition = 0;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public String toString() {
        return playerName;
    }


    public int getPlayerOrd() {
        return playerOrd;
    }

    public void setPlayerOrd(int playerOrd) {
        this.playerOrd = playerOrd;
    }

    public int playerRoll() {
        int roll = 0;
        roll = die.flipDice();
        System.out.println("It's " + playerName + "'s turn.");
        System.out.println(playerName + " rolled " + roll + ".");
        return roll;
    }
}
