package org.example;

public class Case {
    // attribut

    private int x_ligne; //coordonnées x
    private int y_colonne; //coordonnées y
    private boolean EtatCase; //etat de la case
    private int ID; //identifiant de la case

    // getter et setter
    public int getX() {
        return this.x_ligne;
    }

    public int getY() {
        return this.y_colonne;
    }
    public int getGetID() {
        return ID;
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

    // méthodes

    public Case(int x, int y,int id){
        this.x_ligne = x ;
        this.y_colonne = y;
        this.ID = id; // initialise à 0
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
