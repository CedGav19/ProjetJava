package ExercicesClass;

import java.util.ArrayList;

public class Seance {

    private String nom ;

    private ArrayList<Exercice> vecExercices ;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Exercice> getVecExercices() {
        return vecExercices;
    }

    public Seance()
    {
        vecExercices=new ArrayList<Exercice>();
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
        ArrayList<String> vtmp = new ArrayList<String>();
        if(vecExercices.size()>0)
        {
            vtmp.add(vecExercices.get(0).getMuscle());
            for (int i = 0; i < vecExercices.size(); i++) {
                for (int j = 0; j < vtmp.size(); j++) {
                    if (vecExercices.get(i).getMuscle() != vtmp.get(j)) vtmp.add(vecExercices.get(i).getMuscle());
                }
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

    public int nbExercice()
    {
        return vecExercices.size();
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

    @Override
    public String toString() {
        return getNom();
    }

    public static void main(String[] args) {

        System.out.println("--Creation d'un objet grace au constructeur par defaut");
        Seance O1 = new Seance();
        System.out.println(O1); // appele toString pour fonctionner
        System.out.println( "muscles : "+O1.vecMuscle());
        System.out.println("tps : "+O1.tempsTotal());
        System.out.println("--Remplissage du vecteur de l'objet");
        System.out.println("-avant remplissage");
        Seance O2 = new Seance();
        System.out.println(O2); // appele toString pour fonctionner
        System.out.println("muscles :"+O2.vecMuscle());
        System.out.println("tps : "+O2.tempsTotal());
        System.out.println("-apres remplissage");
        O2.ajouterExercice(new ExerciceForce("dev couch","pec",4,20,1));
        O2.ajouterExercice(new ExerciceForce("elev lat","epaules",5,20,2));
        System.out.println("muscles : "+O2.vecMuscle());
        System.out.println("tps : "+O2.tempsTotal());
        System.out.println(O2);
        System.out.println("--creation de 03  + insertion des nom  des exercices ");
        Seance O3 = new Seance();
        O3.ajouterExercice(new ExerciceForce("dev couch","pec",1,20,3));
        O3.ajouterExercice(new ExerciceForce("elev lat","dos",5,40,1));
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(" entre objet 2 et 3 : "+O2.Equals(O3));
        System.out.println("entre objet 2 et 1 : " +O2.Equals(O1));
        System.out.println("--utilisation de retirer");
        O3.retirerExercice("elev lat");
        System.out.println(O3);

    }







}
