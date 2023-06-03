package Swing;

import Objectifs.Objectif;
import Objectifs.ObjectifCardio;
import Objectifs.ObjectifForce;
import Objectifs.ObjectifPoids;
import Singleton.Utilisateur;

import javax.swing.*;
import java.awt.event.*;

public class PopObjectifs extends JDialog implements ActionListener{
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton cardioRadioButton;
    private JRadioButton forceRadioButton;
    private JRadioButton poidsRadioButton;
    private JTextField textFieldcardio;
    private JTextField textFieldforce;
    private JTextField textFieldpoids;
    private JTextField textfieldIntitulé;
    private JFormattedTextField textFieldDate;

    public PopObjectifs() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        //textFieldDate.setText("dd/mm/yyyy");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(cardioRadioButton);
        buttonGroup.add(forceRadioButton);
        buttonGroup.add(poidsRadioButton);

        buttonOK.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    private void onOK() {
        // add your code here
        /*Permet de vérifier si le format est valide mais je ne sais pas si je dois le mettre en place
        String test = textFieldDate.getText();
        String Format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(Format);
        */
        // Vérification du bouton radio sélectionné
        if (cardioRadioButton.isSelected())
        {
            String texte = textFieldcardio.getText();
            float temps = Float.parseFloat(texte);
            ObjectifCardio O1 = new ObjectifCardio(textfieldIntitulé.getText(),textFieldDate.getText(),temps);
            System.out.println(O1);
        } else
            if (forceRadioButton.isSelected())
            {
                String texte2 = textFieldforce.getText();
                float poids = Float.parseFloat(texte2);
                ObjectifForce O1 = new ObjectifForce(textfieldIntitulé.getText(),textFieldDate.getText(),poids);
                System.out.println(O1);
            }
            else
            {
                if (poidsRadioButton.isSelected())
                {
                    String texte3 = textFieldpoids.getText();
                    float poidssouhaite = Float.parseFloat(texte3);
                    ObjectifPoids O1 = new ObjectifPoids(textfieldIntitulé.getText(),textFieldDate.getText(),poidssouhaite);
                    System.out.println(O1);
                    Utilisateur.getInstance().ajouterObjectif( (Objectif)O1 );
                }
            }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== buttonOK)
        {
            onOK();
        }

        if(e.getSource() == buttonCancel)
        {
            onCancel();
        }
    }
}
