import java.util.Random;

public class Dice {

    private Random rnd;;

    public Dice()
    {
        rnd = new Random();
    }

    public int flipDice()
    {
        return (rnd.nextInt(7) );
    }
}
