package Singleton;
import Aliment.Aliments;
import Aliment.Recette;
import ExercicesClass.Exercice;
import ExercicesClass.ExerciceCardio;
import ExercicesClass.ExerciceForce;
import ExercicesClass.Seance;
import Objectifs.Objectif;
import Objectifs.ObjectifCardio;

import javax.naming.directory.SearchControls;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;


public class Utilisateur {

    //region variable et set/get

    private String nomUtilisateur;
    public void setNomUtilisateur(String nom){this.nomUtilisateur = nom;}
    public String getNomUtilisateur(){return nomUtilisateur;}

    private String prenomUtilisateur;
    public void setPrenomUtilisateur(String prenom){this.prenomUtilisateur = prenom;}
    public String getPrenomUtilisateur(){return prenomUtilisateur;}

    private int poidsUtilisateur;
    public void setPoidsUtilisateur(int poidsUtil){this.poidsUtilisateur = poidsUtil;}
    public int getPoidsUtilisateur(){return poidsUtilisateur;}

    private int tailleUtilisateur;
    public void setTailleUtilisateur(int tailleUtil){this.tailleUtilisateur = tailleUtil;}
    public int getTailleUtilisateur(){return tailleUtilisateur;}

    private static Utilisateur instance = new Utilisateur() ;

    //
    //
    //cedric
    private ArrayList<Recette> mesRecette;
     private ArrayList<Aliments> listeAliments;
    private ArrayList<Recette> listePlatsMange;
    private   ArrayList<ExerciceForce> listeExercicesForce;
    private   ArrayList<ExerciceCardio> listeExercicesCardio;
    private ArrayList<Seance> mesSeances;

    //
    //
    //romain
    private ArrayList<Objectif> mesObjectifsReussis;
    private  ArrayList<Objectif> mesObjectifs;



    // Variables utiles lors des interactions

    public static Utilisateur getInstance() {
        if (instance==null) instance = new Utilisateur();
        return instance;}

    //
    //
    //cedric
    public ArrayList<Recette> getMesRecette() {
        return mesRecette;
    }
    public void addRecette(Recette r){
        mesRecette.add(r);
    }
    public void removeRecette(Recette r){
        mesRecette.remove(r);
    }

    public ArrayList<Recette> getListePlatsMange() {
        return listePlatsMange;
    }
    public void addPlatMange(Recette r){
        listePlatsMange.add(r);
    }
    public void removePlatMange(Recette r){
        listePlatsMange.remove(r);
    }

    public ArrayList<ExerciceForce> getExercicesForce() {
        return listeExercicesForce;
    }
    public void addExerciceForce(ExerciceForce r){
        listeExercicesForce.add(r);
    }
    public void removeExerciceForce(ExerciceForce r){
        listeExercicesForce.remove(r);
    }

    public ArrayList<ExerciceCardio> getListeExercicesCardio() {
        return listeExercicesCardio;
    }
    public void addExerciceCardio(ExerciceCardio r){
        listeExercicesCardio.add(r);
    }
    public void removeExerciceCardio(ExerciceCardio r){
        listeExercicesCardio.remove(r);
    }

    public ArrayList<Seance> getMesSeances() {
        return mesSeances;
    }
    public void addSeance(Seance r){
        mesSeances.add(r);
    }
    public void removeSeance(Seance r){
        mesSeances.remove(r);
    }

    public ArrayList<Aliments> getListeAliments() {
        return listeAliments;
    }
    public void addAliment(Aliments r){
        listeAliments.add(r);
    }
    public void removeAliment(Aliments r){
        listeAliments.remove(r);
    }

    //
    //
    //Romain
    public ArrayList<Objectif> getMesObjectifs() {
        return mesObjectifs;
    }
    public void ajouterObjectif(Objectif o) {
        mesObjectifs.add(o);
    }
    public void removeObjectif(Objectif o){
        mesObjectifs.remove(o);
    }
    public ArrayList<Objectif> getMesObjectifsReussis() {
        return mesObjectifsReussis;
    }
    public void ajouterObjectifReussis(Objectif o) {
        mesObjectifsReussis.add(o);
    }
    public void removeObjectifReussis(Objectif o) {
        mesObjectifsReussis.remove(o);
    }

    public void validerObjectif(Objectif O) {
        if (mesObjectifs.contains(O)) {
            mesObjectifs.remove(O);
            mesObjectifsReussis.add(O);
        }
    }

    public void devaliderObjectif(Objectif O) {
        if (mesObjectifsReussis.contains(O)) {
            mesObjectifsReussis.remove(O);
            mesObjectifs.add(O);
        }
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

                listeExercicesForce.add(Ex) ;
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture des données : " + e.getMessage());
        }
    }

    private void loadExerciceCardioCsv()
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\ExerciceCardio.csv")) ;
            String ligne;
            br.readLine(); // pour passer le header du fichier csv
            while ((ligne = br.readLine()) != null) {
                String[] proprietes = ligne.split(",");
                ExerciceCardio Ex = new ExerciceCardio(proprietes[0],proprietes[1],Integer.parseInt(proprietes[3]),
                        Integer.parseInt(proprietes[2]),1);

                addExerciceCardio(Ex); ;
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture des données : " + e.getMessage());
        }
    }
    //endregion


    //region constructeur
    private Utilisateur() {
        listeAliments = new ArrayList<Aliments>();
        mesRecette = new ArrayList<Recette>();
        listePlatsMange = new ArrayList<Recette>();
        listeExercicesForce = new ArrayList<ExerciceForce>();
        listeExercicesCardio = new ArrayList<ExerciceCardio>();
        mesSeances = new ArrayList<Seance>();
        //Test Romain
        mesObjectifs = new ArrayList<Objectif>();
        ObjectifCardio o = new ObjectifCardio("Test","Test",5);
        ajouterObjectif(o);
        ObjectifCardio o1 = new ObjectifCardio("TestA","TestA",6);
        ajouterObjectif(o1);
        mesObjectifsReussis = new ArrayList<Objectif>();
        ObjectifCardio o3 = new ObjectifCardio("TestA","TestA",6);
        ajouterObjectifReussis(o3);

        setNomUtilisateur("Inconnu");
        setPrenomUtilisateur("Inconnu");
        setPoidsUtilisateur(60);
        setTailleUtilisateur(170);
        //Fin test Romain


        loadAlimentsCSV();
        loadExerciceForceCsv();
        loadExerciceCardioCsv();
    }


    //endregion


}