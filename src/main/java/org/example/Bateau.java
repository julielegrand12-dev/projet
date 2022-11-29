package org.example;

import java.util.ArrayList;

public class Bateau {

    // attribut
    private int id_navire  ;
    private int  coordonneeDebutX ;
    private int coordonneeDebutY ;
    private int coordoX;
    private int coordoY;
    private String nom_navire ;
    private ArrayList<Case> lesCases;
    private int taille_navire ; // le nb de case du bateau
    private boolean Horizontal ; // dans le cas d'un navire vertical, ce sont les lignes x qui déterminent la taille


    public Bateau() {}

    // dans le cas 'un navire horizontal,ce sont les colonnes y qui determinent la taille


    public int getCoordonneeDebutX() {
        return coordonneeDebutX;
    }

    public void setCoordonneeDebutX(int coordonneeDebutX) {
        this.coordonneeDebutX = coordonneeDebutX;
    }

    public int getCoordonneeDebutY() {
        return coordonneeDebutY;
    }

    public void setCoordonneeDebutY(int coordonneeDebutY) {
        this.coordonneeDebutY = coordonneeDebutY;
    }
    public int getCoordoX() {
        return coordoX;
    }

    public int getCoordoY() {
        return coordoY;
    }

    public void setCoordoX(int coordoX) {
        this.coordoX = coordoX;
    }

    public void setCoordoY(int coordoY) {
        this.coordoY = coordoY;
    }

    public ArrayList<Case> getLesCases() {
        return lesCases;
    }

    public void setLesCases(ArrayList<Case> lesCases) {
        this.lesCases = lesCases;
    }

    public boolean isHorizontal() {
        return Horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        Horizontal = horizontal;
    }
// getter et setter

    public int getTaille_navire() {
        return taille_navire;
    }

    public void setTaille_navire(int taille_navire) {
        this.taille_navire = taille_navire;
    }

    public int getId_navire() {
        return id_navire;
    }

    public void setId_navire(int id_navire) {
        this.id_navire = id_navire;
    }

    public String getNom_navire() {
        return nom_navire;
    }

    public void setNom_navire(String nom_navire) {
        this.nom_navire = nom_navire;
    }

    public ArrayList<Case> getlesCases() {
        return lesCases;
    }

    public void setlesCases(Case[][] lesCases) {
        Bateau.this.lesCases = Bateau.this.lesCases;
    }

    //methodes et constructeurs


    public boolean estCouler(){
        for (int i = 0; i<lesCases.size();i++){
            if(this.lesCases.get(i).EtatCase()){
                return true;
            }
        }return false;
    }

    public Bateau( int taille_navire,int id_navire, String nom_navire, boolean Horizontal, int coordonneeDebutX, int coordonneeDebutY){
        this.id_navire = id_navire ;
        this.nom_navire = nom_navire ;
        this.taille_navire = taille_navire ;
        this.Horizontal = Horizontal ;
        this.coordonneeDebutX  = coordonneeDebutX ;
        this.coordonneeDebutY = coordonneeDebutY ;
    }

   /* public static void declaBateaux(String[][] Bateau) { // Declaration des bateaux
          Bateau B1 = new Bateau("7","1","Cruisarde");
          Bateau B2 = new Bateau("5", "2", "Croiseur");
          Bateau B3 = new Bateau("5", "3", "Croiseur");
          Bateau B4 = new Bateau("3", "4", "Destroyer");
          Bateau B5 = new Bateau("3", "5", "Destroyer");
          Bateau B6 = new Bateau("3", "6", "Destroyer");
          Bateau B7 = new Bateau("1", "7", "Sous-marin");
          Bateau B8 = new Bateau("1", "8", "Sous-marin");
          Bateau B9 = new Bateau("1", "9", "Sous-marin");
          Bateau B10 = new Bateau("1", "10", "Sous-marin");
    };
*/


    public void genererBateaux(){

    }


}
