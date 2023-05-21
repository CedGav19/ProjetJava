package Swing;

import Singleton.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopAjoutPlatMange extends JDialog implements ActionListener {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox ComboboxRecette;

    public PopAjoutPlatMange() {
        setContentPane(contentPane);

        for (int i = 0; i< Utilisateur.getInstance().getMesRecette().size(); i++) {
            ComboboxRecette.addItem(Utilisateur.getInstance().getMesRecette().get(i).toString());
        }
        ComboboxRecette.addActionListener(this);
        buttonCancel.addActionListener(this);
        buttonOK.addActionListener(this);
        setModal(true);
        pack();
        setVisible(true);
    }

    private void onOK() {
            System.out.println(ComboboxRecette.getSelectedIndex());

            Utilisateur.getInstance().getListePlatsMange().add(Utilisateur.getInstance().getMesRecette().get(ComboboxRecette.getSelectedIndex())) ;

            dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PopAjoutPlatMange dialog = new PopAjoutPlatMange();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonCancel)onCancel();
        if(e.getSource()==buttonOK)onOK();
    }
}
