import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlightBookingSystem extends JFrame implements ActionListener {

    String[] flights = {"AI101 - Delhi to Mumbai", "AI202 - Mumbai to Bangalore", "AI303 - Bangalore to Chennai","AI305 - Bhuvneshwar to Delhi"};
    JComboBox<String> flightList;
    JRadioButton economy, business;
    JTextField nameField, seatField;
    ButtonGroup seatClassGroup;
    JButton bookButton;

    public FlightBookingSystem() {
        setTitle("Flight Booking System");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Passenger Name:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(15);
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Select Flight:"), gbc);

        gbc.gridx = 1;
        flightList = new JComboBox<>(flights);
        add(flightList, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Seat Class:"), gbc);

        gbc.gridx = 1;
        economy = new JRadioButton("Economy", true);
        business = new JRadioButton("Business");
        seatClassGroup = new ButtonGroup();
        seatClassGroup.add(economy);
        seatClassGroup.add(business);

        JPanel seatPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        seatPanel.add(economy);
        seatPanel.add(business);
        add(seatPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Seat Number:"), gbc);

        gbc.gridx = 1;
        seatField = new JTextField(10);
        add(seatField, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        bookButton = new JButton("Book Flight");
        bookButton.addActionListener(this);
        add(bookButton, gbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText().trim();
        String flight = (String) flightList.getSelectedItem();
        String seatClass = economy.isSelected() ? "Economy" : "Business";
        String seatNumber = seatField.getText().trim();

        if (name.isEmpty() || seatNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String message = "Booking Confirmed!\n\n" +
                         "Passenger: " + name + "\n" +
                         "Flight: " + flight + "\n" +
                         "Class: " + seatClass + "\n" +
                         "Seat No: " + seatNumber + "\n" +
                         "Payment: Successful ✅";

        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);

        nameField.setText("");
        seatField.setText("");
        flightList.setSelectedIndex(0);
        economy.setSelected(true);
    }

    public static void main(String[] args) {
        new FlightBookingSystem();
    }
}
