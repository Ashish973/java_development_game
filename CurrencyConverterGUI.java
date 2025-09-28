import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverterGUI extends JFrame implements ActionListener {

    String[] currencies = { "USD", "EUR", "GBP", "JPY" };
    JComboBox<String> currencyList;
    JTextField inputField;
    JLabel resultLabel;
    JButton convertButton;

    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Enter amount:"), gbc);

        gbc.gridx = 1;
        inputField = new JTextField(10);
        add(inputField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Select currency:"), gbc);

        gbc.gridx = 1;
        currencyList = new JComboBox<>(currencies);
        add(currencyList, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        convertButton = new JButton("Convert to INR");
        convertButton.addActionListener(this);
        add(convertButton, gbc);

        gbc.gridy = 3;
        resultLabel = new JLabel("Result: ");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        add(resultLabel, gbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        try {
            double amount = Double.parseDouble(input);
            String selectedCurrency = (String) currencyList.getSelectedItem();
            double result = 0;

            switch (selectedCurrency) {
                case "USD":
                    result = amount * 83.20;
                    break;
                case "EUR":
                    result = amount * 89.75;
                    break;
                case "GBP":
                    result = amount * 104.45;
                    break;
                case "JPY":
                    result = amount * 0.56;
                    break;
            }

            resultLabel.setText("Result: " + amount + " " + selectedCurrency + " = " + result + " INR");

        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        new CurrencyConverterGUI();
    }
}
