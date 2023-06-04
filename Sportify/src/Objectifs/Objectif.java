package Objectifs;

import java.io.Serializable;

public  abstract class Objectif  implements Serializable {
    //private boolean accompli ;     on fait 2 vecteur dans notre singleton un accompli et l'autre en cours
    private String dateSouhaite ;

    private String nom ;

    public Objectif()
    {
        setNom("aucun");
        setDateSouhaite("aucune");
    }
    public Objectif(String n , String d)
    {
        setDateSouhaite(d);
        setNom(n);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setDateSouhaite(String dateSouhaite) {
        this.dateSouhaite = dateSouhaite;
    }

    public String getDateSouhaite() {
        return dateSouhaite;
    }


    @Override
    public String toString() {
        return "Objectif{" +
                "nom =" + getNom() +
                ", dateSouhaite='" + dateSouhaite + '\'' +
                '}';
    }

    public boolean Equals(Objectif obj)
    {
        if(this.getNom() == obj.getNom())
            return true ;
        else
            return false;
    }

  /*  public static void main(String[] args) {
        System.out.println("Objectif est une classe abstraite ");
        System.out.println("--Creation d'un objet grace au constructeur par defaut");
        Objectif O1 = new Objectif();
        System.out.println(O1); // appele toString pour fonctionner
        System.out.println("--Creation d'un objet grace precis");
        Exercice O2 = new Objectif("objectif 1 " , "12/03/23");
        System.out.println(O2);
        Exercice O3 = new Objectif("objectif 2 " , "11/07/23");
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(O2.Equals(O3));
        System.out.println(O2.Equals(O1));
    } */

}
