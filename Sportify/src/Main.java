import Swing.Home;
import com.formdev.flatlaf.FlatDarculaLaf;

public class Main {

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        Home P = new Home();
        P.setVisible(true);
    }
}
