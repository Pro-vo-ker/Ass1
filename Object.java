import java.util.*;

public class Object {


//Declare instance variables used to build the map and objects on the map (ladders and snakes)
    private final int rows = 10; //Used to create map
    private final int columns = 10; //Used to create map
    private int[][] board; //structure of the map
    private int[][] snake; //structure of the snakes
    private int[][] ladder; //structure of the ladders
    List<Player> players;

    /**
     * Constructor of the map
     *@param players the players enter the game
     */
    public Object(List<Player> players) {

        //Add numbers on each row and column of the map
        board = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                board[i][j] = i * rows + j + 1;
            }

        //Set the snakes and ladders
        setLadder();
        setSnake();
    }

    //Create each snake for the map
    public void setSnake() {
        snake = new int[8][2];
        snake[0][0] = 16;
        snake[0][1] = 6;
        snake[1][0] = 79;
        snake[1][1] = 19;
        snake[2][0] = 64;
        snake[2][1] = 60;
        snake[3][0] = 95;
        snake[3][1] = 24;
        snake[4][0] = 48;
        snake[4][1] = 30;
        snake[5][0] = 93;
        snake[5][1] = 68;
        snake[6][0] = 97;
        snake[6][1] = 76;
        snake[7][0] = 98;
        snake[7][1] = 78;
    }

    //Create each ladder for the map
    public void setLadder()
    {
        ladder = new int[9][2];
        ladder[0][0] = 1;
        ladder[0][1] = 38;
        ladder[1][0] = 4;
        ladder[1][1] = 14;
        ladder[2][0] = 9;
        ladder[2][1] = 31;
        ladder[3][0] = 21;
        ladder[3][1] = 42;
        ladder[4][0] = 36;
        ladder[4][1] = 44;
        ladder[5][0] = 28;
        ladder[5][1] = 84;
        ladder[6][0] = 51;
        ladder[6][1] = 67;
        ladder[7][0] = 71;
        ladder[7][1] = 91;
        ladder[8][0] = 80;
        ladder[8][1] = 100;
    }

    /**
     * Move the players according to their roll
     * @param player The players in the game
     * @param roll The value of the players' roll
     * @return boolean true if a person reaches 100 thus winning the game, false if noone reaches 100 thus continuing the game
     */
    public boolean playerMove(Player player, int roll) {

        int currentPosition = player.getPlayerPosition(); //create a number which represent a player's position, the method getPlayerPostion() will retrieve the number
        player.setPlayerPosition(currentPosition + roll); //set the position to be the previous position + the value of the die
        System.out.println(player +" landed in " + player.getPlayerPosition() + "."); //Display the message including the name of the player and their position on the map

        //Check if the player has reached 100 or not
        if (player.getPlayerPosition() == 100) {
            // If so return true which will end the game
            return true;
        } else {
            //If the player has not gone out of the map
            if (player.getPlayerPosition() < 100) {
                //Check if the player is standing at the head of the snake or not
                for (int i = 0; i < 8; i++)
                    //If so then set the position of the player to the position of the tail of the snake
                    if (snake[i][0] == player.getPlayerOrd()) {
                        player.setPlayerPosition(snake[i][1]);
                        System.out.println(player + " encountered a snake and fell " + (snake[i][0] - snake[i][1]) + " steps back to " + snake[i][1] + "."); //Display the messaging including the steps they have lost and their current position
                        //return false to keep the game running
                        return false;
                    }
                //Check if the player is standing at the bottom of the ladder or not
                for (int i = 0; i < 9; i++)
                    //If so then set the position of the player to the position of the top of the ladder
                    if (ladder[i][0] == player.getPlayerPosition()) {
                        player.setPlayerPosition(ladder[i][1]);
                        //Because there is 1 ladder that can help the player win the game, check if the player's new position is at 100 or not
                        if (player.getPlayerPosition() == 100) {
                            System.out.println(player + " found a ladder and climbed " + (ladder[i][1] - ladder[i][0]) + " steps up to " + ladder[i][1]);
                            return true;
                        } else {
                            System.out.println(player + " found a ladder and climbed " + (ladder[i][1] - ladder[i][0]) + " steps up to " + ladder[i][1]);

                            return false;
                        }
                    }
                //The code is similar but this time the player has gone out of the map so they have to go back according to the instruction.
            } else if (player.getPlayerPosition() > 100) {
                //For example the person is at 98 and they roll a 4 and move to 102, they have to go back to 98 because 100 - ( 98 + 4 - 100), thus the equation
                player.setPlayerPosition(100 - (player.getPlayerPosition()-100));
                System.out.println(player + " moved past the map! Move back to " + player.getPlayerPosition());
                for (int i = 0; i < 8; i++)
                    if (snake[i][0] == player.getPlayerPosition()) {
                        player.setPlayerPosition(snake[i][1]);
                        player.getPlayerPosition();
                        System.out.println(player + " encountered a snake and fell " + (snake[i][0] - snake[i][1]) + " steps back to " + snake[i][1]);

                        return false;
                    }
                for (int i = 0; i < 9; i++)
                    if (ladder[i][0] == player.getPlayerPosition()) {
                        player.setPlayerPosition(ladder[i][1]);
                        System.out.println(player + " found a ladder and climbed " + (ladder[i][0] - ladder[i][1]) + " steps up to " + ladder[i][1]);

                        return false;
                    }

            }
            return false;
        }


    }

}



