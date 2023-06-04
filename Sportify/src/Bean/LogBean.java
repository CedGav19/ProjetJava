package Bean;

import Singleton.Utilisateur;
import java.io.*;

public class LogBean implements LogListener
{
    public LogBean()
    {
        Utilisateur.getInstance().addLogListener(this);
    }

    public void logDetected(LogEvt e)
    {
        saveLogOnFile(e);
    }

    private void saveLogOnFile(LogEvt e)
    {
        try
        {
            System.out.println("dans le save du logbean ");
            File f = new File(System.getProperty("user.dir")+"\\src\\logs.txt");
            FileWriter fr;

            if(f.exists()) {
                fr = new FileWriter(f, true);
            }
            else{
                fr = new FileWriter(f, false);
            }

            BufferedWriter br = new BufferedWriter(fr);
            br.write(e.getLog());
            br.newLine();


            br.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Erreur lors de la manipulation du fichier de logs");
        }
        catch(IOException ex)
        {
            System.out.println("Erreur IO !");
        }
    }

}