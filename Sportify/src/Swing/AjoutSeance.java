package Swing;

import ExercicesClass.Seance;
import Singleton.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjoutSeance extends JDialog implements ActionListener {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textNom;
    private JScrollPane scrollPaneExerciceForce;
    private JScrollPane scrollPaneExerciceCardio;

    public AjoutSeance() {
        setContentPane(contentPane);

        JPanel PanelForce = new JPanel();
        PanelForce.setLayout(new GridLayout(0, 1));
        for (int i = 0; i< Utilisateur.getInstance().getExercicesForce().size(); i++)
        {
            PanelForce.add(new JCheckBox(Utilisateur.getInstance().getExercicesForce().get(i).toString()));
        }
        scrollPaneExerciceForce.setViewportView(PanelForce);

        JPanel PanelCardio = new JPanel();
        PanelCardio.setLayout(new GridLayout(0, 1));
        for (int i = 0; i< Utilisateur.getInstance().getListeExercicesCardio().size(); i++)
        {
            PanelCardio.add(new JCheckBox(Utilisateur.getInstance().getListeExercicesCardio().get(i).toString()));
        }
        scrollPaneExerciceCardio.setViewportView(PanelCardio);

        buttonCancel.addActionListener(this);
        buttonOK.addActionListener(this);
        setModal(true);
        pack();
        setVisible(true);
    }

    private void onOK() {

        Seance maSeance = new Seance();
        maSeance.setNom(textNom.getText());
        JPanel tmpPanel = (JPanel) scrollPaneExerciceForce.getViewport().getView();
        for (Component c : tmpPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0; i < Utilisateur.getInstance().getExercicesForce().size(); i++) {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getExercicesForce().get(i).toString())) {
                            maSeance.ajouterExercice(Utilisateur.getInstance().getExercicesForce().get(i));

                        }
                    }
                }

            }
        }

        JPanel tmpPanel2 = (JPanel) scrollPaneExerciceCardio.getViewport().getView();
        for (Component c : tmpPanel2.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0; i < Utilisateur.getInstance().getListeExercicesCardio().size(); i++) {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getListeExercicesCardio().get(i).toString())) {
                            maSeance.ajouterExercice(Utilisateur.getInstance().getListeExercicesCardio().get(i));

                        }
                    }
                }

            }
        }

        Utilisateur.getInstance().addSeance(maSeance);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AjoutSeance dialog = new AjoutSeance();
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
