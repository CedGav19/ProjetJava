package Exercices;

import Aliment.Aliments;

import java.util.ArrayList;

public class Seance {

    private ArrayList<Exercice> vecExercices ;

    public ArrayList<Exercice> getVecExercices() {
        return vecExercices;
    }

    public String  AfficherExercices()
    {
        String tmp = new String();
        for(int i = 0 ; i < vecExercices.size(); i++)
        {
            tmp += "exercice " + i + ": " + vecExercices.get(i).toString();
        }
        return tmp ;
    }

    public void ajouterExercice(Exercice E )
    {
       vecExercices.add(E);

    }
    public void retirerExercice(String n ) // suprime ts les exercices qui possede le meme nom
    {
        for(int i = 0 ; i < vecExercices.size(); i++)
        {
           if(vecExercices.get(i).getNom()== n )
           {
               vecExercices.remove(vecExercices.get(i));
           }
        }
    }

    public ArrayList<String> vecMuscle()
    {
        ArrayList<String> vtmp = null;
        vtmp.add(vecExercices.get(0).getMuscle());
        for(int i = 0 ; i < vecExercices.size(); i++)
        {
                for(int j =0 ; j<vtmp.size();i++)
                {
                    if(vecExercices.get(i).getMuscle()!= vtmp.get(i))  vtmp.add(vecExercices.get(i).getMuscle());
                }
        }
        return vtmp ;
    }

    public int tempsTotal()
    {
        int tmp = 0 ;
        for(int i = 0 ; i < vecExercices.size(); i++)
        {
            tmp +=vecExercices.get(i).getTempsEstime();
        }
        return tmp ;
    }

    public boolean Equals(Seance obj)
    {
        if(vecExercices.size()==obj.vecExercices.size())
        {

            for (int i = 0; i < vecExercices.size(); i++)
            {
                if (vecExercices.get(i).getNom()!=obj.vecExercices.get(i).getNom())
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
