package GameCenter;

/**
 * Created by Tim on 1/9/2017.
 */
public class Card {
    public enum Suite{
        HEARTS ('\u2661'),
        DIAMONDS ('\u2662'),
        CLUBS ('\u2663'),
        SPADES('\u2660');

        private char symbol;
        public char getSymbol() {
            return symbol;
        }
        public void setSymbol(char symbol) {
            this.symbol = symbol;
        }

        Suite(char symbol) {
            this.setSymbol(symbol);
        }
    }

    int number;
    Suite suite;
    boolean faceUp;

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
