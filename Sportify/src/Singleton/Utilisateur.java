package Singleton;
import Aliment.Aliments;
import Aliment.Recette;
import Exercices.Seance;
import Objectifs.Objectif;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;


// sert de singleton
public class Utilisateur {

    //region vaiable et set/get
    private static Utilisateur instance = new Utilisateur() ;
    private String nom;
    private String prenom;
    private String date; // mettre en type date
    private float poidsActuel;
    private int tailleActuel;

    ArrayList<Seance> mesSeance;
    ArrayList<Recette> mesRecette;
    ArrayList<Objectif> mesObjectifsReussis;
    ArrayList<Objectif> mesObjectifs;

    ArrayList<Aliments> listeAliments;


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
        if (poidsActuel > 0) this.poidsActuel = poidsActuel;
    }

    public void setTailleActuel(int tailleActuel) {
        if (tailleActuel > 0) this.tailleActuel = tailleActuel;
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
    public static Utilisateur getInstance() {
        if (instance==null) instance = new Utilisateur();
        return instance;}
    //endregion


    //region constructeur
    private Utilisateur() {
        setNom("inconnu");
        setPrenom("inconnu");
        setDate("inconnue");
        setPoidsActuel(75);
        setTailleActuel(175);
        listeAliments = new ArrayList<Aliments>();
        listeAliments.add(new Aliments());
    }


    //endregion

    public void ajouterSceance(Seance s) {
        // faire les ajout dans les conteneur aussi
        mesSeance.add(s);
    }

    public void ajouterRecette(Recette r) {
        mesRecette.add(r);
    }

    public void ajouterObjectifReussis(Objectif o) {
        mesObjectifsReussis.add(o);
    }

    public void ajouterObjectif(Objectif o) {
        mesObjectifs.add(o);
    }

    public void validerObjectif(Objectif O) {
        if (mesObjectifs.contains(O)) {
            mesObjectifs.remove(O);
            mesObjectifsReussis.add(O);
        }
    }


    public ArrayList<Aliments> getListeAliments() {
        return listeAliments;
    }
     private void loadAlimentsCSV()
     {
         // a faire voir avec le prof ce qui est le mieux

     }
}