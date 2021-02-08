import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Object {

    private final int rows = 10;
    private final int columns = 10;
    private int[][] board;
    private int[][] snake;
    private int[][] ladder;
    Map<Player, Integer> playerPos;
    List<Player> players;

    public Object(List<Player> players) {
        this.playerPos = new HashMap<Player, Integer>();
        for (Player player : players)
            this.playerPos.put(player, 0);

        board = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                board[i][j] = i * rows + j + 1;
            }
            setLadder();
            setSnake();
    }


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


    public boolean playerMove(Player player, int roll) {
        int pos = playerPos.get(player);
        pos += roll;
        System.out.println(player + " landed in " + pos);
        if (pos == 100) {
            playerPos.put(player, 100);
            return true;
        } else {
            if (pos < 100) {
                for (int i = 0; i < 8; i++)
                    if (snake[i][0] == pos) {
                        pos = snake[i][1];
                        if (pos == 100) {
                            playerPos.put(player, 100);
                            return true;
                        } else {
                            playerPos.put(player, pos);

                            System.out.println(player + " encountered a snake and fell " + (snake[i][0] - snake[i][1]) + " steps back to " + snake[i][1]);

                            return false;
                        }
                    }
                        for (int i = 0; i < 9; i++)
                            if (ladder[i][0] == pos) {
                                pos = ladder[i][1];
                                playerPos.put(player, pos);

                                System.out.println(player + " found a ladder and climbed " + (ladder[i][1]- ladder[i][0]) + " steps up to " + ladder[i][1]);

                                return false;
                            }
                    } else if (pos > 100) {
                        pos = 100 - (pos - 100);
                        System.out.println(player + " moved past the map! Move back to " + pos);
                        for (int i = 0; i < 8; i++)
                            if (snake[i][0] == pos) {
                                pos = snake[i][1];
                                playerPos.put(player, pos);

                                System.out.println(player + " encountered a snake and fell " + (snake[i][0] - snake[i][1]) + " steps back to " + snake[i][1]);

                                return false;
                            }
                        for (int i = 0; i < 9; i++)
                            if (ladder[i][0] == pos) {
                                pos = ladder[i][1];
                                playerPos.put(player, pos);

                                System.out.println(player + " found a ladder and climbed " + (ladder[i][0] - ladder[i][1]) + " steps up to " + ladder[i][1]);

                                return false;
                            }

            }
                playerPos.put(player, pos);
                return false;
            }


        }
    }



