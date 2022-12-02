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


    public void genererBateaux(){


    }

    public void AttaqueHumain(JoueurOrdi o, JoueurHumain j){}

    public ArrayList<Case> AttaqueHumainDestroyer(JoueurOrdi o, JoueurHumain j, ArrayList<Case> mapdecaseseclarees ){return mapdecaseseclarees;}
    public ArrayList<Case> AttaqueOrdiDestroyer(JoueurOrdi o, JoueurHumain j, ArrayList<Case> mapdecaseseclarees ){return mapdecaseseclarees;}



    public void AttaqueOrdi(JoueurOrdi o, JoueurHumain j) {
    }
}
