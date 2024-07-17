import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class CalculatorApp extends JFrame {
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, moduloButton, clearButton;

    public CalculatorApp() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Panels
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JPanel buttonPanel = new JPanel(new GridLayout(4, 2));

        // Text Fields
        firstNumberField = new JTextField();
        secondNumberField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        // Buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        moduloButton = new JButton("%");
        clearButton = new JButton("Clear");

        // Adding components to panels
        inputPanel.add(new JLabel("First number:"));
        inputPanel.add(firstNumberField);
        inputPanel.add(new JLabel("Second number:"));
        inputPanel.add(secondNumberField);
        inputPanel.add(new JLabel("Result:"));
        inputPanel.add(resultField);

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(moduloButton);
        buttonPanel.add(clearButton);

        // Adding panels to main panel
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adding main panel to frame
        add(mainPanel);

        // Button action listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('+');
            }
        });
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('-');
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('*');
            }
        });
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('/');
            }
        });
        moduloButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('%');
            }
        });
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
            }
        });

        setVisible(true);
    }

    // Method to perform calculation based on operator
    private void calculate(char operator) {
        try {
            double firstNumber = Double.parseDouble(firstNumberField.getText());
            double secondNumber = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    if (secondNumber != 0)
                        result = firstNumber / secondNumber;
                    else
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero");
                    break;
                case '%':
                    if (secondNumber != 0)
                        result = firstNumber % secondNumber;
                    else
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero");
                    break;
            }

            resultField.setText(Double.toString(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorApp();
            }
        });
    }
}
