package com.task;

import javax.swing.*;
import java.awt.event.*;
import java.math.BigInteger;

public class Form extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numberFld;
    private JLabel resultLbl;

    public Form() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        try {
            // get factorial from form's input
            BigInteger number = new BigInteger(numberFld.getText());
            // create ReversedFactorial object
            ReversedFactorial factorial = new ReversedFactorial();
            // set factorial
            factorial.setFactorial(number);
            // get reversed factorial
            resultLbl.setText("Reversed Factorial: " + factorial.getResult());
        } catch (Exception e) {
            resultLbl.setText("Something went wrong. Please try again.");
        } catch (Error e) {
            resultLbl.setText(e.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Form dialog = new Form();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
