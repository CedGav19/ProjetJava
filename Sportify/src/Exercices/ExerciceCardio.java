package Exercices;

import Aliment.Aliments;

public class ExerciceCardio extends Exercice {
    private int distance ;

    public void setDistance(int distance) {
        if(distance>0) distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public ExerciceCardio()
    {
        super();
    }
    public ExerciceCardio(String n , String m , int sc , int tps , int d )
    {
        super( n ,  m , sc , tps);
        setDistance(d);
    }

    @Override
    public String toString() {
        return
                super.toString()
                        +"Exercices.ExerciceForce{" +
                        "polyarticulaire=" + getDistance() +
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
