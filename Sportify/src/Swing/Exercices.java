package Swing;

import Singleton.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercices extends JFrame implements ActionListener {
    private JButton buttonAddExercice;
    private JScrollPane scrollpaneExCardio;
    private JButton buttonRemoveExercice;
    private JScrollPane ScrollpaneExForce;
    private JPanel contentpane;
    private JScrollPane ScrollPaneSeance;
    private JButton buttonAddseance;
    private JButton buttonRemoveSeance;


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


        JPanel PanelSeance = new JPanel();
        PanelSeance.setLayout(new GridLayout(0, 1));
        for (int i = 0; i< Utilisateur.getInstance().getMesSeances().size(); i++)
        {
            PanelSeance.add(new JCheckBox(Utilisateur.getInstance().getMesSeances().get(i).toString()));
        }
        ScrollpaneExForce.setViewportView(PanelSeance);
        buttonRemoveSeance.addActionListener(this);
        buttonAddseance.addActionListener(this);

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
    private void onSupExercice()
    {
        JPanel tmpPanel = (JPanel)ScrollpaneExForce.getViewport().getView() ;
        for (Component c :tmpPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0 ; i<Utilisateur.getInstance().getExercicesForce().size();i++)
                    {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getExercicesForce().get(i).toString()))
                        {
                            Utilisateur.getInstance().removeExerciceForce(Utilisateur.getInstance().getExercicesForce().get(i)); ;
                            tmpPanel.remove(checkBox);
                        }
                    }
                }

            }
        }

        JPanel tmpPanel2 = (JPanel)scrollpaneExCardio.getViewport().getView() ;
        for (Component c :tmpPanel2.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0 ; i<Utilisateur.getInstance().getListeExercicesCardio().size();i++)
                    {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getListeExercicesCardio().get(i).toString()))
                        {
                            Utilisateur.getInstance().removeExerciceCardio(Utilisateur.getInstance().getListeExercicesCardio().get(i)); ;
                            tmpPanel2.remove(checkBox);
                        }
                    }
                }

            }
        }

    }

    private void onAddSeance()
    {
        int tmp = Utilisateur.getInstance().getListeAliments().size();
        AjoutSeance PAS= new AjoutSeance();
        if(tmp<Utilisateur.getInstance().getListeAliments().size())
        {
            JPanel tmpPanel = (JPanel)ScrollPaneSeance.getViewport().getView() ;
            tmpPanel.add(new JCheckBox(Utilisateur.getInstance().getListeAliments().get(tmp).toString()));
        }
    }
    private void onRemoveSeance(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonAddExercice)onAddExercice();
        if ( e.getSource()==buttonRemoveExercice)onSupExercice();
        if ( e.getSource()==buttonAddseance)onAddSeance();
        if ( e.getSource()==buttonRemoveSeance)onRemoveSeance();
        repaint();
        revalidate();
    }
}