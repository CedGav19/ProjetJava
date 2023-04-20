package Objectifs;

public class Objectif {
    private boolean accompli ;
    private String dateSouhaite ;

    public void setAccompli(boolean accompli) {
        this.accompli = accompli;
    }
    public void setDateSouhaite(String dateSouhaite) {
        this.dateSouhaite = dateSouhaite;
    }

    public String getDateSouhaite() {
        return dateSouhaite;
    }
    public boolean getAccompli()
    {
        return accompli;
    }

    @Override
    public String toString() {
        return "Objectif{" +
                "accompli=" + accompli +
                ", dateSouhaite='" + dateSouhaite + '\'' +
                '}';
    }
}
