package GameCenter;

/**
 * Created by Tim on 1/9/2017.
 */
public interface Game {

    enum GameType {
        CHECKERS,
        CHESS,
        SOLITAIRE;

        GameType() {

        }
    }

    void startGame();
}
