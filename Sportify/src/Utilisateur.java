import Aliment.Recette;
import Exercices.Sceance;
import Objectifs.Objectif;


// sert de singleton
public class Utilisateur {
    private String nom ;
    private String prenom ;
    private String date ; // mettre en type date

    private Sceance mesSceance[] ;
    private Recette mesRecette[] ;
    private Objectif mesObjectifsReussis[] ;
    private Objectif mesObjectif[];

    private float poidsActuel ;
    private int tailleActuel ;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate(String date) {
        this.date = date;
        // faire condition que la date existe
    }

    public void setPoidsActuel(float poidsActuel) {
       if (poidsActuel>0) this.poidsActuel = poidsActuel;
    }

    public void setTailleActuel(int tailleActuel) {
        if (tailleActuel>0)  this.tailleActuel = tailleActuel;
    }

    public float getPoidsActuel() {
        return poidsActuel;
    }

    public int getTailleActuel() {
        return tailleActuel;
    }

    public String getDate() {
        return date;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public  Utilisateur()
    {
        setNom("inconnu");
        setPrenom("inconnu");
        setDate("inconnue");
        setPoidsActuel(75);
        setTailleActuel(175);
    }

    public Utilisateur(String n, String p , String d , float pds , int t)
    {
        setNom(n);
        setPrenom(p);
        setDate(d);
        setPoidsActuel(pds);
        setTailleActuel(t);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", date='" + getDate() + '\'' +
                ", poidsActuel=" + getPoidsActuel() +
                ", tailleActuel=" + getTailleActuel() +
                '}';
    }
}
