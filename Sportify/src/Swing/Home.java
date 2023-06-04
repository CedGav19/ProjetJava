package Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    private JButton faitButton;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JButton pasFaitButton;
    private JButton ajouterSéanceButton;
    private JScrollPane ScrollPanelObjAreal;
    private JScrollPane ScrolpanelOjectifRealise;
    private JPanel contentPane;

    public static void main(String[] args) {
        Home P = new Home();
    }

    Home(){
        setContentPane(contentPane);
        setVisible(true );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home");
        setSize(800,600);
        //Swing.Menu.Menu menubar= new Menu();
        //setJMenuBar(menubar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

   /* public void main()
    {
        Menu menubar= new Menu();
        setJMenuBar(menubar);
    }*/
}
