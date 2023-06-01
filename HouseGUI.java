//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class HouseGUI extends JFrame {
//    private JTextField textField1;
//    private JTextField textField2;
//    private JLabel house1Label;
//    private JLabel house2Label;
//    private JLabel house3Label;
//    private JLabel house4Label;
//    private JLabel nameLabel;
//
//    public HouseGUI() {
//        // Set the size of the JFrame to 1/4 of the screen
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = screenSize.width / 2;
//        int height = screenSize.height / 2;
//        setSize(width, height);
//
//        // Center the JFrame on the screen
//        setLocationRelativeTo(null);
//
//        // Set the layout manager
//        setLayout(new BorderLayout());
//
//        // Create the top panel with text fields and buttons
//        JPanel topPanel = new JPanel(new GridBagLayout());
//
//        // Create GridBagConstraints for component placement
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.insets = new Insets(5, 5, 5, 5);
//
//        // Create the labels for empty spaces
//        JLabel nameLabelPrompt = new JLabel("Please enter your name:");
//        JLabel houseLabelPrompt = new JLabel("Choose a house to place your card (House 1-4):");
//
//        // Create the first text field
//        textField1 = new JTextField(10);
//
//        // Create the second text field
//        textField2 = new JTextField(10);
//// Create the "Submit" button
//        JButton submitButton = new JButton("Submit");
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String enteredName = textField1.getText();
//                nameLabel.setText("Player: " + enteredName);
//            }
//        });
//
//        // Create the "Place Card" button
//        JButton placeCardButton = new JButton("Place Card");
//
//        // Add the labels, text fields, and buttons to the top panel
//        topPanel.add(nameLabelPrompt, gbc);
//        gbc.gridy++;
//        topPanel.add(textField1, gbc);
//        gbc.gridy++;
//        topPanel.add(submitButton, gbc);
//        gbc.gridy++;
//        topPanel.add(houseLabelPrompt, gbc);
//        gbc.gridy++;
//        topPanel.add(textField2, gbc);
//        gbc.gridy++;
//        topPanel.add(placeCardButton, gbc);
//
//        // Add the top panel to the JFrame
//        add(topPanel, BorderLayout.NORTH);
//
//        // Create the panel for the houses
//        JPanel housePanel = new JPanel();
//        housePanel.setLayout(new GridLayout(1, 4));
//
//        // Create the house labels
//        house1Label = new JLabel("House 1");
//        house2Label = new JLabel("House 2");
//        house3Label = new JLabel("House 3");
//        house4Label = new JLabel("House 4");
//
//        // Set the house labels to be centered and bold
//        house1Label.setHorizontalAlignment(SwingConstants.CENTER);
//        house2Label.setHorizontalAlignment(SwingConstants.CENTER);
//        house3Label.setHorizontalAlignment(SwingConstants.CENTER);
//        house4Label.setHorizontalAlignment(SwingConstants.CENTER);
//
//        Font boldFont = house1Label.getFont().deriveFont(Font.BOLD);
//        house1Label.setFont(boldFont);
//        house2Label.setFont(boldFont);
//        house3Label.setFont(boldFont);
//        house4Label.setFont(boldFont);
//
//        // Add the house labels to the panel
//        housePanel.add(house1Label);
//        housePanel.add(house2Label);
//        housePanel.add(house3Label);
//        housePanel.add(house4Label);
//
//        // Add the house panel to the JFrame
//        add(housePanel, BorderLayout.CENTER);
//
//        // Create the label for displaying the entered name
//        nameLabel = new JLabel();
//
//        // Add the name label below the second text field
//        add(nameLabel, BorderLayout.SOUTH);
//
//        // Set JFrame properties
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("House GUI");
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        // Create the GUI on the Event Dispatch Thread
//        SwingUtilities.invokeLater(HouseGUI::new);
//    }
//}
//
