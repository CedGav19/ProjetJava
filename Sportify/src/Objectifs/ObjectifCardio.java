package Objectifs;

import ExercicesClass.Exercice;
import ExercicesClass.ExerciceCardio;

public class ObjectifCardio extends Objectif {
   // private ExerciceCardio ex;

 private       float   temps;


    public ObjectifCardio() {
        super();
        //ex = new ExerciceCardio();

    }

    public ObjectifCardio(String n, String d, float t/*, ExerciceCardio E*/) {
        super(n, d);
        //setEx(E);
        setTemps(t);
    }

    /*
    public void setEx(ExerciceCardio ex) {
        this.ex = ex;
    }

     */

    public void setTemps(float temps) {
        this.temps = temps;
    }

    public float getTemps() {
        return temps;
    }


    /*
    public Exercice getEx() {
        return ex;
    }
     */

    @Override
    public String toString() {
        return super.toString() /*+ "nom de l'exercice : "+getEx().getNom()*/;
    }

    @Override
    public boolean Equals(Objectif obj) {
        return super.Equals(obj);
    }

    public static void main(String[] args) {

        /*
        System.out.println("--Creation d'un objet grace au constructeur par defaut");
        ObjectifCardio O1 = new ObjectifCardio();
        System.out.println(O1); // appele toString pour fonctionner
        System.out.println("--Creation d'un objet grace precis");

        ObjectifCardio O2 = new ObjectifCardio("courir 1000 metre ", "12 mai", new ExerciceCardio("course a pied","tout" ,1, 0 , 1000));
        System.out.println(O2);
        ObjectifCardio O3 = new ObjectifCardio("courir 1000 metre ", "12 mai", new ExerciceCardio("danse","tout" ,1, 0 , 0)) ;
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(" entre objet 2 et 3 : "+O2.Equals(O3));
        System.out.println("entre objet 2 et 1 : " +O2.Equals(O1));

         */
    }


}