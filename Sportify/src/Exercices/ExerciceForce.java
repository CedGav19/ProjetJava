package Exercices;

public class ExerciceForce extends Exercice {

    private boolean polyarticulaire ;

    public void setPolyarticulaire(boolean polyarticulaire) {
        this.polyarticulaire = polyarticulaire;
    }
    public boolean getPolyarticulaire()
    {
        return polyarticulaire;
    }

    public ExerciceForce()
    {
        super();
        setPolyarticulaire(false);
    }
    public ExerciceForce(String n , String m , int sc , int tps , boolean poly )
    {
        super( n ,  m , sc , tps);
        setPolyarticulaire(poly);
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        if(polyarticulaire==true) return tmp+", polyarticulaire" ;

        return tmp+", mono-articulaire" ;

    }
    public boolean Equals(Exercice obj)
    {
        if(this.getNom() == obj.getNom())
            return true ;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println("--Creation d'un objet grace au constructeur par defaut");
        ExerciceForce O1 = new ExerciceForce();
        System.out.println(O1); // appele toString pour fonctionner
        System.out.println("--Creation d'un objet grace precis");
        ExerciceForce O2 = new ExerciceForce("developpé couché","pectoraux",3,0,true);
        System.out.println(O2);
        ExerciceForce O3 = new ExerciceForce("developpé couché","pectoraux",5,20, false) ;
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(O2.Equals(O3));
        System.out.println(O2.Equals(O1));
    }

}
