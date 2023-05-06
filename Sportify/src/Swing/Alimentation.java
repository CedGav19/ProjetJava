package Swing;

import javax.swing.*;
import Singleton.Utilisateur;

import java.awt.*;

public class Alimentation extends JFrame {
    private JButton button1;
    private JButton modifButton;
    private JButton button3;
    private JPanel contentPane;
    private JPanel panelListAliment;

    Alimentation()
    {
        setContentPane(contentPane);
        setVisible(true );
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Alimentation");
        setSize(800,600);
       JCheckBox C1 = new JCheckBox("bonbon");
        panelListAliment.add(C1);
        getContentPane().add(panelListAliment);

    }

    public static void main(String[] args) {
        Alimentation A = new Alimentation();



    }

}
