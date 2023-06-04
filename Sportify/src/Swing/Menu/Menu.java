package Swing.Menu;

import javax.swing.*;

public class Menu extends JMenuBar {

        public Menu()
        {
            super();
            JMenu Home = new JMenu("Home");
            JMenu Profil = new JMenu("Profil");
            JMenu Exercice = new JMenu("Exercice");
            JMenu Alimentation = new JMenu("Alimentation");
            this.add(Home);
            this.add(Profil);
            this.add(Exercice);
            this.add(Alimentation);



        }
    public static void main(String[] args) {
        JDialog J = new JDialog();
        J.add(new Menu());
        J.setVisible(true);
       J.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}
