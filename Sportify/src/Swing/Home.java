package Swing;

import Bean.LogBean;
import Singleton.Utilisateur;
import Swing.Menu.Menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
    private JLabel Duree;
    private JScrollPane repasmangé;
    private JButton AjoutPlatMannge;
    private JButton enleverplatbutton;
    private JScrollPane dernSeancescroll;

    public static void main(String[] args) {
        Home P = new Home();
        P.setVisible(true);
    }

   public Home(){
        //region mise en place du dossier log a partir de la technologie JavaBean */
        LogBean Lb = new LogBean();
        Properties P = new Properties() ;
        try {

            P.load(new FileInputStream(System.getProperty("user.dir")+"\\Sportify.properties"));
            P.list(System.out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion


        setContentPane(contentPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home");
        setSize(800,600);

        Menu menubar= new Menu();
        menubar.add(new JMenu((String) P.get("Langue")));
        menubar.add(new JMenu((String) P.get("Mesure")));
        setJMenuBar(menubar);
        for (int i = 0; i < menubar.getMenu(0).getItemCount(); i++) {
            JMenuItem menu = menubar.getMenu(0).getItem(i);
            menu.addActionListener(this);
        }

        lastSeance();
        ajouterSéanceButton.addActionListener(this);

        //Partie sur les plats mangé
        JPanel panelmange = new JPanel();
        panelmange.setLayout(new GridLayout(0,1));
        for( int i = 0 ; i < Utilisateur.getInstance().getListePlatsMange().size() ; i++)
        {
            panelmange.add(new JCheckBox(Utilisateur.getInstance().getListePlatsMange().get(i).toString()));
        }
        repasmangé.setViewportView(panelmange);

        setPrgogressbar();

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
        enleverplatbutton.addActionListener(this);



        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    Utilisateur.getInstance().Save();
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
                dispose(); // Ferme la fenêtre
                System.exit(0); // Termine l'application

            }
        });

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
        int tmp = Utilisateur.getInstance().getListePlatsMange().size();
        PopAjoutPlatMange PAA= new PopAjoutPlatMange();
        if(tmp<Utilisateur.getInstance().getListePlatsMange().size())
        {
            JPanel tmpPanel = (JPanel)repasmangé.getViewport().getView() ;
            tmpPanel.add(new JCheckBox(Utilisateur.getInstance().getListePlatsMange().get(tmp).toString()));
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

    private void setPrgogressbar(){
        float prottot = 0;
        float kcaltot = 0;
        float protsouhaite = Utilisateur.getInstance().getPoidsUtilisateur()*3/2;
        float kcalSouhaite = 2000 + 5 * Utilisateur.getInstance().getTailleUtilisateur();
        for( int i = 0 ; i < Utilisateur.getInstance().getListePlatsMange().size() ; i++)
        {
            for(int j = 0 ; j < Utilisateur.getInstance().getListePlatsMange().get(i).getVecAliments().size(); j++)
            {
                prottot += Utilisateur.getInstance().getListePlatsMange().get(i).getVecAliments().get(j).getProteine();
                kcaltot += Utilisateur.getInstance().getListePlatsMange().get(i).getVecAliments().get(j).getKcal();
            }
        }

        progressBarProt.setValue((int)(prottot/protsouhaite*100));
        progressBarCal.setValue((int)(kcaltot/kcalSouhaite*100));
    }

    private void lastSeance(){
        NomDeSeance.setText(Utilisateur.getInstance().getLastSeance().getNom());
        Duree.setText("Durée: " + Utilisateur.getInstance().getLastSeance().tempsTotal() + " minutes");

        JPanel derseance = new JPanel();
        derseance.setLayout(new GridLayout(0,1));
        for( int i = 0 ; i < Utilisateur.getInstance().getLastSeance().getVecExercices().size() ; i++)
        {
            derseance.add(new JLabel(Utilisateur.getInstance().getLastSeance().getVecExercices().get(i).toString()));
        }
        dernSeancescroll.setViewportView(derseance);
    }

    public void onAddSeance(){
        int tmp = Utilisateur.getInstance().getMesSeances().size();
        AjoutSeance POS = new AjoutSeance();
        if(tmp<Utilisateur.getInstance().getMesSeances().size())
        {
            lastSeance();
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

        if(e.getSource()==ajouterSéanceButton)onAddSeance();

        setPrgogressbar();

        if(e.getSource() instanceof JMenuItem)changementdepage((JMenuItem) e.getSource());

        this.getContentPane().repaint();
        this.getContentPane().revalidate();
    }




}
