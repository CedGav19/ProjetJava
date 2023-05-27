package Swing;

import Singleton.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercices extends JFrame implements ActionListener {
    private JButton buttonAddExerciceForce;
    private JButton buttonRemoveExerciceForce;
    private JScrollPane scrollpaneExCardio;
    private JButton button2;
    private JButton button4;
    private JScrollPane ScrollpaneExForce;
    private JPanel contentpane;


    public static void main(String[] args) {
        Exercices E = new Exercices();
    }

    Exercices() {
        setContentPane(contentpane);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Exercice");
        setSize(800, 600);

        // partie exercicesForce
        JPanel PanelForce = new JPanel();
        PanelForce.setLayout(new GridLayout(0, 1));
        for (int i = 0; i< Utilisateur.getInstance().getExercicesForce().size(); i++)
        {
            PanelForce.add(new JCheckBox(Utilisateur.getInstance().getExercicesForce().get(i).toString()));
        }
        buttonAddExerciceForce.addActionListener(this);
        buttonRemoveExerciceForce.addActionListener(this);
        // parties Recette
        ScrollpaneExForce.setViewportView(PanelForce);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}