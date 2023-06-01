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
        	player.setName(scanner.nextLine());
        	deck.shuffleDeck();
            Card card = deck.dealCard();
            if (card != null) {
                System.out.println("Dealt card: " + card);
                System.out.println("Choose a house (1-4) to place the card: ");
                int houseIndex = scanner.nextInt();
                if (houseIndex >= 1 && houseIndex <= 4) {
                    House house = houses[houseIndex - 1];
                    if (house.isAvailable()) {
                        house.setCurrentValue(house.getCurrentValue() + card.getCardValue());
                        house.calculateHouse(player);
                        System.out.println("Card placed in House " + houseIndex);
                        System.out.println("House value " + house.getCurrentValue());
                        System.out.println("Player points " + player.getPoints());
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
    }
    
    private static boolean allHousesClosed(House[] houses) {
        for (House house : houses) {
            if (house.isAvailable()) {
                return false;
            }
        }
        return true;
    }
}