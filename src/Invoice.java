import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Invoice extends JFrame {

    private List<LineItem> lineItems;
    private JTextArea displayArea;

    public Invoice() {
        lineItems = new ArrayList<>();
        displayArea = new JTextArea();

        JButton addLineItemButton = new JButton("Add Line Item");
        addLineItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLineItem();
            }
        });

        JButton calculateTotalButton = new JButton("Calculate Total");
        calculateTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });

        JPanel panel = new JPanel();
        panel.add(addLineItemButton);
        panel.add(calculateTotalButton);

        add(panel, "South");
        add(new JScrollPane(displayArea), "Center");

        setTitle("Invoice Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addLineItem() {
        
        String itemName = JOptionPane.showInputDialog("Enter Product Name: ");
        double itemPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter Unit Price: "));
        int itemQuantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity: "));


        LineItem newItem = new LineItem(new Product(itemName, itemPrice), itemQuantity);
        lineItems.add(newItem);
        updateDisplay();
    }

    private void calculateTotal() {

        double totalAmount = 0.0;
        for (LineItem item : lineItems) {
            totalAmount += item.calculateTotal();
        }


        displayArea.setText("Total Amount Due: $" + totalAmount);
    }

    private void updateDisplay() {

        StringBuilder displayText = new StringBuilder("Line Items:\n");
        for (LineItem item : lineItems) {
            displayText.append(item.toString()).append("\n");
        }
        displayArea.setText(displayText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Invoice();
            }
        });
    }
}





