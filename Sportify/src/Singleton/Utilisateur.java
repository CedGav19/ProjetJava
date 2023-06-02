package Singleton;
import Aliment.Aliments;
import Aliment.Recette;
import ExercicesClass.Exercice;
import ExercicesClass.ExerciceForce;
import ExercicesClass.Seance;
import Objectifs.Objectif;

import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;


public class Utilisateur {

    //Salut mon petit Cédric
    //region vaiable et set/get
    private static Utilisateur instance = new Utilisateur() ;
    private String nom;
    private String prenom;
    private String date; // mettre en type date
    private float poidsActuel;
    private int tailleActuel;


    private ArrayList<Recette> mesRecette;
    private ArrayList<Objectif> mesObjectifsReussis;
    private  ArrayList<Objectif> mesObjectifs;
    private ArrayList<Aliments> listeAliments;
    private ArrayList<Recette> listePlatsMange;

    private ArrayList<Exercice> listeEx;
    private ArrayList<Seance> mesSeance;
    private ArrayList<ExerciceForce> ExercicesForce;

    private Seance seanceActuel;



    // Variables utiles lors des interactions

    private  Aliments AlimentSelected ;



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

    public ArrayList<Recette> getMesRecette() {
        return mesRecette;
    }

    public ArrayList<Recette> getListePlatsMange() {
        return listePlatsMange;
    }

    public ArrayList<ExerciceForce> getExercicesForce() {
        return ExercicesForce;
    }

    //Romain Test
    public ArrayList<Objectif> getMesObjectifs() {
        return mesObjectifs;
    }
    public ArrayList<Objectif> getMesObjectifsReussis() {
        return mesObjectifsReussis;
    }
    //fin Romain test

    public void setAlimentSelected(Aliments alimentSelected) {
        AlimentSelected = alimentSelected;
    }

    public Aliments getAlimentSelected() {
        return AlimentSelected;
    }
    //endregion


    //region constructeur
    private Utilisateur() {
        setNom("inconnu");
        setPrenom("inconnu");
        setDate("inconnue");
        setPoidsActuel(75);
        setTailleActuel(175);
        listeAliments = new ArrayList<Aliments>();
        mesRecette = new ArrayList<Recette>();
        listePlatsMange = new ArrayList<Recette>();
        ExercicesForce = new ArrayList<ExerciceForce>();
        listeEx=new ArrayList<Exercice>();

        //Test Romain
        mesObjectifs = new ArrayList<Objectif>();
        mesObjectifsReussis = new ArrayList<Objectif>();
        //Fin test Romain


        loadAlimentsCSV();
        loadExerciceForceCsv();
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


         try {
             BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\Aliments.csv")) ;
             String ligne;
             br.readLine(); // pour passer le header du fichier csv
             while ((ligne = br.readLine()) != null) {
                 String[] proprietes = ligne.split(";");
                 Aliments aliment = new Aliments(proprietes[0],Integer.parseInt(proprietes[1]),Float.parseFloat(proprietes[2]),Integer.parseInt(proprietes[3]) ) ;

               listeAliments.add(aliment) ;
             }
         } catch (IOException e) {
             System.err.println("Erreur lors de la lecture des données : " + e.getMessage());
         }
     }

    private void loadExerciceForceCsv()
    {


        try {
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\ExercicesForce.csv")) ;
            String ligne;
            br.readLine(); // pour passer le header du fichier csv
            while ((ligne = br.readLine()) != null) {
                String[] proprietes = ligne.split(",");
                ExerciceForce Ex = new ExerciceForce(proprietes[0],proprietes[1],Integer.parseInt(proprietes[3]),
                        Integer.parseInt(proprietes[2]),1);

                ExercicesForce.add(Ex) ;
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture des données : " + e.getMessage());
        }
    }


}