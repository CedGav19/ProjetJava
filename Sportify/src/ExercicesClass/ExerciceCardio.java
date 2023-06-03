package ExercicesClass;

public class ExerciceCardio extends Exercice {
    private int distance ;

    public void setDistance(int distance) {
        if(distance>0) this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public ExerciceCardio()
    {
        super();
        setDistance(0);
    }
    public ExerciceCardio(String n , String m , int sc , int tps , int d )
    {
        super(n,m,sc,tps);
        setDistance(d);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + distance + " m";

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
        ExerciceCardio O1 = new ExerciceCardio();
        System.out.println(O1); // appele toString pour fonctionner
        System.out.println("--Creation d'un objet grace precis");
        ExerciceCardio O2 = new ExerciceCardio("Course a pied ","tout",3,0,1000);
        System.out.println(O2);
        ExerciceCardio O3 = new ExerciceCardio("Course a pied ","tout",5,20, 20) ;
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(O2.Equals(O3));
        System.out.println(O2.Equals(O1));
    }
}
