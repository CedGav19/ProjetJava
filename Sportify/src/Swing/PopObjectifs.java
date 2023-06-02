package Swing;

import Objectifs.Objectif;

import javax.swing.*;
import java.awt.event.*;

public class PopObjectifs extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton cardioRadioButton;
    private JRadioButton forceRadioButton;
    private JRadioButton poidsRadioButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField;
    private JFormattedTextField formattedTextField1;
    private JTextField textfieldIntitulé;
    private JFormattedTextField textFieldDate;

    public PopObjectifs() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        textFieldDate.setText("dd/mm/yyyy");

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
        // add your code here
        /*Permet de vérifier si le format est valide mais je ne sais pas si je dois le mettre en place
        String test = textFieldDate.getText();
        String Format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(Format);
        */

        //Test Romain
       // Objectif O1 = new Objectif(textfieldIntitulé.getText(),textFieldDate.getText());
      //  System.out.println(O1);
        //Romain fin
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PopObjectifs dialog = new PopObjectifs();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
