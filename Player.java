public class Player {

    private String playerName;
    private static  Dice die = new Dice();

    public Player(String name)
    {
        this.playerName = name;
    }

    public String toString() {
        return playerName;
    }
    public int takeTurn() {
        int roll = 0;
        roll = die.flipDice();
        System.out.println("It's " + playerName + "'s turn.");
        System.out.println(playerName + " rolled " + roll + ".");
        return roll;
    }
}
