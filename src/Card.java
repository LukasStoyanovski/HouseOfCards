import java.util.Arrays;
import java.util.List;

public class Card {
    private String suit;
    private String type;

    public Card(String type, String suit) throws InvalidCardException {
        if (!isValidType(type)) {
            throw new InvalidCardException("Invalid card type: " + type);
        }
        if (!isValidSuit(suit)) {
            throw new InvalidCardException("Invalid card suit: " + suit);
        }
        this.type = type;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public String getType() {
        return type;
    }

    private boolean isValidSuit(String suit) {
        List<String> validSuits = getValidSuits();
        return validSuits.contains(suit);
    }

    private boolean isValidType(String type) {
        List<String> validTypes = getValidTypes();
        return validTypes.contains(type);
    }

    public static List<String> getValidSuits() {
        return Arrays.asList("♥", "♦", "♠", "♣");
    }

    public static List<String> getValidTypes() {
        return Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King");
    }

    public int getCardValue() {
        switch (type) {
            case "Ace":
                return 11;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            default:
                return 10;
        }
    }

    @Override
    public String toString() {
        return type + " " + suit;
    }
}