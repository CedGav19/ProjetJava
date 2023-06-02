package Swing;

import javax.swing.*;
import java.awt.event.*;

public class PopExercices extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spinner1;
    private JTextField textField1;
    private JRadioButton tempsOptionnelRadioButton;
    private JTextField textField2;
    private JRadioButton forceRadioButton;
    private JRadioButton cardioRadioButton;
    private JTextField textField3;

    public PopExercices() {

        setContentPane(contentPane);
        setTitle("Ajouter un exercices");
        setSize(400,300);



        setModal(true);
        pack();
        setVisible(true);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PopExercices dialog = new PopExercices();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
