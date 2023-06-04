package Swing;

import Singleton.Utilisateur;

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

        float prottot = 10;
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

        float kcalSouhaite = Utilisateur.getInstance().getPoidsUtilisateur() * 1/3 * Utilisateur.getInstance().getTailleUtilisateur();

        System.out.println(protsouhaite);
        System.out.println(kcalSouhaite);

        System.out.println(prottot/protsouhaite);

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
                            ScrolpanelOjectifRealise.repaint();
                            ScrolpanelOjectifRealise.revalidate();
                            //
                            tmpPanel.remove(checkBox);

                            ScrollPanelObjAreal.repaint();
                            ScrollPanelObjAreal.revalidate();
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
                            ScrollPanelObjAreal.repaint();
                            ScrollPanelObjAreal.revalidate();
                            ScrolpanelOjectifRealise.repaint();
                            ScrolpanelOjectifRealise.revalidate();
                        }
                    }
                }

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==faitButton)changerenfait();
        if(e.getSource()==pasFaitButton)changerpasfait();
    }

   /* public void main()
    {
        Menu menubar= new Menu();
        setJMenuBar(menubar);
    }*/
}
