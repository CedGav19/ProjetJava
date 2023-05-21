package Swing;

import Aliment.Recette;
import Singleton.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PopAjoutPlat extends JDialog   implements ActionListener{
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JScrollPane ScrollPaneAliment;

    public PopAjoutPlat() {
        setContentPane(contentPane);

        getRootPane().setDefaultButton(buttonOK);

        JPanel PanelAliments = new JPanel();
        PanelAliments.setLayout(new GridLayout(0, 1));
        for (int i = 0 ; i<Utilisateur.getInstance().getListeAliments().size();i++)
        {
            PanelAliments.add(new JCheckBox(Utilisateur.getInstance().getListeAliments().get(i).toString()));
        }
        ScrollPaneAliment.setViewportView(PanelAliments);
        buttonOK.addActionListener(this);
        buttonCancel.addActionListener(this);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


        //set modal dit que on attend une action de l'utilisateur
        setModal(true);
        pack();
        setVisible(true);
    }

    private void onOK() {

        int nbalim =0 ;
        Recette maRecette = new Recette() ;
        maRecette.setNom(textField1.getText());
        JPanel tmpPanel = (JPanel)ScrollPaneAliment.getViewport().getView() ;
        for (Component c :tmpPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) c;
                if (checkBox.isSelected()) {

                    for (int i = 0 ; i<Utilisateur.getInstance().getListeAliments().size();i++)
                    {
                        if (checkBox.getText().equals(Utilisateur.getInstance().getListeAliments().get(i).toString()))
                        {
                            maRecette.ajouterAliment(Utilisateur.getInstance().getListeAliments().get(i)); ;
                            nbalim++;
                        }
                    }
                }
            }
        }
        if(nbalim!=0 || textField1.getText()!="")
        {
            Utilisateur.getInstance().getMesRecette().add(maRecette);
            dispose();
        }
        else
        {

            JOptionPane.showMessageDialog(null, "vous devez selectionner au moins 1 aliment et donner un nom à votre recette", "ERROR", JOptionPane.WARNING_MESSAGE);

        }


    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PopAjoutPlat dialog = new PopAjoutPlat();

        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("dans le actionlistener de pop ajoutplat");
        if(e.getSource()==buttonCancel)onCancel();
        if(e.getSource()==buttonOK)onOK();

    }
}
