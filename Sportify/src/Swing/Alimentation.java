package Swing;

import javax.swing.*;
import Singleton.Utilisateur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alimentation extends JFrame {
    private JButton ButtonAjoutAliments;
    private JButton modifButton;
    private JButton button3;
    private JPanel contentPane;
    private JScrollPane ScrollPaneAliments;
    private JScrollPane ScrollPaneRecette;
    private JScrollPane ScrollPanePlatsMange;

    Alimentation()
    {
        setContentPane(contentPane);
        setVisible(true );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Alimentation");
        setSize(800,600);


        getRootPane().setDefaultButton(ButtonAjoutAliments);

       JPanel PanelAliments = new JPanel();
        PanelAliments.setLayout(new GridLayout(0, 1));
        for (int i = 0 ; i<Utilisateur.getInstance().getListeAliments().size();i++)
        {
            PanelAliments.add(new Checkbox(Utilisateur.getInstance().getListeAliments().get(i).toString()));
        }
       ScrollPaneAliments.setViewportView(PanelAliments);
        JPanel PanelRecette = new JPanel();
        PanelRecette.setLayout(new GridLayout(0, 1));
        for (int i = 0 ; i<Utilisateur.getInstance().getMesRecette().size();i++) {
            PanelRecette.add(new Checkbox(Utilisateur.getInstance().getMesRecette().get(i).toString()));
        }
        ScrollPaneRecette.setViewportView(PanelRecette);

        JPanel PanelPlatsMange = new JPanel();
        PanelPlatsMange.setLayout(new GridLayout(0, 1));
        for (int i = 0 ; i<Utilisateur.getInstance().getListePlatsMange().size();i++) {
            PanelPlatsMange.add(new Checkbox(Utilisateur.getInstance().getListePlatsMange().get(i).toString()));
        }
        ScrollPanePlatsMange.setViewportView(PanelPlatsMange);


        ButtonAjoutAliments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAjoutAliments();
            }
        });
    }

    public static void main(String[] args) {
        Alimentation A = new Alimentation();
    }

    private void onAjoutAliments() {
        // add your code here
        PopAjoutPlat PAP1= new PopAjoutPlat();
    }

}
