package Swing;

import Singleton.Utilisateur;
import Swing.Menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends  JFrame implements ActionListener {
    private JButton pasFaitButton;
    private JPanel contentPane;
    private JButton faitButton;
    private JButton buttonplusobj;
    private JButton buttonmoinobj;
    private JButton modifierButton;
    private JTextField fieldPrenom;
    private JTextField fieldNom;
    private JSpinner poids;
    private JSpinner taille;
    private JLabel ChampErreur;
    private JButton butonmoinsobjfait;
    private JScrollPane ScrollPanelObjAreal;
    private JScrollPane ScrolpanelOjectifRealise;

    public static void main(String[] args) {
        Profile P = new Profile();
    }

    Profile(){
        setContentPane(contentPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Profile");
        setSize(800,600);


        ChampErreur.setText("Bienvenue sur votre profil " + Utilisateur.getInstance().getNomUtilisateur().toString() + " !");

        //Profile
        fieldPrenom.setText(Utilisateur.getInstance().getPrenomUtilisateur().toString());
        fieldNom.setText(Utilisateur.getInstance().getNomUtilisateur().toString());
        poids.setValue(Utilisateur.getInstance().getPoidsUtilisateur());
        taille.setValue(Utilisateur.getInstance().getTailleUtilisateur());
        //Modifier le profile
        modifierButton.addActionListener(this);

        //Partie sur les objectifs souhaité
        JPanel panelObjectifArealiser = new JPanel();
        panelObjectifArealiser.setLayout(new GridLayout(0,1));
        for( int i = 0 ; i < Utilisateur.getInstance().getMesObjectifs().size() ; i++)
        {
            panelObjectifArealiser.add(new JCheckBox(Utilisateur.getInstance().getMesObjectifs().get(i).toString()));
        }
        ScrollPanelObjAreal.setViewportView(panelObjectifArealiser);

        buttonplusobj.addActionListener(this);
        buttonmoinobj.addActionListener(this);
        faitButton.addActionListener(this);

        //Partie sur les objectifs déjà fait
        JPanel panelObjectifRealise = new JPanel();
        panelObjectifRealise.setLayout(new GridLayout(0,1));
        for( int i = 0 ; i < Utilisateur.getInstance().getMesObjectifsReussis().size() ; i++)
        {
            panelObjectifRealise.add(new JCheckBox(Utilisateur.getInstance().getMesObjectifsReussis().get(i).toString()));
        }
        ScrolpanelOjectifRealise.setViewportView(panelObjectifRealise);

        butonmoinsobjfait.addActionListener(this);
        pasFaitButton.addActionListener(this);
    }

    public void onAddObjectif(){
        int tmp = Utilisateur.getInstance().getMesObjectifs().size();
        PopObjectifs POBJ = new PopObjectifs();
        if(tmp<Utilisateur.getInstance().getMesObjectifs().size())
        {
            JPanel tmpPanel = (JPanel)ScrollPanelObjAreal.getViewport().getView() ;
            tmpPanel.add(new JCheckBox(Utilisateur.getInstance().getMesObjectifs().get(tmp).toString()));
            ScrollPanelObjAreal.repaint();
            ScrollPanelObjAreal.revalidate();
        }
    }
    private void onSupObjectifs() {
        JPanel tmpPanel = (JPanel) ScrollPanelObjAreal.getViewport().getView();
        for (Component c : tmpPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0; i < Utilisateur.getInstance().getMesObjectifs().size(); i++) {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getMesObjectifs().get(i).toString())) {
                            Utilisateur.getInstance().getMesObjectifs().remove(Utilisateur.getInstance().getMesObjectifs().get(i));
                            tmpPanel.remove(checkBox);
                            ScrollPanelObjAreal.repaint();
                            ScrollPanelObjAreal.revalidate();
                        }
                    }
                }

            }
        }
    }

    private void onSupObjectifsFait() {
        JPanel tmpPanel = (JPanel) ScrolpanelOjectifRealise.getViewport().getView();
        for (Component c : tmpPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0; i < Utilisateur.getInstance().getMesObjectifsReussis().size(); i++) {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getMesObjectifsReussis().get(i).toString())) {
                            Utilisateur.getInstance().getMesObjectifsReussis().remove(Utilisateur.getInstance().getMesObjectifsReussis().get(i));
                            tmpPanel.remove(checkBox);
                            ScrolpanelOjectifRealise.repaint();
                            ScrolpanelOjectifRealise.revalidate();
                        }
                    }
                }

            }
        }
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

    private void modification(){
        int error =0;
        ChampErreur.setText("");
        if(fieldNom.getText().length() < 1)
        {
            ChampErreur.setText("Nom, ");
            error =1;
        }
        if(fieldPrenom.getText().length() <1)
        {
            ChampErreur.setText(ChampErreur.getText() + "Prenom, ");
            error =1;
        }
        if((int)poids.getValue()<=0)
        {
            ChampErreur.setText(ChampErreur.getText() + "Poids, ");
            error =1;
        }
        if((int)taille.getValue()<=0)
        {
            ChampErreur.setText(ChampErreur.getText() + "Taille, ");
            error =1;
        }

        Color col;
        if(error == 1)
        {
            ChampErreur.setText(ChampErreur.getText() + "Invalide !");
            col = Color.RED;
        }
        else
        {
            Utilisateur.getInstance().setNomUtilisateur(fieldNom.getText().toString());
            Utilisateur.getInstance().setPrenomUtilisateur(fieldPrenom.getText().toString());
            Utilisateur.getInstance().setPoidsUtilisateur((int)poids.getValue());
            Utilisateur.getInstance().setTailleUtilisateur((int)taille.getValue());
            ChampErreur.setText("Bien modifié !");
            col= Color.GREEN;
        }
        ChampErreur.setForeground(col);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonplusobj)onAddObjectif();
        if (e.getSource()==buttonmoinobj)onSupObjectifs();
        if(e.getSource()==faitButton)changerenfait();

        if(e.getSource()==butonmoinsobjfait)onSupObjectifsFait();
        if(e.getSource()==pasFaitButton)changerpasfait();

        if(e.getSource()==modifierButton)modification();

    }
}
