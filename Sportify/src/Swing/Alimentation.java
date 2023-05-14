package Swing;

import javax.swing.*;
import Singleton.Utilisateur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alimentation extends JFrame  implements ActionListener{
    private JButton ButtonAjoutAliments;
    private JButton ButtonSupAliments;
    private JPanel contentPane;
    private JScrollPane ScrollPaneAliments;
    private JScrollPane ScrollPaneRecette;
    private JScrollPane ScrollPanePlatsMange;
    private JButton ButtonAjoutPlat;
    private JButton ButtonSupPlat;


    public static void main(String[] args) {
        Alimentation A = new Alimentation();
    }

    Alimentation()
    {
        setContentPane(contentPane);
        setVisible(true );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Alimentation");
        setSize(800,600);

        getRootPane().setDefaultButton(ButtonAjoutAliments);
        // parties Aliments
       JPanel PanelAliments = new JPanel();
        PanelAliments.setLayout(new GridLayout(0, 1));
        for (int i = 0 ; i<Utilisateur.getInstance().getListeAliments().size();i++)
        {
            PanelAliments.add(new JCheckBox(Utilisateur.getInstance().getListeAliments().get(i).toString()));
        }
        ButtonAjoutAliments.addActionListener(this);
        ButtonSupAliments.addActionListener(this);
        // parties Recette
       ScrollPaneAliments.setViewportView(PanelAliments);
        JPanel PanelRecette = new JPanel();
        PanelRecette.setLayout(new GridLayout(0, 1));
        for (int i = 0 ; i<Utilisateur.getInstance().getMesRecette().size();i++) {
            PanelRecette.add(new JCheckBox(Utilisateur.getInstance().getMesRecette().get(i).toString()));
        }
        ButtonAjoutPlat.addActionListener(this);
        ButtonSupPlat.addActionListener(this);
        ScrollPaneRecette.setViewportView(PanelRecette);
        // parties RecetteMange
        JPanel PanelPlatsMange = new JPanel();
        PanelPlatsMange.setLayout(new GridLayout(0, 1));
        for (int i = 0 ; i<Utilisateur.getInstance().getListePlatsMange().size();i++) {
            PanelPlatsMange.add(new JCheckBox(Utilisateur.getInstance().getListePlatsMange().get(i).toString()));
        }
        ScrollPanePlatsMange.setViewportView(PanelPlatsMange);


    }


    private void onAjoutAliments() {
        // add your code here
        PopAjoutAliment PAA= new PopAjoutAliment();
    }
    private void onSupAliments()
    {
        JPanel tmpPanel = (JPanel)ScrollPaneAliments.getViewport().getView() ;
        for (Component c :tmpPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0 ; i<Utilisateur.getInstance().getListeAliments().size();i++)
                    {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getListeAliments().get(i).toString()))
                        {
                            Utilisateur.getInstance().getListeAliments().remove(Utilisateur.getInstance().getListeAliments().get(i)) ;
                            tmpPanel.remove(checkBox);
                        }
                    }
                }

            }
        }

        for (int i = 0 ; i<Utilisateur.getInstance().getListeAliments().size();i++)
        {
            System.out.println(Utilisateur.getInstance().getListeAliments().get(i));
        }
    }


    private void onAjoutPlats() {
        // add your code here
        PopAjoutPlat PAP1= new PopAjoutPlat();
    }
    private void onSupPlats()
    {
        JPanel tmpPanel = (JPanel)ScrollPaneRecette.getViewport().getView() ;
        for (Component c :tmpPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0 ; i<Utilisateur.getInstance().getMesRecette().size();i++)
                    {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getMesRecette().get(i).toString()))
                        {
                            Utilisateur.getInstance().getListeAliments().remove(Utilisateur.getInstance().getMesRecette().get(i)) ;
                            tmpPanel.remove(checkBox);
                        }
                    }
                }

            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==ButtonAjoutAliments)onAjoutAliments();
        if(e.getSource()==ButtonSupAliments)onSupAliments();

        if(e.getSource()==ButtonAjoutPlat)onAjoutPlats();
        if(e.getSource()==ButtonSupPlat)onSupPlats();


       repaint();
       revalidate();
    }
}
