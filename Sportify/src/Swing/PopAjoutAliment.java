package Swing;

import Aliment.Aliments;
import Singleton.Utilisateur;

import javax.swing.*;
import java.awt.event.*;

public class PopAjoutAliment extends JDialog implements ActionListener {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldnom;
    private JSpinner spinnerproteine;
    private JSpinner spinnerscore;
    private JSpinner spinnerkcal;

    public PopAjoutAliment() {
        setContentPane(contentPane);
        setTitle("Ajouter un aliment");
        setSize(400,300);


        buttonCancel.addActionListener(this);
        buttonOK.addActionListener(this);

        setModal(true);
        pack();
        setVisible(true);
    }

    private void onOK() {


        Aliments A1 = new Aliments(textFieldnom.getText(),(int)spinnerkcal.getValue(),(int)spinnerproteine.getValue(),(int)spinnerscore.getValue());

        Utilisateur.getInstance().addAliment(A1);
        System.out.println(A1);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PopAjoutAliment dialog = new PopAjoutAliment();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonCancel)onCancel();
        if(e.getSource()==buttonOK)onOK();
    }
}
