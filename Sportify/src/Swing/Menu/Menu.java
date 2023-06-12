package Swing.Menu;

import javax.swing.*;

public class Menu extends JMenuBar {

        public Menu()
        {
            super();
            JMenu page = new JMenu("Window");
            JMenuItem Home = new JMenuItem("Home");
            JMenuItem Profil = new JMenuItem("Profil");
            JMenuItem Exercice = new JMenuItem("Exercise");
            JMenuItem Alimentation = new JMenuItem("Food");
            page.add(Home);
            page.add(Profil);
            page.add(Exercice);
            page.add(Alimentation);
            this.add(page);



        }
    public static void main(String[] args) {
        JDialog J = new JDialog();
        J.add(new Menu());
        J.setVisible(true);
       J.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}
