package Exercices;

import Aliment.Aliments;

public  abstract class Exercice {

    private String muscle;
    private int tempsEstime ;

    private String nom ;
    private int score ; // entier entre 0 et 5

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public void setScore(int score) {
       if(score <=5 && score >= 0 ) this.score = score;
    }

    public void setTempsEstime(int tempsEstime) {
        this.tempsEstime = tempsEstime;
    }

    public int getScore() {
        return score;
    }

    public String getNom() {
        return nom;
    }

    public int getTempsEstime() {
        return tempsEstime;
    }

    public String getMuscle() {
        return muscle;
    }

    public  Exercice()
    {
        setMuscle("inconnu");
        setNom("inconnu");
        setScore(0);
        setTempsEstime(0);
    }

    public Exercice(String n , String m)
    {
        this() ;
        setNom(n);
        setMuscle(m);
    }

    public Exercice(String n , String m , int sc , int tps)
    {
       setScore(sc);
       setTempsEstime(tps);
        setNom(n);
        setMuscle(m);
    }

    // jamaois instanciable donc inutile ( sauf pour lest test )
    @Override
    public String toString() {
        return nom +", " + muscle+", "+ tempsEstime+", "+ score;
    }

    public boolean Equals(Exercice obj)
    {
        if(this.nom == obj.nom)
            return true ;
        else
            return false;
    }

    /*public static void main(String[] args) {

        System.out.println("--Creation d'un objet grace au constructeur par defaut");
        Exercice O1 = new Exercice();
        System.out.println(O1); // appele toString pour fonctionner
        System.out.println("--Creation d'un objet grace precis");
        Exercice O2 = new Exercice("développé couché","pectoraux");
        System.out.println(O2);
        Exercice O3 = new Exercice("développé couché","pectoraux",5,20) ;
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(O2.Equals(O3));
        System.out.println(O2.Equals(O1));
    }*/
}
