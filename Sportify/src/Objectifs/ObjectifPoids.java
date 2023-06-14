package Objectifs;

public class ObjectifPoids extends Objectif{
    private float poidsSouhaite ;

    public float getPoidsSouhaite() {
        return poidsSouhaite;
    }

    public void setPoidsSouhaite(float poidsSouhaite) {
        this.poidsSouhaite = poidsSouhaite;
    }

    public ObjectifPoids()
    {
        super();
        setPoidsSouhaite(75);
    }
    public ObjectifPoids(String n , String d , float p)
    {
        super(n,d);
        setPoidsSouhaite(p);
    }

    @Override
    public String toString() {
        return getNom() + " ,target weight: " + poidsSouhaite + "kg, date :" + getDateSouhaite();
    }

    @Override
    public boolean Equals(Objectif obj) {
        return super.Equals(obj);
    }

    public static void main(String[] args) {

        System.out.println("--Creation d'un objet grace au constructeur par defaut");
        ObjectifPoids O1 = new ObjectifPoids();
        System.out.println(O1); // appele toString pour fonctionner
        System.out.println("--Creation d'un objet grace precis");

        ObjectifPoids O2 = new ObjectifPoids("perdre 1 kg", "12 mai",78);
        System.out.println(O2);
        ObjectifPoids O3 = new ObjectifPoids("perdre 1 kg", "12 mai", 0) ;
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(" entre objet 2 et 3 : "+O2.Equals(O3));
        System.out.println("entre objet 2 et 1 : " +O2.Equals(O1));
    }
}
