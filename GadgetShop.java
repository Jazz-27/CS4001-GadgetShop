import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Represents the gadget shop graphical user interface.
 * This class stores gadgets in an ArrayList and allows the user
 * to add mobiles and MP3 players, display all gadgets, make calls,
 * download music, and remove gadgets from the list.
 */
public class GadgetShop extends JFrame implements ActionListener {

    // Stores all gadgets added to the shop
    private ArrayList<Gadget> gadgets;

    // Text fields for gadget details and actions
    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    private JTextField creditField;
    private JTextField memoryField;
    private JTextField phoneNumberField;
    private JTextField durationField;
    private JTextField downloadSizeField;
    private JTextField displayNumberField;

    // Buttons for GUI actions
    private JButton addMobileButton;
    private JButton addMP3Button;
    private JButton clearButton;
    private JButton displayAllButton;
    private JButton makeCallButton;
    private JButton downloadMusicButton;
    private JButton removeGadgetButton;

    /**
     * Creates the GadgetShop GUI and initialises all components.
     */
    public GadgetShop() {
        super("Gadget Shop");

        gadgets = new ArrayList<Gadget>();

        setLayout(new BorderLayout(12, 12));

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(createGadgetDetailsPanel());
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(createTypeSpecificPanel());
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(createActionPanel());
        mainPanel.add(Box.createVerticalStrut(12));
        mainPanel.add(createButtonPanel());

        add(mainPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760, 520);
        setMinimumSize(new Dimension(760, 520));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Creates the panel that contains the main gadget details.
     *
     * @return the gadget details panel
     */
    private JPanel createGadgetDetailsPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 4, 10, 8));
        panel.setBorder(BorderFactory.createTitledBorder("Gadget Details"));

        modelField = new JTextField();
        priceField = new JTextField();
        weightField = new JTextField();
        sizeField = new JTextField();

        panel.add(new JLabel("Model"));
        panel.add(new JLabel("Price (£)"));
        panel.add(new JLabel("Weight (g)"));
        panel.add(new JLabel("Size"));

        panel.add(modelField);
        panel.add(priceField);
        panel.add(weightField);
        panel.add(sizeField);

        return panel;
    }

    /**
     * Creates the panel that contains type-specific inputs
     * for mobiles and MP3 players.
     *
     * @return the type-specific input panel
     */
    private JPanel createTypeSpecificPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 8));
        panel.setBorder(BorderFactory.createTitledBorder("Type-Specific Inputs"));

        creditField = new JTextField();
        memoryField = new JTextField();

        panel.add(new JLabel("Initial Credit (minutes)"));
        panel.add(new JLabel("Initial Memory"));

        panel.add(creditField);
        panel.add(memoryField);

        return panel;
    }

    /**
     * Creates the panel that contains fields for actions such as
     * making calls, downloading music, and selecting gadget index.
     *
     * @return the action input panel
     */
    private JPanel createActionPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 4, 10, 8));
        panel.setBorder(BorderFactory.createTitledBorder("Actions"));

        phoneNumberField = new JTextField();
        durationField = new JTextField();
        downloadSizeField = new JTextField();
        displayNumberField = new JTextField();

        panel.add(new JLabel("Phone Number"));
        panel.add(new JLabel("Call Duration"));
        panel.add(new JLabel("Download Size"));
        panel.add(new JLabel("Gadget Index"));

        panel.add(phoneNumberField);
        panel.add(durationField);
        panel.add(downloadSizeField);
        panel.add(displayNumberField);

        return panel;
    }

    /**
     * Creates the panel that contains all action buttons.
     *
     * @return the button panel
     */
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Commands"));

        addMobileButton = createButton("Add Mobile");
        addMP3Button = createButton("Add MP3");
        makeCallButton = createButton("Make A Call");
        downloadMusicButton = createButton("Download Music");
        displayAllButton = createButton("Display All");
        removeGadgetButton = createButton("Remove Gadget");
        clearButton = createButton("Clear");

        panel.add(addMobileButton);
        panel.add(addMP3Button);
        panel.add(makeCallButton);
        panel.add(downloadMusicButton);
        panel.add(displayAllButton);
        panel.add(removeGadgetButton);
        panel.add(clearButton);
        panel.add(new JLabel(""));

        return panel;
    }

    /**
     * Creates a button with consistent formatting and registers
     * this class as its action listener.
     *
     * @param text the button label
     * @return the configured button
     */
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setMargin(new Insets(8, 12, 8, 12));
        button.addActionListener(this);
        return button;
    }

    /**
     * Returns the model entered by the user.
     *
     * @return the model as a string
     */
    public String getModelInput() {
        return modelField.getText();
    }

    /**
     * Returns the price entered by the user.
     *
     * @return the price as a double
     */
    public double getPriceInput() {
        return Double.parseDouble(priceField.getText());
    }

    /**
     * Returns the weight entered by the user.
     *
     * @return the weight as an integer
     */
    public int getWeightInput() {
        return Integer.parseInt(weightField.getText());
    }

    /**
     * Returns the size entered by the user.
     *
     * @return the size as a string
     */
    public String getSizeInput() {
        return sizeField.getText();
    }

    /**
     * Returns the credit entered by the user.
     *
     * @return the credit as an integer
     */
    public int getCreditInput() {
        return Integer.parseInt(creditField.getText());
    }

    /**
     * Returns the memory entered by the user.
     *
     * @return the memory as an integer
     */
    public int getMemoryInput() {
        return Integer.parseInt(memoryField.getText());
    }

    /**
     * Returns the phone number entered by the user.
     *
     * @return the phone number as a string
     */
    public String getPhoneNumberInput() {
        return phoneNumberField.getText();
    }

    /**
     * Returns the duration entered by the user.
     *
     * @return the duration as an integer
     */
    public int getDurationInput() {
        return Integer.parseInt(durationField.getText());
    }

    /**
     * Returns the download size entered by the user.
     *
     * @return the download size as an integer
     */
    public int getDownloadSizeInput() {
        return Integer.parseInt(downloadSizeField.getText());
    }

    /**
     * Returns the display number entered by the user.
     * If the input is invalid, -1 is returned and an appropriate
     * dialog box message is shown.
     *
     * @return the display number, or -1 if invalid
     */
    public int getDisplayNumberInput() {
        int displayNumber = -1;

        try {
            displayNumber = Integer.parseInt(displayNumberField.getText());

            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a gadget index between 0 and " + (gadgets.size() - 1) + "."
                );
                displayNumber = -1;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Gadget index must be an integer.");
        }

        return displayNumber;
    }

    /**
     * Clears all text fields in the GUI.
     */
    public void clearTextFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
    }

    /**
     * Adds a new Mobile object to the ArrayList.
     */
    public void addMobile() {
        try {
            String model = getModelInput();
            double price = getPriceInput();
            int weight = getWeightInput();
            String size = getSizeInput();
            int credit = getCreditInput();

            Mobile mobile = new Mobile(model, price, weight, size, credit);
            gadgets.add(mobile);

            int index = gadgets.size() - 1;

            JOptionPane.showMessageDialog(this, "Mobile added successfully at index " + index + ".");
            System.out.println("Mobile added at index " + index + ".");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numeric values for price, weight and credit."
            );
        }
    }

    /**
     * Adds a new MP3 object to the ArrayList.
     */
    public void addMP3() {
        try {
            String model = getModelInput();
            double price = getPriceInput();
            int weight = getWeightInput();
            String size = getSizeInput();
            int memory = getMemoryInput();

            MP3 mp3 = new MP3(model, price, weight, size, memory);
            gadgets.add(mp3);

            int index = gadgets.size() - 1;

            JOptionPane.showMessageDialog(this, "MP3 player added successfully at index " + index + ".");
            System.out.println("MP3 player added at index " + index + ".");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numeric values for price, weight and memory."
            );
        }
    }

    /**
     * Displays all gadgets stored in the ArrayList.
     */
    public void displayAll() {
        if (gadgets.isEmpty()) {
            System.out.println("No gadgets in the shop.");
            return;
        }

        for (int i = 0; i < gadgets.size(); i++) {
            Gadget gadget = gadgets.get(i);

            System.out.println("Display Number: " + i);

            if (gadget instanceof Mobile) {
                System.out.println("Type: Mobile");
            } else if (gadget instanceof MP3) {
                System.out.println("Type: MP3 Player");
            } else {
                System.out.println("Type: Gadget");
            }

            gadget.display();
            System.out.println();
        }
    }

    /**
     * Makes a call using a selected Mobile object.
     */
    public void makeCall() {
        int displayNumber = getDisplayNumberInput();

        if (displayNumber != -1) {
            try {
                Gadget gadget = gadgets.get(displayNumber);
                Mobile mobile = (Mobile) gadget;

                String phoneNumber = getPhoneNumberInput();
                int duration = getDurationInput();

                mobile.makeCall(phoneNumber, duration);
            } catch (ClassCastException e) {
                JOptionPane.showMessageDialog(this, "Selected gadget is not a mobile phone.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid call duration.");
            }
        }
    }

    /**
     * Downloads music using a selected MP3 object.
     */
    public void downloadMusic() {
        int displayNumber = getDisplayNumberInput();

        if (displayNumber != -1) {
            try {
                Gadget gadget = gadgets.get(displayNumber);
                MP3 mp3 = (MP3) gadget;

                int downloadSize = getDownloadSizeInput();
                mp3.downloadMusic(downloadSize);
            } catch (ClassCastException e) {
                JOptionPane.showMessageDialog(this, "Selected gadget is not an MP3 player.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid download size.");
            }
        }
    }

    /**
     * Removes a gadget from the ArrayList using its display number.
     */
    public void removeGadget() {
        int displayNumber = getDisplayNumberInput();

        if (displayNumber != -1) {
            Gadget removedGadget = gadgets.remove(displayNumber);

            String gadgetType;

            if (removedGadget instanceof Mobile) {
                gadgetType = "Mobile";
            } else if (removedGadget instanceof MP3) {
                gadgetType = "MP3 player";
            } else {
                gadgetType = "Gadget";
            }

            JOptionPane.showMessageDialog(
                this,
                gadgetType + " removed successfully from index " + displayNumber + "."
            );

            System.out.println(gadgetType + " removed successfully from index " + displayNumber + ".");
        }
    }

    /**
     * Handles button click events.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMobileButton) {
            addMobile();
        } else if (e.getSource() == addMP3Button) {
            addMP3();
        } else if (e.getSource() == makeCallButton) {
            makeCall();
        } else if (e.getSource() == downloadMusicButton) {
            downloadMusic();
        } else if (e.getSource() == displayAllButton) {
            displayAll();
        } else if (e.getSource() == removeGadgetButton) {
            removeGadget();
        } else if (e.getSource() == clearButton) {
            clearTextFields();
        }
    }

    /**
     * Main method to launch the GadgetShop GUI.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new GadgetShop();
    }
}
