package GameCenter;

import GameCenter.Card;
import GameCenter.Solitaire;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Tim on 1/9/2017.
 */
public class SolitaireTest {
    final int DECKSIZE = 52;
    final int TABLEAU_MAX_SIZE = 7;
    final int FOUNDATION_MAX_SIZE = 4;
    final int STOCK_MAX_SIZE = 1;


    @Test
    public void testBuildDeck() {
        Solitaire solitaire = new Solitaire();
        solitaire.buildDeck();

        Assert.assertEquals(DECKSIZE, solitaire.getDeck().size());
        Assert.assertTrue("All cards should be unique", verifyAllCardsUnique(solitaire.getDeck()));
    }

    @Test
    public void testShuffle() {
        Solitaire solitaire = new Solitaire();
        solitaire.buildDeck();
        solitaire.shuffle();

        Assert.assertEquals(DECKSIZE, solitaire.getDeck().size());
        Assert.assertTrue("All cards should be unique", verifyAllCardsUnique(solitaire.getDeck()));
    }

    @Test
    public void testDeal() {
        Solitaire solitaire = new Solitaire();
        solitaire.buildDeck();
        solitaire.deal();

        Assert.assertEquals("Tableau not expected size", TABLEAU_MAX_SIZE, solitaire.tableau.size());
        for(int i = 0; i < solitaire.tableau.size(); i++) {
            Assert.assertEquals("Tableau stack "+(i+1)+" is not expected size", i+1, solitaire.tableau.get(i).size());
            Assert.assertTrue("Last card in tableau stack is not face up", solitaire.tableau.get(i).get(solitaire.tableau.get(i).size()-1).isFaceUp());
        }
        Assert.assertEquals("Stock pile does not contain remaining deck cards", solitaire.getDeck(), solitaire.getStock());
    }

    private boolean verifyAllCardsUnique(List<Card> deck) {
        for(int i = 0; i < deck.size(); i++) {
            for(int x = 0; x < deck.size(); x++) {
                Card oldCard = deck.get(i);
                Card newCard = deck.get(x);

                if(x == i) {}
                else if(oldCard.getNumber() == newCard.getNumber() &&
                        oldCard.getSuite() == newCard.getSuite()) {
                    System.out.println("Old GameCenter.Card: " + oldCard.getNumber() + "" + oldCard.getSuite());
                    System.out.println("New GameCenter.Card: " + newCard.getNumber() + "" + newCard.getSuite());
                    return false;
                }
            }
        }
        return true;
    }
}
