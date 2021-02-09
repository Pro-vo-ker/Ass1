import java.util.Random;

public class Dice {
    //Declare instance variable
    private Random rnd;;

    //Constructor
    public Dice()
    {
        rnd = new Random();
    }

    /**
     * Generate the value of the die
     * @return the value
     */
    public int flipDice()
    {
        return (rnd.nextInt(6) + 1 );
    }
}
