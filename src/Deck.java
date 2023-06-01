import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck;

    public Deck() throws InvalidCardException {
        initializeDeck();
    }

    public List<Card> getDeck() {
        return deck;
    }

    public int deckSize() {
        return deck.size();
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        } else {
            return null;
        }
    }

    public void initializeDeck() throws InvalidCardException {
        List<String> suits = Card.getValidSuits();
        List<String> types = Card.getValidTypes();

        deck = new ArrayList<>();

        for (String suit : suits) {
            for (String type : types) {
                deck.add(new Card(type, suit));
            }
        }
    }

    @Override
    public String toString() {
        return "Deck [deck=" + deck + "]";
    }
}