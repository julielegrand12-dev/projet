package org.example;

import java.util.ArrayList;
import java.util.HashMap;

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

    public boolean BateauACouler(HashMap<Integer, Case> MapDeCases, int choix){
        boolean flag = false;
        if (choix == 0) {
            for (int i = 0; i < 7; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                   flag =true;
                }
            }
        }
        if (choix == 1) {
            for (int i = 7; i < 12; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                   flag=true;
                }
            }
        }
        if (choix == 2) {
            for (int i = 12; i < 17; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    flag = true;
                }
            }
        }
        if (choix == 3) {
            for (int i = 17; i < 20; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    flag = true;
                }
            }
        }
        if (choix == 4) {
            for (int i = 20; i < 23; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                   flag = true;
                }
            }
        }
        if (choix == 5) {
            for (int i = 23; i < 26; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    flag = true;
                }
            }
        }
        if (choix == 6) {
            for (int i = 26; i < 27; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                   flag = true;
                }
            }
        }
        if (choix == 7) {
            for (int i = 27; i < 28; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    flag = true;
                }
            }
        }
        if (choix == 8) {
            for (int i = 28; i < 29; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    flag = true;
                }
            }
        }
        if (choix == 9) {
            for (int i = 29; i < 30; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    flag = true;
                }
            }
    }if(flag == true){ return true ;}
        else{return false;}
    }

    public boolean flotteACouler(HashMap<Integer, Case> MapDeCases) {
        boolean B0 = false, B1 = false, B2 = false, B3 = false, B4 = false, B5 = false, B6 = false, B7 = false, B8 = false, B9 = false;
        for(int a=0; a<=9; a++){
        if (a == 0) {
            for (int i = 0; i < 7; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    B0 = true;
                }
            }
        }
        if (a == 1) {
            for (int i = 7; i < 12; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    B1 = true;
                }
            }
        }
        if (a == 2) {
            for (int i = 12; i < 17; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    B2 = true;
                }
            }
        }
        if (a == 3) {
            for (int i = 17; i < 20; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    B3 = true;
                }
            }
        }
        if (a == 4) {
            for (int i = 20; i < 23; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    B4 = true;
                }
            }
        }
        if (a == 5) {
            for (int i = 23; i < 26; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    B5 = true;
                }
            }
        }
        if (a == 6) {
            for (int i = 26; i < 27; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    B6 = true;
                }
            }
        }
        if (a == 7) {
            for (int i = 27; i < 28; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    B7 = true;
                }
            }
        }
        if (a == 8) {
            for (int i = 28; i < 29; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    B8 = true;
                }
            }
        }
        if (a == 9) {
            for (int i = 29; i < 30; i++) {
                if (MapDeCases.get(i).EtatCase()) {
                    B9 = true;
                }
            }
        }}
        if(B0 == true && B1 == true&& B2 ==true && B3 == true&& B4 == true && B5 == true && B6 == true && B7 == true  && B8 == true && B9 == true){
            return true;
        }else{
            return false;
        }
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

    public void AttaqueHumain(JoueurOrdi o, JoueurHumain j){}

    public ArrayList<Case> AttaqueHumainDestroyer(JoueurOrdi o, JoueurHumain j, ArrayList<Case> mapdecaseseclarees ){return mapdecaseseclarees;}
    public ArrayList<Case> AttaqueOrdiDestroyer(JoueurOrdi o, JoueurHumain j, ArrayList<Case> mapdecaseseclarees ){return mapdecaseseclarees;}

    public void AttaqueOrdi(JoueurOrdi o, JoueurHumain j) {}
}
