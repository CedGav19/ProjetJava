package Swing;

import javax.swing.*;
import Singleton.Utilisateur;
import Swing.Menu.Menu;

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
    private JButton ButtonAjoutPlatMange;
    private JButton ButtonSupPlatMange;


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

        Menu menubar= new Menu();
        setJMenuBar(menubar);
        for (int i = 0; i < menubar.getMenu(0).getItemCount(); i++) {
            JMenuItem menu = menubar.getMenu(0).getItem(i);
            menu.addActionListener(this);
        }

       // getRootPane().setDefaultButton(ButtonAjoutAliments); designe un bouton par defaut ou le curseur se trouvera
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
        ButtonAjoutPlatMange.addActionListener(this);
        ButtonSupPlatMange.addActionListener(this);


    }


    private void onAjoutAliments() {
        // add your code

        int tmp = Utilisateur.getInstance().getListeAliments().size();
        PopAjoutAliment PAA= new PopAjoutAliment();
        if(tmp<Utilisateur.getInstance().getListeAliments().size())
        {
            JPanel tmpPanel = (JPanel)ScrollPaneAliments.getViewport().getView() ;
            tmpPanel.add(new JCheckBox(Utilisateur.getInstance().getListeAliments().get(tmp).toString()));
        }
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
        int tmp = Utilisateur.getInstance().getMesRecette().size();
        PopAjoutPlat PAP1= new PopAjoutPlat();
        if(tmp<Utilisateur.getInstance().getMesRecette().size())
        {
            JPanel tmpPanel = (JPanel)ScrollPaneRecette.getViewport().getView() ;
            tmpPanel.add(new JCheckBox(Utilisateur.getInstance().getMesRecette().get(tmp).toString()));
        }
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
                            Utilisateur.getInstance().getMesRecette().remove(Utilisateur.getInstance().getMesRecette().get(i)) ;
                            tmpPanel.remove(checkBox);
                        }
                    }
                }

            }
        }

    }

    private void onAjoutPlatsMange()
    {
        int tmp = Utilisateur.getInstance().getListePlatsMange().size();
        PopAjoutPlatMange PAA= new PopAjoutPlatMange();
        if(tmp<Utilisateur.getInstance().getListePlatsMange().size())
        {
            JPanel tmpPanel = (JPanel)ScrollPanePlatsMange.getViewport().getView() ;
            tmpPanel.add(new JCheckBox(Utilisateur.getInstance().getListePlatsMange().get(tmp).toString()));
        }
    }
    private void onSupPlatsMange()
    {
        JPanel tmpPanel = (JPanel)ScrollPanePlatsMange.getViewport().getView() ;
        for (Component c :tmpPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0 ; i<Utilisateur.getInstance().getListePlatsMange().size();i++)
                    {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getListePlatsMange().get(i).toString()))
                        {
                            Utilisateur.getInstance().getListePlatsMange().remove(Utilisateur.getInstance().getListePlatsMange().get(i)) ;
                            tmpPanel.remove(checkBox);
                        }
                    }
                }
            }
        }

    }

    private void changementdepage(JMenuItem o)
    {

        setTitle(o.getText());
        if(o.getText()=="Exercice")
            setContentPane(new Exercices().getContentPane());
        if(o.getText()=="Alimentation")
        {
            setContentPane(new Alimentation().getContentPane());
        }
        if(o.getText()=="Profil")
        {
            setContentPane(new Profile().getContentPane());
        }
        if(o.getText()=="Home")
        {
           // setContentPane(new Home().getContentPane());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==ButtonAjoutAliments)onAjoutAliments();
        if(e.getSource()==ButtonSupAliments)onSupAliments();

        if(e.getSource()==ButtonAjoutPlat)onAjoutPlats();
        if(e.getSource()==ButtonSupPlat)onSupPlats();

        if(e.getSource()==ButtonAjoutPlatMange)onAjoutPlatsMange();
        if(e.getSource()==ButtonSupPlatMange)onSupPlatsMange();

        if(e.getSource() instanceof JMenuItem)changementdepage((JMenuItem) e.getSource());


       repaint();
       revalidate();
    }
}
