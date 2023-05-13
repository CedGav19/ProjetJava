package Aliment;


import Exercices.Exercice;
import Exercices.ExerciceForce;
import Exercices.Seance;
import Objectifs.ObjectifForce;

import java.util.ArrayList;

public class Recette {

    private String nom ;
     private ArrayList<Aliments> vecAliments ;

    public ArrayList<Aliments> getVecAliments() {
        return vecAliments;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Recette()
    {
        vecAliments =new ArrayList<Aliments>() ;
        setNom("nom de recette");
    }

    public String  AfficherAliments()
    {
        String tmp = new String();
        for(int i = 0 ; i < vecAliments.size(); i++)
        {
            tmp += "Aliment  " + i + ": " + vecAliments.get(i).toString();
        }
        return tmp ;
    }

    public void ajouterAliment(Aliments A )
    {
        vecAliments.add(A);

    }

    public void retirerAliment(String n ) // suprime ts les exercices qui possede le meme nom
    {
        for(int i = 0 ; i < vecAliments.size(); i++)
        {
            if(vecAliments.get(i).getNom()== n )
            {
                vecAliments.remove(vecAliments.get(i));
            }
        }
    }

    public int scoreMoyenne()
    {
        int tmp = 0 ;
        for(int i = 0 ; i < vecAliments.size(); i++)
        {
            tmp +=vecAliments.get(i).getScore();
        }
        if(vecAliments.size()!=0)
        return tmp/ vecAliments.size() ;
        else
            return tmp;
    }
    public int sommeProteine()
    {
        int tmp = 0 ;
        for(int i = 0 ; i < vecAliments.size(); i++)
        {
            tmp +=vecAliments.get(i).getProteine();
        }
        return tmp ;
    }

    public int sommeKcal()
    {
        int tmp = 0 ;
        for(int i = 0 ; i < vecAliments.size(); i++)
        {
            tmp +=vecAliments.get(i).getKcal();
        }
        return tmp ;
    }
    public int nbaliments()
    {
        return vecAliments.size();
    }
    public boolean Equals(Recette obj)
    {
        if(vecAliments.size()==obj.vecAliments.size())
        {

            for (int i = 0; i < vecAliments.size(); i++)
            {
                if (vecAliments.get(i).getNom()!=obj.vecAliments.get(i).getNom())
                {
                    return false ;
                }

            }
            return true ; // si aucun est faux c'est que c'est vrai
        }
        else
            return false ;
    }

    @Override
    public String toString() {
        return getNom();
    }

    public static void main(String[] args) {

        System.out.println("--Creation d'un objet grace au constructeur par defaut");
        Recette O1 = new Recette();
        System.out.println(O1); // appele toString pour fonctionner
        System.out.println( "score : "+O1.scoreMoyenne());
        System.out.println("kcal : "+O1.sommeKcal());
        System.out.println("prot : "+O1.sommeProteine());
        System.out.println("--Remplissage du vecetur de l'objet");
        System.out.println("-avant remplissage");
        Recette O2 = new Recette();
        System.out.println(O2); // appele toString pour fonctionner
        System.out.println("score :"+O2.scoreMoyenne());
        System.out.println("kcal : "+O2.sommeKcal());
        System.out.println("prot:"+ O2.sommeProteine());
        System.out.println("-apres remplissage");
        O2.ajouterAliment(new Aliments("carotte",1,2,3));
        O2.ajouterAliment(new Aliments("toast",12,22,1));
        System.out.println("score : "+O2.scoreMoyenne());
        System.out.println("kcal : "+O2.sommeKcal());
        System.out.println("prot : "+O2.sommeProteine());
        System.out.println(O2);
        System.out.println("--creation de 03  + insertion des nom  des aliments ");
        Recette O3 = new Recette();
        O3.ajouterAliment(new Aliments("carotte",1,0,3));
        O3.ajouterAliment(new Aliments("toast",2,100,1));
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(" entre objet 2 et 3 : "+O2.Equals(O3));
        System.out.println("entre objet 2 et 1 : " +O2.Equals(O1));
        System.out.println("--utilisation de retirer");
        O3.retirerAliment("carotte");
        System.out.println(O3);

    }





}
