package org.example;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Bateau implements Serializable {

    // attribut
    private int id_navire  ;
    private int  coordonneeDebutX ;
    private int coordonneeDebutY ;

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

    public void setLesCases(ArrayList<Case> lesCases) {
        this.lesCases = lesCases;
    }

    //methodes et constructeurs

    public boolean BateauACouler(HashMap<Integer, Case> MapDeCases, int choix, HashMap<Integer,Bateau> MapDeBateaux){
        boolean flag = false;
        int compte = 0;
        for(int da =0;da<MapDeBateaux.get(choix).getlesCases().size();da++){
            if(MapDeBateaux.get(choix).getlesCases().get(da).EtatCase() == true){
                flag =true;
                compte =compte +1;
            }
        }
    if(compte == MapDeBateaux.get(choix).getlesCases().size()){ return true ;}
        else{return false;}
    }

    public boolean flotteACouler(HashMap<Integer, Case> MapDeCases,HashMap<Integer,Bateau> MapDeBateaux) {
        int compte =0;
        for(int i = 0;i<10;i++){
        for(int da =0;da<MapDeBateaux.get(i).getlesCases().size();da++){
            if(MapDeBateaux.get(i).getlesCases().get(da).EtatCase() == true){
                compte =compte +1;
            }}}
        if(compte== 30){
            return true;
        }else{return false;}
    }

    public Bateau( int taille_navire,int id_navire, String nom_navire, boolean Horizontal, int coordonneeDebutX, int coordonneeDebutY){
        this.id_navire = id_navire ;
        this.nom_navire = nom_navire ;
        this.taille_navire = taille_navire ;
        this.Horizontal = Horizontal ;
        this.coordonneeDebutX  = coordonneeDebutX ;
        this.coordonneeDebutY = coordonneeDebutY ;
    }
    public void genererBateaux(){}

    public void AttaqueHumain(JoueurOrdi o, JoueurHumain j, int choixX, int choixY){}

    public void AttaqueOrdi(JoueurOrdi o, JoueurHumain j) {}
}
