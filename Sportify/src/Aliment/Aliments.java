package Aliment;

public class Aliments {

    private int kcal ;
    private float proteine ;
    private String type;
    private String nom ;
    private int score ;

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
        return "Aliment.Aliments{" +
                "kcal=" + kcal +
                ", proteine=" + proteine +
                ", type='" + type + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

    public boolean Equals(Aliments obj)
    {
        if(this.nom == obj.nom)
            return true ;
        else
            return false;
    }


    public static void main(String[] args) {
        
    }
}
