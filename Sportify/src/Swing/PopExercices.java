package Swing;

import Aliment.Aliments;
import ExercicesClass.*;
import Singleton.Utilisateur;

import javax.swing.*;
import java.awt.event.*;

public class PopExercices extends JDialog implements ActionListener {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spinnerScore;
    private JTextField textNom;
    private JRadioButton tempsOptionnelRadioButton;
    private JTextField textTpsMin;
    private JRadioButton forceRadioButton;
    private JRadioButton cardioRadioButton;
    private JTextField textMuscle;
    private JPanel Jpanel1;
    private JSpinner spinnerPoidsDistance;
    private JTextField TextTpsSec;

    public PopExercices() {

        setContentPane(contentPane);
        setTitle("Ajouter un exercices");
        setSize(400,300);

        

        buttonCancel.addActionListener(this);
        buttonOK.addActionListener(this);
        setModal(true);
        pack();
        setVisible(true);
    }

    private void onOK() {

       int temps =0 ;
        if(tempsOptionnelRadioButton.isSelected()) {
             temps = Integer.parseInt(textTpsMin.getText()) * 60 + Integer.parseInt(TextTpsSec.getText());
        }

        if(forceRadioButton.isSelected())
        {
            ExerciceForce E = new ExerciceForce(textNom.getText(),textMuscle.getText(),(int)spinnerScore.getValue(),temps,(int)spinnerPoidsDistance.getValue());
            Utilisateur.getInstance().addExerciceForce(E);
            System.out.println("dans l'ajout d'un ex de force ");
        }
        if(cardioRadioButton.isSelected())System.out.println(("merde")); // enleve ce ;
        {
            ExerciceCardio E = new ExerciceCardio(textNom.getText(),textMuscle.getText(),(int)spinnerScore.getValue(),temps,(int)spinnerPoidsDistance.getValue());
            Utilisateur.getInstance().addExerciceCardio(E);
            System.out.println("dans l'ajout d'un ex de cardio ");
        }
        dispose();
    }

    private void onCancel() {

        dispose();
    }

    public static void main(String[] args) {
        PopExercices dialog = new PopExercices();
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
