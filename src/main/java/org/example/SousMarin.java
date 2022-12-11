package org.example;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Dans cette classe, nous implémentons les informations pour le sous-marin avec la fonction attaque spécifique.
 */

public class SousMarin extends Bateau {

    // attribut

    //méthodes et  constrcteurs 
    public SousMarin(int taille_navire, int id_navire, String nom_navire, boolean Horizontal, int coordonneeDebutX, int coordonneeDebutY) {
        super(taille_navire, id_navire, nom_navire, Horizontal, coordonneeDebutX, coordonneeDebutY);
    }

    public void AttaqueHumain(JoueurOrdi Ordi, JoueurHumain Joueur, int choixX, int choixY) {

        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();
        mapDeCases = Ordi.getMapDeCasesOrdi();
        boolean Flag = false;

        for (Integer TY : mapDeCases.keySet()) {
            if (mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY) {
                mapDeCases.get(TY).CaseTouche();
                 Flag = true;
            }
        }

    }

    public void AttaqueOrdi(JoueurOrdi Ordi, JoueurHumain Humain) {

        int choixX = (int) (Math.random() * (15)) + 1;
        int choixY = (int) (Math.random() * (15)) + 1;
        System.out.println("L'ordinateur a choisit les coordonnées : X = " + choixX + "et Y = " + choixY);
        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();
        mapDeBateaux = Humain.getMapDeBateauxHumain();
        mapDeCases = Humain.getMapDeCasesHumain();
        boolean Flag = false;

        for (Integer TY : mapDeCases.keySet()) {
            if (mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY) {
                mapDeCases.get(TY).CaseTouche();
                Flag = true;
            }
        }
    }
}
