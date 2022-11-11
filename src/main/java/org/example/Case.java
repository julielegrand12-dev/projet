package org.example;

public class Case {
    // attribut

    private int x_ligne ;
    private int y_colonne ;
    private boolean EtatCase; // C'est l'état de la case (
    private int ID ;

    // getter et setter
    public int getX() {
        return x_ligne;
    }

    public int getY() {
        return y_colonne;
    }

    public void setGetID(int getID) {
        this.ID = ID;
    }

    public void setX(int x) {
        this.x_ligne = x;
    }

    public void setY(int y) {
        this.y_colonne = y;
    }

    public int getGetID() {
        return ID;
    }

    // méthodes

    public Case(int x, int y){
        this.x_ligne = x ;
        this.y_colonne = y;
        this.ID = 0; // initialise à 0
        this.EtatCase = false ; // initialise à 'pas coulé'

    }
    public boolean EtatCase() {
        return this.EtatCase ;
    }
    public void CaseTouche() { // Lorsque la case a été touché on passe à boolean true
        this.EtatCase = true ;
    }

    public void NewBateau(int ID){
        this.ID =  ID;
    }

}