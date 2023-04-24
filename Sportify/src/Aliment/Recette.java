package Aliment;


import Exercices.Exercice;
import Exercices.Seance;

import java.util.ArrayList;

public class Recette {

     private ArrayList<Aliments> vecAliments ;

    public ArrayList<Aliments> getVecAliments() {
        return vecAliments;
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
        return tmp/ vecAliments.size() ;
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





}
