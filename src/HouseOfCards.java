import java.util.ArrayList;
import java.util.List;

public class HouseOfCards {
    private List<House> houses;
    private Deck deck;
    private Player player;

    public HouseOfCards() throws InvalidCardException {
        houses = new ArrayList<>();
        deck = new Deck();
        player = new Player();
    }

    public Deck getDeck() {
        return deck;
    }

    public Player getPlayer() {
        return player;
    }

    public void addHouse(House house) {
        houses.add(house);
    }

    public void addPlayer(Player player) {
        this.player = player;
    }

    public void addDeck(Deck deck) {
        this.deck = deck;
    }

    public boolean checkAllHouses() {
        for (House house : houses) {
            if (house.getAvailable()) {
                return true;
            }
        }
        return false;
    }
}




