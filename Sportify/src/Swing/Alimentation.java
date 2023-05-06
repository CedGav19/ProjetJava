package Swing;

import javax.swing.*;
import Singleton.Utilisateur;

import java.awt.*;
import Singleton.Utilisateur;

public class Alimentation extends JFrame {
    private JButton button1;
    private JButton modifButton;
    private JButton button3;
    private JPanel contentPane;
    private JScrollPane ScrollPaneAliments;

    Alimentation()
    {
        setContentPane(contentPane);
        setVisible(true );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Alimentation");
        setSize(800,600);
       JCheckBox C1 = new JCheckBox("bonbon");
       JPanel P1 = new JPanel();
        P1.add(new Checkbox(Utilisateur.getInstance().getListeAliments().get(0).toString()));
       ScrollPaneAliments.setViewportView(P1);

    }

    public static void main(String[] args) {
        Alimentation A = new Alimentation();



    }

}
