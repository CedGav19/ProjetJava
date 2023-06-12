package Singleton;
import Aliment.Aliments;
import Aliment.Recette;
import Bean.LogEvt;
import Bean.LogListener;
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


public class Utilisateur implements  Serializable{

    //region variable

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

    private Seance lastSeance;
    public void setLastSeance(Seance s){this.lastSeance = s;}
    public Seance getLastSeance(){return lastSeance;}

    private static Utilisateur instance = new Utilisateur() ;
    private ArrayList<LogListener> mailingListLogListeners;

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


    //endregion
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
        LogDetected("Ajout de la recette : "+ r.toString());
    }
    public void removeRecette(Recette r){
        mesRecette.remove(r);
        LogDetected("Suppression de la recette : "+ r.toString());
    }

    public ArrayList<Recette> getListePlatsMange() {
        return listePlatsMange;
    }
    public void addPlatMange(Recette r){
        listePlatsMange.add(r);
        LogDetected("Ajout du plat mange : " + r.toString());
    }
    public void removePlatMange(Recette r){
        listePlatsMange.remove(r);
        LogDetected("Suppression de la recette : "+ r.toString());
    }

    public ArrayList<ExerciceForce> getExercicesForce() {
        return listeExercicesForce;
    }
    public void addExerciceForce(ExerciceForce r){
        listeExercicesForce.add(r);
        LogDetected("ajout de l'exercice de force : "+ r.toString());
    }
    public void removeExerciceForce(ExerciceForce r){
        listeExercicesForce.remove(r);
        LogDetected("Suppression de l'exercice de force : "+ r.toString());
    }

    public ArrayList<ExerciceCardio> getListeExercicesCardio() {
        return listeExercicesCardio;
    }
    public void addExerciceCardio(ExerciceCardio r){
        listeExercicesCardio.add(r);
        LogDetected("ajout de l'exercice de Cardio : "+ r.toString());
    }
    public void removeExerciceCardio(ExerciceCardio r){
        listeExercicesCardio.remove(r);
        LogDetected("Suppression de l'exercice de cardio  : "+ r.toString());
    }

    public ArrayList<Seance> getMesSeances() {
        return mesSeances;
    }
    public void addSeance(Seance r){
        mesSeances.add(r);
        LogDetected("ajout de la seance : "+ r.toString());
    }
    public void removeSeance(Seance r){
        mesSeances.remove(r);
        LogDetected("suppression de la seance : "+ r.toString());
    }

    public ArrayList<Aliments> getListeAliments() {
        return listeAliments;
    }
    public void addAliment(Aliments r){
        listeAliments.add(r);
        LogDetected("ajout de l'aliment : "+ r.toString());
    }
    public void removeAliment(Aliments r){
        listeAliments.remove(r);
        LogDetected("suppression de l'aliment : "+ r.toString());
    }

    //
    //
    //Romain
    public ArrayList<Objectif> getMesObjectifs() {
        return mesObjectifs;
    }
    public void ajouterObjectif(Objectif o) {
        mesObjectifs.add(o);
        LogDetected("ajout de l'objectif : "+ o.toString());
    }
    public void removeObjectif(Objectif o){
        mesObjectifs.remove(o);
        LogDetected("suppresion de l'objectif : "+ o.toString());
    }
    public ArrayList<Objectif> getMesObjectifsReussis() {
        return mesObjectifsReussis;
    }
    public void ajouterObjectifReussis(Objectif o) {
        mesObjectifsReussis.add(o);
        LogDetected("ajout de l'objectif reussis  : "+ o.toString());
    }
    public void removeObjectifReussis(Objectif o) {
        mesObjectifsReussis.remove(o);
        LogDetected("suppression de l'objectif : "+ o.toString());
    }

    public void validerObjectif(Objectif O) {
        if (mesObjectifs.contains(O)) {
            mesObjectifs.remove(O);
            mesObjectifsReussis.add(O);
        }
        LogDetected("Validation de l'objectif : "+ O.toString());
    }

    public void devaliderObjectif(Objectif O) {
        if (mesObjectifsReussis.contains(O)) {
            mesObjectifsReussis.remove(O);
            mesObjectifs.add(O);
        }
        LogDetected("undo de la Validation de l'objectif : "+ O.toString());
    }

     private void loadAlimentsCSV()
     {

         try {
             BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\Aliments.csv")) ;
             String ligne;
             br.readLine(); // pour passer le header du fichier csv
             while ((ligne = br.readLine()) != null) {
                 String[] proprietes = ligne.split(",");
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
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\ExercicesForce.csv")) ;
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
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\ExerciceCardio.csv")) ;
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

    public void Save() throws IOException
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\Sportify.txt", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(nomUtilisateur);
            oos.writeObject(prenomUtilisateur);
            oos.writeObject(poidsUtilisateur);
            oos.writeObject(tailleUtilisateur);

            oos.writeObject(lastSeance);
            oos.writeObject(mesRecette);
            oos.writeObject(listeAliments);
            oos.writeObject(listePlatsMange);

            oos.writeObject(listeExercicesForce);
            oos.writeObject(listeExercicesCardio);
            oos.writeObject(mesSeances);
            oos.writeObject(mesObjectifsReussis);
            oos.writeObject(mesObjectifs);

            oos.flush();
            oos.close();
        }
        catch(FileNotFoundException e)
        {
            throw e;
        }
        catch(IOException e)
        {
            throw e;
        }
    }

    public void Load() throws IOException, ClassNotFoundException {
        File f = new File(System.getProperty("user.dir")+"\\Sportify.txt");
        if(f.exists()) {

            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream oos = new ObjectInputStream(fis);

            nomUtilisateur = (String)  oos.readObject();
            prenomUtilisateur =(String)  oos.readObject();
            poidsUtilisateur = (int) oos.readObject();
            tailleUtilisateur = (int) oos.readObject();

            lastSeance = (Seance)  oos.readObject();
            mesRecette =(ArrayList<Recette>)  oos.readObject();
            listeAliments = (ArrayList<Aliments>) oos.readObject();
            listePlatsMange = (ArrayList<Recette>) oos.readObject();

            listeExercicesForce = (ArrayList<ExerciceForce>)  oos.readObject();
            listeExercicesCardio =(ArrayList<ExerciceCardio>)  oos.readObject();
            mesSeances = (ArrayList<Seance>) oos.readObject();
            mesObjectifsReussis = (ArrayList<Objectif>) oos.readObject();
            mesObjectifs = (ArrayList<Objectif>) oos.readObject();


            oos.close();
        }
        else
        {

        }
    }





    private void LogDetected(String msg)
    {


        LogEvt e = new LogEvt(this, msg);
        for(int i=0; i < mailingListLogListeners.size(); i++)
        {
            LogListener listener = mailingListLogListeners.get(i);
            listener.logDetected(e);
        }
    }
    public void addLogListener(LogListener listener)
    {
        if(!mailingListLogListeners.contains(listener))
        {
            mailingListLogListeners.add(listener);
        }
    }

    public void removeLogListener(LogListener listener)
    {
        if(mailingListLogListeners.contains(listener))
        {
            mailingListLogListeners.remove(listener);
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
        mailingListLogListeners = new ArrayList<>();
        lastSeance = new Seance();



        mesObjectifs = new ArrayList<Objectif>();

        mesObjectifsReussis = new ArrayList<Objectif>();


        setNomUtilisateur("John");
        setPrenomUtilisateur("Smith");
        setPoidsUtilisateur(75);
        setTailleUtilisateur(175);

        try {
            Load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if( listeAliments.size()==0 ) loadAlimentsCSV();

        if(listeExercicesForce.size()==0) loadExerciceForceCsv();

        if(listeExercicesCardio.size()==0) loadExerciceCardioCsv();
    }


    //endregion


}