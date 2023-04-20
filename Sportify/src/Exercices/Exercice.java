package Exercices;

public class Exercice {

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
       if(score <=5 && score <= 0 ) this.score = score;
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


    @Override
    public String toString() {
        return "Exercices.Exercice{" +
                "muscle='" + getMuscle() + '\'' +
                ", tempsEstime=" + getTempsEstime() +
                ", nom='" + getNom() + '\'' +
                ", score=" + getScore() +
                '}';
    }
}
