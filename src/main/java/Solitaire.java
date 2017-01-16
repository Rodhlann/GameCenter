import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Tim on 1/9/2017.
 */
public class Solitaire implements Game {

    private List<Card> deck = new ArrayList<Card>();
    private final int TABLEAU_MAX_SIZE = 7;
    private final int FOUNDATION_MAX_SIZE = 4;
    private final int STOCK_MAX_SIZE = 1;
    protected List<List<Card>> tableau = new ArrayList<List<Card>>();
    private List<List<Card>> foundation = new ArrayList<List<Card>>();
    private List<Card> stock = new ArrayList<Card>();

    public List<Card> getDeck() { return deck; }
    public List<Card> getStock() { return stock; }

    public void startGame() {
        buildDeck();
        shuffle();
        deal();
        displayCard(stock.get(0));
    }

    public void shuffle() {
        int size = deck.size();
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            int randomStart = random.nextInt(size);
            int randomFinish = random.nextInt(size);
            Card tmpLocationCard = new Card();
            tmpLocationCard.setNumber(deck.get(randomStart).getNumber());
            tmpLocationCard.setSuite(deck.get(randomStart).getSuite());

            deck.get(randomStart).setNumber(deck.get(randomFinish).getNumber());
            deck.get(randomStart).setSuite(deck.get(randomFinish).getSuite());
            deck.get(randomFinish).setNumber(tmpLocationCard.getNumber());
            deck.get(randomFinish).setSuite(tmpLocationCard.getSuite());
        }
    }

    public void buildDeck() {
        for(int i = 1; i <= 52; i++) {
            Card card = new Card();
            if(i <= 13) {
                card.setNumber(i);
                card.setSuite(Card.Suite.CLUBS);
                card.setFaceUp(false);
            }
            if(i > 13 && i <= 26) {
                card.setNumber(i - 13);
                card.setSuite(Card.Suite.DIAMONDS);
                card.setFaceUp(false);
            }
            if(i > 26 && i <= 39) {
                card.setNumber(i - 26);
                card.setSuite(Card.Suite.HEARTS);
                card.setFaceUp(false);
            }
            if(i > 39 && i <= 52) {
                card.setNumber(i - 39);
                card.setSuite(Card.Suite.SPADES);
                card.setFaceUp(false);
            }
            deck.add(card);
        }
    }

    public void deal() {
        for(int i = 0; i < TABLEAU_MAX_SIZE; i++) {
            List<Card> set = new ArrayList<Card>();
            for(int x = 0; x <= i; x++) {
                if(x == i) {
                    deck.get(0).setFaceUp(true);
                    set.add(deck.remove(0));
                } else {
                    set.add(deck.remove(0));
                }
            }
            tableau.add(i, set);
        }
        stock = deck;
    }

    public void displayCard(Card card) {
        String stockDisplay = " ____________\n" +
                              "|"+card.getNumber()+"           |\n" +
                              "|            |\n" +
                              "|      "+card.getSuite().getSymbol()+"     |\n" +
                              "|            |\n" +
                              "|____________|";
        System.out.print(stockDisplay);
    }
}
