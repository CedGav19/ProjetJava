package ExercicesClass;

public class ExerciceForce extends Exercice {

    private int poids ;

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getPoids() {
        return poids;
    }


    public ExerciceForce()
    {
        super();
        setPoids(0);
    }
    public ExerciceForce(String n , String m , int sc , int tps , int pds )
    {
        super( n ,  m , sc , tps);
        setPoids(pds);
    }

    @Override
    public String toString() {
        String tmp = super.toString();
        return tmp+"," + getPoids() ;

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
        ExerciceForce O2 = new ExerciceForce("developpé couché","pectoraux",3,0,1);
        System.out.println(O2);
        ExerciceForce O3 = new ExerciceForce("developpé couché","pectoraux",5,20, 2) ;
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(O2.Equals(O3));
        System.out.println(O2.Equals(O1));
    }

}
