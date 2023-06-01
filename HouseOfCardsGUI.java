////import javax.swing.*;
////import java.awt.*;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////import java.util.Scanner;
////
////public class HouseOfCardsGUI extends JFrame {
////private HouseOfCards game;
////private House[] houses;
////private Deck deck;
////private Player player;
////private JLabel cardLabel;
////private JTextField houseTextField;
////private JTextArea outputTextArea;
////
////public HouseOfCardsGUI() throws InvalidCardException {
////    game = new HouseOfCards();
////    houses = new House[4];
////    for (int i = 0; i < 4; i++) {
////        houses[i] = new House();
////        game.addHouse(houses[i]);
////    }
////    
////
////    deck = new Deck();
////    game.addDeck(deck);
////
////    player = new Player();
////    game.addPlayer(player);
////
////    setTitle("House of Cards");
////    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////    setPreferredSize(new Dimension(800, 600));
////    setLayout(new BorderLayout());
////
////    cardLabel = new JLabel("Dealt card: ");
////    add(cardLabel, BorderLayout.NORTH);
////
////    JPanel inputPanel = new JPanel();
////    inputPanel.setLayout(new FlowLayout());
////
////    JLabel nameLabel = new JLabel("Enter player name: ");
////    inputPanel.add(nameLabel);
////
////    JTextField nameTextField = new JTextField(10);
////    inputPanel.add(nameTextField);
////
////    JButton startButton = new JButton("Start Game");
////    startButton.addActionListener(new ActionListener() {
////        public void actionPerformed(ActionEvent e) {
////            String playerName = nameTextField.getText();
////            player.setName(playerName);
////            nameTextField.setEnabled(false);
////            startButton.setEnabled(false);
////            playGame();
////        }
////    });
////    inputPanel.add(startButton);
////
////    JLabel houseLabel = new JLabel("Choose a house (1-4) to place the card: ");
////    inputPanel.add(houseLabel);
////
////    houseTextField = new JTextField(5);
////    inputPanel.add(houseTextField);
////
////    JButton placeButton = new JButton("Place Card"); 
////    placeButton.addActionListener(new ActionListener() {
////        public void actionPerformed(ActionEvent e) {
////            int houseIndex = Integer.parseInt(houseTextField.getText());
////            if (houseIndex >= 1 && houseIndex <= 4) {
////                House house = houses[houseIndex - 1];
////                if (house.isAvailable()) {
////                    Card card = deck.dealCard();
////                    if (card != null) {
////                    	cardLabel.setText("Dealt card: " + card);
////                    	
////                        outputTextArea.append("Card placed in House " + houseIndex + "\n");                       
////                        outputTextArea.append("House "+ houseIndex + " value: " + house.getCurrentValue() + "\n");
////                        outputTextArea.append("Player points: " + player.getPoints() + "\n");
////                        outputTextArea.append("Deck size: "+ deck.deckSize() + "\n");
////                        outputTextArea.append("\n");
////                        house.setCurrentValue(house.getCurrentValue() + card.getCardValue());
////                        house.calculateHouse(player);
////                        
////                        
////                        
////                        
////                        if (deck.deckSize() == 0 || allHousesClosed()) {
////                            endGame();
////                        }
////                    }
////                } else {
////                    outputTextArea.append("House " + houseIndex + " is closed. Choose another house.\n");
////                }
////            } else {
////                outputTextArea.append("Invalid house index. Choose a number between 1 and 4.\n");
////            }
////            houseTextField.setText("");
////        }
////
////    });
////    
////    inputPanel.add(placeButton);
////
////    add(inputPanel, BorderLayout.CENTER);
////
////    outputTextArea = new JTextArea();
////    outputTextArea.setEditable(false);
////    JScrollPane scrollPane = new JScrollPane(outputTextArea);
////    scrollPane.setPreferredSize(new Dimension(400, 200));
////    add(scrollPane, BorderLayout.SOUTH);
////
////    pack();
////    setVisible(true);
////}
////
////private boolean allHousesClosed() {
////    for (House house : houses) {
////        if (house.isAvailable()) {
////            return false;
////        }
////    }
////    return true;
////}
////
////private void endGame() {
////    houseTextField.setEnabled(false);
////    outputTextArea.append("\nGame Over!\n");
////    if (player.getPoints() > 0) {
////        outputTextArea.append("Congratulations! You earned " + player.getPoints() + " points.\n");
////    } else {
////        outputTextArea.append("Sorry, you lost. No points earned.\n");
////    }
////}
////
////private void playGame() {
////    deck.shuffleDeck();
////    Card card = deck.dealCard();
////    cardLabel.setText("Dealt card: " + card);
////}
////
////public static void main(String[] args) throws InvalidCardException {
////    SwingUtilities.invokeLater(new Runnable() {
////        public void run() {
////            try {
////                new HouseOfCardsGUI();
////            } catch (InvalidCardException e) {
////                e.printStackTrace();
////            }
////        }
////    });
////}
////}
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Scanner;
//
//public class HouseOfCardsGUI extends JFrame {
//    private HouseOfCards game;
//    private House[] houses;
//    private Deck deck;
//    private Player player;
//    private JLabel cardLabel;
//    private JTextField houseTextField;
//    private JTextArea outputTextArea;
//
//    public HouseOfCardsGUI() throws InvalidCardException {
//        game = new HouseOfCards();
//        houses = new House[4];
//        for (int i = 0; i < 4; i++) {
//            houses[i] = new House();
//            game.addHouse(houses[i]);
//        }
//
//        deck = new Deck();
//        game.addDeck(deck);
//
//        player = new Player();
//        game.addPlayer(player);
//
//        setTitle("House of Cards");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setPreferredSize(new Dimension(800, 600));
//        setLayout(new BorderLayout());
//
//        cardLabel = new JLabel("Dealt card: ");
//        add(cardLabel, BorderLayout.NORTH);
//
//        JPanel inputPanel = new JPanel();
//        inputPanel.setLayout(new FlowLayout());
//
//        JLabel nameLabel = new JLabel("Enter player name: ");
//        inputPanel.add(nameLabel);
//
//        JTextField nameTextField = new JTextField(10);
//        inputPanel.add(nameTextField);
//
//        JButton startButton = new JButton("Start Game");
//        startButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String playerName = nameTextField.getText();
//                player.setName(playerName);
//                nameTextField.setEnabled(false);
//                startButton.setEnabled(false);
//                playGame();
//            }
//        });
//        inputPanel.add(startButton);
//
//        JLabel houseLabel = new JLabel("Choose a house (1-4) to place the card: ");
//        inputPanel.add(houseLabel);
//
//        houseTextField = new JTextField(5);
//        inputPanel.add(houseTextField);
//
//        JButton placeButton = new JButton("Place Card");
//        placeButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            	Card card = deck.dealCard();
//                int houseIndex = Integer.parseInt(houseTextField.getText());
//                if (houseIndex >= 1 && houseIndex <= 4) {
//                    House house = houses[houseIndex - 1];
//                    house.setCurrentValue(house.getCurrentValue() + card.getCardValue());
//                    house.calculateHouse(player);
//                    if (house.isAvailable()) {
//                        
//                        
//                        if (card != null) {
//                            cardLabel.setText("Dealt card: " + card);
//                            
//                            
//                            outputTextArea.append("Card placed in House " + houseIndex + "\n");
//                            outputTextArea.append("House " + houseIndex + " value: " + house.getCurrentValue() + "\n");
//                            outputTextArea.append("Player points: " + player.getPoints() + "\n");
//                            outputTextArea.append("Deck size: " + deck.deckSize() + "\n");
//                            outputTextArea.append("\n");
//                            
//                            
//                            
//                            
//                            
//                            
//                            
////                            for (int i = 0; i < houses.length; i++) {
////                                House h = houses[i];
////                                outputTextArea.append("House " + (i + 1) + " value: " + h.getCurrentValue() + "\n");
////                                
////                            }
////                            outputTextArea.append("\n");
//                            
//
//                            if (deck.deckSize() == 0 || allHousesClosed()) {
//                                endGame();
//                            }
//                        }
//                    } else {
//                        outputTextArea.append("House " + houseIndex + " is closed. Choose another house.\n");
//                    }
//                } else {
//                    outputTextArea.append("Invalid house index. Choose a number between 1 and 4.\n");
//                }
//                houseTextField.setText("");
//            }
//            
//
//        });
//
//        inputPanel.add(placeButton);
//
//        add(inputPanel, BorderLayout.CENTER);
//
//        outputTextArea = new JTextArea();
//        outputTextArea.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(outputTextArea);
//        scrollPane.setPreferredSize(new Dimension(400, 200));
//        add(scrollPane, BorderLayout.SOUTH);
//
//        pack();
//        setVisible(true);
//    }
//
//    private boolean allHousesClosed() {
//        for (House house : houses) {
//            if (house.isAvailable()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void endGame() {
//        houseTextField.setEnabled(false);
//        outputTextArea.append("\nGame Over!\n");
//        if (player.getPoints() > 0) {
//            outputTextArea.append("Congratulations! You earned " + player.getPoints() + " points.\n");
//        } else {
//            outputTextArea.append("Sorry, you lost. No points earned.\n");
//        }
//    }
//
//    private void playGame() {
//        deck.shuffleDeck();
//        Card card = deck.dealCard();
//        cardLabel.setText("Dealt card: " + card);
//        
//    }
//
//    public static void main(String[] args) throws InvalidCardException {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new HouseOfCardsGUI();
//                } catch (InvalidCardException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//}

