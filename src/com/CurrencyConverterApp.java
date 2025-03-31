package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterApp extends JFrame {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> fromCurrency, toCurrency;
    private JTextField amountField;
    private JLabel resultLabel;

    public CurrencyConverterApp() {
        setTitle("Currency Converter");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        setLocationRelativeTo(null); // Center window

        // Currency selection
        String[] currencies = {"USD", "EUR", "INR", "GBP", "AUD", "CAD", "JPY", "CNY"};
        fromCurrency = new JComboBox<>(currencies);
        toCurrency = new JComboBox<>(currencies);

        // Amount field
        amountField = new JTextField();

        // Convert button
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        // Result label
        resultLabel = new JLabel("Converted Amount: ");

        // Add components to frame
        add(new JLabel("From Currency:"));
        add(fromCurrency);
        add(new JLabel("To Currency:"));
        add(toCurrency);
        add(new JLabel("Amount:"));
        add(amountField);
        add(convertButton);
        add(resultLabel);

        setVisible(true);
    }

    private void convertCurrency() {
        try {
            String from = fromCurrency.getSelectedItem().toString();
            String to = toCurrency.getSelectedItem().toString();
            double amount = Double.parseDouble(amountField.getText());

            // Fetch exchange rate from the service class
            double rate = CurrencyConverterService.getExchangeRate(from, to);
            double convertedAmount = amount * rate;

            // Display result
            resultLabel.setText("Converted Amount: " + String.format("%.2f", convertedAmount) + " " + to);
        } catch (Exception e) {
            resultLabel.setText("Error: " + e.getMessage());
        }
    }
}
