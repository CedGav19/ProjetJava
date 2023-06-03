package Swing;

import Singleton.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercices extends JFrame implements ActionListener {
    private JButton buttonAddExercice;
    private JButton buttonRemoveExerciceForce;
    private JScrollPane scrollpaneExCardio;
    private JButton buttonRemoveExercice;
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
        ScrollpaneExForce.setViewportView(PanelForce);

        JPanel PanelCardio = new JPanel();
        PanelCardio.setLayout(new GridLayout(0, 1));
        for (int i = 0; i< Utilisateur.getInstance().getListeExercicesCardio().size(); i++)
        {
            PanelCardio.add(new JCheckBox(Utilisateur.getInstance().getListeExercicesCardio().get(i).toString()));
        }
        buttonAddExercice.addActionListener(this);
        buttonRemoveExercice.addActionListener(this);
        // parties Recette
        scrollpaneExCardio.setViewportView(PanelCardio);

    }

   private void onAddExercice()
   {
       int tmpEF = Utilisateur.getInstance().getExercicesForce().size();
       int tmpEC = Utilisateur.getInstance().getListeExercicesCardio().size();
       PopExercices PE = new PopExercices();
       if(tmpEF<Utilisateur.getInstance().getExercicesForce().size())
       {
           JPanel tmpPanel = (JPanel)ScrollpaneExForce.getViewport().getView() ;
           tmpPanel.add(new JCheckBox(Utilisateur.getInstance().getExercicesForce().get(tmpEF).toString()));
       }
       if(tmpEC<Utilisateur.getInstance().getListeExercicesCardio().size())
       {
           JPanel tmpPanel = (JPanel)scrollpaneExCardio.getViewport().getView() ;
           tmpPanel.add(new JCheckBox(Utilisateur.getInstance().getListeExercicesCardio().get(tmpEC).toString()));
       }

   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonAddExercice)onAddExercice();


        repaint();
        revalidate();
    }
}