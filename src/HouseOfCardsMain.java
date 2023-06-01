import java.util.Scanner;

public class HouseOfCardsMain {
    public static void main(String[] args) throws InvalidCardException {
        HouseOfCards game = new HouseOfCards();
        House[] houses = new House[4];
        for (int i = 0; i < 4; i++) {
            houses[i] = new House();
            game.addHouse(houses[i]);
        }
        
        Deck deck = new Deck();
        game.addDeck(deck);
        
        Scanner scanner = new Scanner(System.in);
        
        Player player = new Player();
        game.addPlayer(player);
        
        while (deck.deckSize() > 0 && !allHousesClosed(houses)) {
            deck.shuffleDeck();
            Card card = deck.dealCard();
            if (card != null) {
                System.out.println("Dealt card: " + card);
                
                House suggestedHouse = getSuggestedHouse(houses, card);
                if (suggestedHouse != null) {
                    int suggestedHouseIndex = getHouseIndex(houses, suggestedHouse);
                    System.out.println("Suggested house (House " + suggestedHouseIndex + "): " + suggestedHouse);
                }
                
                System.out.println("Choose a house (1-4) to place the card: ");
                int houseIndex = scanner.nextInt();
                if (houseIndex >= 1 && houseIndex <= 4) {
                    House house = houses[houseIndex - 1];
                    if (house.isAvailable()) {
                        if (otherAlternatives(house.getCurrentValue(), card.getCardValue())) {
                            System.out.println("There are other free houses");
                        } else {
                            house.setCurrentValue(house.getCurrentValue() + card.getCardValue());
                            house.calculateHouse(player);
                            System.out.println("Card placed in House " + houseIndex);
                            System.out.println("House value " + house.getCurrentValue());
                            System.out.println("Player points " + player.getPoints());
                        }
                    } else {
                        System.out.println("House " + houseIndex + " is closed. Choose another house.");
                    }
                } else {
                    System.out.println("Invalid house index. Choose a number between 1 and 4.");
                }
            } else {
                break;
            }
        }
        
        scanner.close();
        
        if (player.getPoints() > 0) {
            System.out.println("Congratulations! You earned " + player.getPoints() + " points.");
        } else {
            System.out.println("Sorry, you lost. No points earned.");
        }
        
        if (allHousesClosed(houses) || deck.deckSize() == 0) {
            endGame();
        }
    }
    
    private static boolean allHousesClosed(House[] houses) {
        for (House house : houses) {
            if (house.isAvailable()) {
                return false;
            }
        }
        return true;
    }
    
    private static House getSuggestedHouse(House[] houses, Card card) {
        for (House house : houses) {
            int newValue = house.getCurrentValue() + card.getCardValue();
            if (newValue == House.MAX_VALUE) {
                return house;
            }
        }
        return null;
    }
    
    private static boolean otherAlternatives(int house, int card) {
        int newValue = house + card;
        if (newValue > House.MAX_VALUE) {
            return true;
        }
        return false;
    }
    
    private static int getHouseIndex(House[] houses, House targetHouse) {
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == targetHouse) {
                return i + 1;
            }
        }
        return -1; // If the target house is not found
    }
    
    private static void endGame() {
        System.out.println("The game has ended. There are no more available houses or cards in the deck.");
        // Add any additional logic or messages to display at the end of the game
    }
}
