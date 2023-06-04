package Swing;

import Bean.LogBean;
import Singleton.Utilisateur;
import Swing.Menu.Menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    private JButton faitButton;
    private JProgressBar progressBarProt;
    private JProgressBar progressBarCal;
    private JButton pasFaitButton;
    private JButton ajouterSéanceButton;
    private JScrollPane ScrollPanelObjAreal;
    private JScrollPane ScrolpanelOjectifRealise;
    private JPanel contentPane;
    private JLabel NomDeSeance;
    private JLabel Durée;
    private JScrollPane repasmangé;
    private JButton AjoutPlatMannge;
    private JButton enleverplatbutton;

    public static void main(String[] args) {
        Home P = new Home();
        P.setVisible(true);
    }

    Home(){
        /*mise en place du dossier log a partir de la technologie JavaBean */
        LogBean Lb = new LogBean();


        setContentPane(contentPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home");
        setSize(800,600);

        Swing.Menu.Menu menubar= new Menu();
        setJMenuBar(menubar);
        for (int i = 0; i < menubar.getMenu(0).getItemCount(); i++) {
            JMenuItem menu = menubar.getMenu(0).getItem(i);
            menu.addActionListener(this);
        }

        float prottot = 0;
        float kcaltot = 0;

        //Partie sur les plats mangé
        JPanel panelmange = new JPanel();
        panelmange.setLayout(new GridLayout(0,1));
        for( int i = 0 ; i < Utilisateur.getInstance().getListePlatsMange().size() ; i++)
        {
            panelmange.add(new JCheckBox(Utilisateur.getInstance().getListePlatsMange().get(i).toString()));
            //Utilisateur.getInstance().getListePlatsMange().get(i).getVecAliments()
            for(int j = 0 ; j < Utilisateur.getInstance().getListePlatsMange().get(i).getVecAliments().size(); j++)
            {
                prottot += Utilisateur.getInstance().getListePlatsMange().get(i).getVecAliments().get(j).getProteine();
                kcaltot += Utilisateur.getInstance().getListePlatsMange().get(i).getVecAliments().get(j).getKcal();
            }
        }
        repasmangé.setViewportView(panelmange);

        float protsouhaite = Utilisateur.getInstance().getPoidsUtilisateur()*3/2;

        float kcalSouhaite = 2000 + 5 * Utilisateur.getInstance().getTailleUtilisateur();

        progressBarProt.setValue((int)(prottot/protsouhaite*100));
        progressBarCal.setValue((int)(kcaltot/kcalSouhaite*100));

        //Partie sur les objectifs souhaité
        JPanel panelObjectifArealiser = new JPanel();
        panelObjectifArealiser.setLayout(new GridLayout(0,1));
        for( int i = 0 ; i < Utilisateur.getInstance().getMesObjectifs().size() ; i++)
        {
            panelObjectifArealiser.add(new JCheckBox(Utilisateur.getInstance().getMesObjectifs().get(i).toString()));
        }
        ScrollPanelObjAreal.setViewportView(panelObjectifArealiser);
        faitButton.addActionListener(this);

        //Partie sur les objectifs déjà fait
        JPanel panelObjectifRealise = new JPanel();
        panelObjectifRealise.setLayout(new GridLayout(0,1));
        for( int i = 0 ; i < Utilisateur.getInstance().getMesObjectifsReussis().size() ; i++)
        {
            panelObjectifRealise.add(new JCheckBox(Utilisateur.getInstance().getMesObjectifsReussis().get(i).toString()));
        }
        ScrolpanelOjectifRealise.setViewportView(panelObjectifRealise);
        pasFaitButton.addActionListener(this);

        AjoutPlatMannge.addActionListener(this);
    }

    private void changerenfait(){
        JPanel tmpPanel = (JPanel) ScrollPanelObjAreal.getViewport().getView();
        for (Component c : tmpPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0; i < Utilisateur.getInstance().getMesObjectifs().size(); i++) {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getMesObjectifs().get(i).toString())) {
                            /*Test2*/
                            Utilisateur.getInstance().validerObjectif(Utilisateur.getInstance().getMesObjectifs().get(i));
                            JPanel tmpPanel1 = (JPanel)ScrolpanelOjectifRealise.getViewport().getView() ;
                            int j = Utilisateur.getInstance().getMesObjectifsReussis().size()-1;
                            //TEst
                            System.out.println(Utilisateur.getInstance().getMesObjectifsReussis().get(j));
                            //
                            tmpPanel1.add(new JCheckBox(Utilisateur.getInstance().getMesObjectifsReussis().get(j).toString()));
                            //
                            tmpPanel.remove(checkBox);
                        }
                    }
                }

            }
        }
    }

    private void changerpasfait(){
        JPanel tmpPanel = (JPanel) ScrolpanelOjectifRealise.getViewport().getView();
        for (Component c : tmpPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0; i < Utilisateur.getInstance().getMesObjectifsReussis().size(); i++) {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getMesObjectifsReussis().get(i).toString())) {
                            /*Test2*/
                            Utilisateur.getInstance().devaliderObjectif(Utilisateur.getInstance().getMesObjectifsReussis().get(i));
                            JPanel tmpPanel1 = (JPanel)ScrollPanelObjAreal.getViewport().getView() ;
                            int j = Utilisateur.getInstance().getMesObjectifs().size()-1;
                            //TEst
                            System.out.println(Utilisateur.getInstance().getMesObjectifs().get(j));

                            tmpPanel1.add(new JCheckBox(Utilisateur.getInstance().getMesObjectifs().get(j).toString()));

                            tmpPanel.remove(checkBox);
                        }
                    }
                }

            }
        }
    }

    private void ajoutPlat(){
        float protsouhaite = Utilisateur.getInstance().getPoidsUtilisateur()*3/2;
        float kcalSouhaite = 2000 + 5 * Utilisateur.getInstance().getTailleUtilisateur();
        float prottot =0;
        float kcaltot = 0;

        int tmp = Utilisateur.getInstance().getListePlatsMange().size();
        PopAjoutPlatMange PAA= new PopAjoutPlatMange();
        if(tmp<Utilisateur.getInstance().getListePlatsMange().size())
        {
            JPanel tmpPanel = (JPanel)repasmangé.getViewport().getView() ;
            tmpPanel.add(new JCheckBox(Utilisateur.getInstance().getListePlatsMange().get(tmp).toString()));

            for(int j = 0 ; j < Utilisateur.getInstance().getListePlatsMange().get(tmp).getVecAliments().size(); j++)
            {

                prottot += Utilisateur.getInstance().getListePlatsMange().get(tmp).getVecAliments().get(j).getProteine();
                kcaltot += Utilisateur.getInstance().getListePlatsMange().get(tmp).getVecAliments().get(j).getKcal();
            }

            progressBarProt.setValue(progressBarProt.getValue() + (int)(prottot/protsouhaite*100));
            progressBarCal.setValue(progressBarCal.getValue() + (int)(kcaltot/kcalSouhaite*100));
        }
    }

    private void supprimerplat(){
        JPanel tmpPanel = (JPanel)repasmangé.getViewport().getView() ;
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
            setContentPane(new Home().getContentPane());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==faitButton)changerenfait();
        if(e.getSource()==pasFaitButton)changerpasfait();

        if(e.getSource()==AjoutPlatMannge)ajoutPlat();
        if(e.getSource()==enleverplatbutton)supprimerplat();

        if(e.getSource() instanceof JMenuItem)changementdepage((JMenuItem) e.getSource());

        this.getContentPane().repaint();
        this.getContentPane().revalidate();
    }


}
