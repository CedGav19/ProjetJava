package Aliment;

public class Aliments {

    private int kcal ;
    private float proteine ;
    private String type;
    private String nom ;
    private int score ;

    public Aliments()
    {
        setNom("inconnu");
        setType("inconnu");
        setKcal(0);
        setProteine(0);
        setScore(0);
    }
    public Aliments(String n , String t , int k ,float p , int s)
    {
        setNom(n);
        setType(t);
        setKcal(k);
        setProteine(p);
        setScore(s);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setScore(int score) {
       if(score <= 5 && score >=0) this.score = score;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public void setProteine(float proteine) {
        this.proteine = proteine;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public float getProteine() {
        return proteine;
    }

    public int getKcal() {
        return kcal;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return getNom()+ ", "+getKcal()+" kcal, " + getProteine()+"g " ;
    }

    public boolean Equals(Aliments obj)
    {
        if(this.nom == obj.nom)
            return true ;
        else
            return false;
    }



    public static void main(String[] args) {

        System.out.println("--Creation d'un objet grace au constructeur par defaut");
        Aliments O1 = new Aliments();
        System.out.println(O1); // appele toString pour fonctionner
        System.out.println("--Creation d'un objet grace precis");
        Aliments O2 = new Aliments("carotte","legume",100,2,4 );
        System.out.println(O2);
        Aliments O3 = new Aliments("carotte","inconnu",12,20,1) ;
        System.out.println(O3);
        System.out.println("--utilisation du Equals");
        System.out.println(O2.Equals(O3));
        System.out.println(O2.Equals(O1));

        
    }
}
