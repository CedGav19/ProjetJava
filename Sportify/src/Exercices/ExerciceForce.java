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
    }
    public ExerciceForce(String n , String m , int sc , int tps , boolean poly )
    {
        super( n ,  m , sc , tps);
        setPolyarticulaire(poly);
    }

    @Override
    public String toString() {
        return
                super.toString()
                +"Exercices.ExerciceForce{" +
                "polyarticulaire=" + polyarticulaire +
                '}';
    }
    public boolean Equals(Exercice obj)
    {
        if(this.getNom() == obj.getNom())
            return true ;
        else
            return false;
    }

}
