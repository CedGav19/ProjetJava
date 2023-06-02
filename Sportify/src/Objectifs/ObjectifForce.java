package Objectifs;

import ExercicesClass.Exercice;
import ExercicesClass.ExerciceForce;

public class ObjectifForce extends Objectif {
    private ExerciceForce ex ;
    private float poids ;

    public ObjectifForce()
    {
        super();
        ex = new ExerciceForce();
        poids = 0 ;
    }
    public ObjectifForce(String n , String d ,ExerciceForce E, float p)
    {
        super(n,d);
        setPoids(p);
        setEx(E);
    }


    public void setEx(ExerciceForce ex) {
        this.ex = ex;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public Exercice getEx() {
        return ex;
    }

    public float getPoids() {
        return poids;
    }

    @Override
    public String toString() {
        return "ObjectifForce{" +
                "ex=" + ex.getNom() +
                ", poids=" + poids +
                '}';
    }

    public static void main(String[] args) {

        System.out.println("--Creation d'un objet grace au constructeur par defaut");
        ObjectifForce O1 = new ObjectifForce();
        System.out.println(O1); // appele toString pour fonctionner
        System.out.println("--Creation d'un objet grace precis");

        ObjectifForce O2 = new ObjectifForce("100kg dev couch", "12 mai", new ExerciceForce("dev couch","pec" ,4,0,1),100);
        System.out.println(O2);
        ObjectifForce O3 = new ObjectifForce("100kg dev couch", "12 mai",  new ExerciceForce("dev couch","pec" ,4,0,2),20) ;
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(" entre objet 2 et 3 : "+O2.Equals(O3));
        System.out.println("entre objet 2 et 1 : " +O2.Equals(O1));
    }

}
