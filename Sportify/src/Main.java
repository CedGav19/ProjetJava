import Swing.Home;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        Home P = new Home();
        P.setVisible(true);
    }
}
