package Swing;

import Singleton.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PopAjoutPlat extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JScrollPane ScrollPaneAliment;

    public PopAjoutPlat() {
        setContentPane(contentPane);
        setModal(true);
        pack();
        setVisible(true);
        getRootPane().setDefaultButton(buttonOK);

        JPanel PanelAliments = new JPanel();
        PanelAliments.setLayout(new GridLayout(0, 1));
        for (int i = 0; i< Utilisateur.getInstance().getListeAliments().size(); i++)
        {
            PanelAliments.add(new Checkbox(Utilisateur.getInstance().getListeAliments().get(0).toString()));
        }
        ScrollPaneAliment.setViewportView(PanelAliments);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PopAjoutPlat dialog = new PopAjoutPlat();

        System.exit(0);
    }
}
