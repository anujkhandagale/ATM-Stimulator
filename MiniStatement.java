package bank.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener {

    String pinnumber;
    JButton back;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Bank Name
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 200, 20);
        add(bank);

        // Card Number
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        // Transaction History
        JLabel text = new JLabel();
        text.setBounds(20, 140, 400, 300);
        add(text);
        
        // Balance Label
        JLabel balance = new JLabel();
        balance.setBounds(20, 450, 300, 20);  // Correcting balance label position
        add(balance);

        // Back Button
        back = new JButton("Back");
        back.setBounds(150, 500, 100, 30);
        back.addActionListener(this);
        add(back);

        try {
            Conn conn = new Conn();
            int bal = 0;

            // Get the card number
            ResultSet rs = conn.s.executeQuery("SELECT * FROM login WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }

            // Get the transaction history and calculate balance
            rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            StringBuilder transactions = new StringBuilder("<html>");
            while (rs.next()) {
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount"));

                transactions.append(rs.getString("date")).append("&nbsp;&nbsp;||").append(type).append("&nbsp;&nbsp;||Rs ").append(amount).append("<br>");

                // Calculate balance
                if (type.equals("Deposit")) {
                    bal += amount;
                } else {
                    bal -= amount;
                }
            }
            transactions.append("</html>");
            text.setText(transactions.toString());

            // Set balance
            balance.setText("Your Current Account Balance is Rs : " + bal);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Frame properties
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    // Action handler for back button
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
