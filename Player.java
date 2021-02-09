public class Player implements Comparable{
    //Declare instance variables
    private int rerolledCheck;
    private String playerName;
    private static  Dice die = new Dice();
    private int playerOrd;
    private int playerPosition;

    /**
     * Constructor
     * @param name the names of the players which will be added by them later on
     */
    public Player(String name)
    {
        this.rerolledCheck = 0;
        this.playerName = name;
        this.playerOrd = 0;
        this.playerPosition = 0;
    }

    /**
     * Get the reroll value
     * @return the value
     */
    public int getRerolledCheck() {
        return rerolledCheck;
    }

    /**
     * Set the reroll value
     * @param rerolledCheck the value
     */
    public void setRerolledCheck(int rerolledCheck) {
        this.rerolledCheck = rerolledCheck;
    }

    /**
     * Set the position of the player
     * @param playerPosition the position of a player
     */
    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    /**
     * Get the position
     * @return the value
     */
    public int getPlayerPosition() {
        return playerPosition;
    }

    /**
     * Get players' names
     * @return players' names
     */
    public String toString() {
        return playerName;
    }

    /**
     * Get the order
     * @return order of players
     */
    public int getPlayerOrd() {
        return playerOrd;
    }

    /**
     * Set the order assigned to the player
     * @param playerOrd
     */
    public void setPlayerOrd(int playerOrd) {
        this.playerOrd = playerOrd;
    }

    /**
     * Announce the turns and display the die value
     * @return the die value
     */
    public int playerRoll() {
        int roll = 0;
        roll = die.flipDice();
        System.out.println("It's " + playerName + "'s turn.");
        System.out.println(playerName + " rolled " + roll + ".");
        return roll;
    }

    /**
     * Compare the values the players got at the start of the game to sort their order to play.
     * @param o an object in Class Player
     * @return 1 win a value is larger than the value it is compared to, -1 if a value is smaller than the value it is compared to
     */
    @Override
    public int compareTo(java.lang.Object o) {
        if (this.playerOrd > ((Player)o).playerOrd) return 1;
        else if (this.playerOrd < ((Player)o).playerOrd) return -1;
        else {
            System.out.println("It is a tie between player " + this.playerName + " and " + ((Player) o).playerName ) ;
            System.out.println("Reroll!!!\n");
            if (this.rerolledCheck != ((Player) o).rerolledCheck){
                if (this.rerolledCheck > ((Player) o).rerolledCheck) return 1;
                else return -1;
            }
            while (true) {
                this.rerolledCheck = die.flipDice();
                ((Player) o).rerolledCheck = die.flipDice();
                if (this.rerolledCheck > ((Player) o).rerolledCheck) {
                    System.out.println("Player " + this.playerName + " rolled a " + this.rerolledCheck +" while player " + ((Player) o).playerName + " rolled a " + ((Player) o).rerolledCheck);
                    System.out.println("");
                    return 1;
                }
                if (this.rerolledCheck < ((Player) o).rerolledCheck ){
                    System.out.println("Player " + this.playerName + " rolled a " + this.rerolledCheck +" while player " + ((Player) o).playerName + " rolled a " + ((Player) o).rerolledCheck);
                    return -1;
                }
            }
        }
    }
}
