/**
 * Created by Tim on 1/9/2017.
 */
public class Player {
    private enum Color {
        RED,
        BLACK,
        BLUE,
        PURPLE,
        GREEN,
        ORANGE,
        YELLOW;
    }

    Color color;
    int wins;
    int losses;

    public Player() {
        color = Color.RED;
        wins = 0;
        losses = 0;
    }

    public Player(Color color) {
        color = color;
        wins = 0;
        losses = 0;
    }
}
