package Aliment;

import java.io.Serializable;

public class Aliments implements Serializable {

    private int kcal ;
    private float proteine ;

    private String nom ;
    private int score ;

    public Aliments()
    {
        setNom("inconnu");
        setKcal(0);
        setProteine(0);
        setScore(0);
    }
    public Aliments(String n , int k ,float p , int s)
    {
        setNom(n);
        setKcal(k);
        setProteine(p);
        setScore(s);
    }


    public void setScore(int score) {
       if(score <= 5 && score >=0) this.score = score;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public void setProteine(float proteine) {
        this.proteine = proteine;
    }

    public String getNom() {
        return nom;
    }


    public float getProteine() {
        return proteine;
    }

    public int getKcal() {
        return kcal;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return getNom()+ ", "+getKcal()+" kcal, " + getProteine()+"g " ;
    }

    public boolean Equals(Aliments obj)
    {
        if(this.nom == obj.nom)
            return true ;
        else
            return false;
    }



    public static void main(String[] args) {

        System.out.println("--Creation d'un objet grace au constructeur par defaut");
        Aliments O1 = new Aliments();
        System.out.println(O1); // appele toString pour fonctionner
        System.out.println("--Creation d'un objet grace precis");
        Aliments O2 = new Aliments("carotte",100,2,4 );
        System.out.println(O2);
        Aliments O3 = new Aliments("carotte",12,20,1) ;
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(O2.Equals(O3));
        System.out.println(O2.Equals(O1));

        
    }
}
