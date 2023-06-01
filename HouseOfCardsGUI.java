import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HouseOfCardsGUI extends JFrame {
    private HouseOfCards game;
    private House[] houses;
    private Deck deck;
    private Player player;
    private JLabel cardLabel;

    public HouseOfCardsGUI() throws InvalidCardException {
        game = new HouseOfCards();
        houses = new House[4];
        for (int i = 0; i < 4; i++) {
            houses[i] = new House();
            game.addHouse(houses[i]);
        }

        deck = new Deck();
        game.addDeck(deck);

        player = new Player();
        game.addPlayer(player);

        setTitle("House of Cards");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cardLabel = new JLabel("Dealt card: ");
        add(cardLabel, BorderLayout.NORTH);
        add(createButtonsPanel(), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
					new HouseOfCardsGUI();
				} catch (InvalidCardException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton dealButton = new JButton("Deal Card");
        dealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deck.deckSize() > 0 && !allHousesClosed(houses)) {
                    deck.shuffleDeck();
                    Card card = deck.dealCard();
                    if (card != null) {
                        cardLabel.setText("Dealt card: " + card.getCardValue());
                        House suggestedHouse = getSuggestedHouse(houses, card);

                        if (suggestedHouse != null) {
                            int suggestedHouseIndex = getHouseIndex(houses, suggestedHouse);
                            System.out.println("Suggested house (House " + suggestedHouseIndex + "): " + suggestedHouse);
                        }

                        displayHouses(houses);
                        updateHouseValues();
                    }
                }
            }
        });

        JButton endButton = new JButton("End Game");
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endGame();
            }
        });

        JButton[] houseButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            int houseIndex = i;
            houseButtons[i] = new JButton("House " + (i + 1));
            houseButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (deck.deckSize() > 0 && !allHousesClosed(houses)) {
                        deck.shuffleDeck();
                        Card card = deck.dealCard();
                        if (card != null) {
                            cardLabel.setText("Dealt card: " + card.getCardValue());
                            House house = houses[houseIndex];
                            if (house.isAvailable()) {
                                if (otherAlternatives(house.getCurrentValue(), card.getCardValue())) {
                                    System.out.println("There are other free houses");
                                } else {
                                    house.setCurrentValue(house.getCurrentValue() + card.getCardValue());
                                    house.calculateHouse(player);
                                    System.out.println("Card placed in House " + (houseIndex + 1));
                                    System.out.println("House value " + house.getCurrentValue());
                                    System.out.println("Player points " + player.getPoints());
                                }
                            } else {
                                System.out.println("House " + (houseIndex + 1) + " is closed. Choose another house.");
                            }
                            displayHouses(houses);
                            updateHouseValues();
                        }
                    }
                }
            });
            panel.add(houseButtons[i]);
        }

        panel.add(dealButton);
        panel.add(endButton);
        return panel;
    }

    private boolean allHousesClosed(House[] houses) {
        for (House house : houses) {
            if (house.isAvailable()) {
                return false;
            }
        }
        return true;
    }

    private House getSuggestedHouse(House[] houses, Card card) {
        for (House house : houses) {
            int newValue = house.getCurrentValue() + card.getCardValue();
            if (newValue == House.MAX_VALUE) {
                return house;
            }
        }
        return null;
    }

    private boolean otherAlternatives(int house, int card) {
        int newValue = house + card;
        if (newValue > House.MAX_VALUE) {
            return true;
        }
        return false;
    }

    private int getHouseIndex(House[] houses, House targetHouse) {
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == targetHouse) {
                return i + 1;
            }
        }
        return -1; // If the target house is not found
    }

    private void endGame() {
        System.out.println("The game has ended. There are no more available houses or cards in the deck.");
        // Add any additional logic or messages to display at the end of the game
    }

    private void displayHouses(House[] houses) {
        System.out.println("Current Houses:");
        for (int i = 0; i < houses.length; i++) {
            System.out.println("House " + (i + 1) + ":");
            System.out.println("Value: " + houses[i].getCurrentValue());
//            System.out.println("Cards: " + houses[i].getCards());
            System.out.println();
        }
    }

    private void updateHouseValues() {
        // Update the GUI to reflect the current house values
    }
}
