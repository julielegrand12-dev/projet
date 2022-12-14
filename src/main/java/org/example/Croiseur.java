package org.example;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Dans cette classe, nous implémentons les informations pour le croiseur avec la fonction attaque spécifique.
 */
public class Croiseur extends Bateau {
    public Croiseur(int taille_navire, int id_navire, String nom_navire, boolean Horizontal, int coordonneeDebutX, int coordonneeDebutY) {
        super(taille_navire, id_navire, nom_navire, Horizontal, coordonneeDebutX, coordonneeDebutY);
    }

    public void AttaqueHumain(JoueurOrdi Ordi, JoueurHumain Humain, int choixX, int choixY) {

        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();
        mapDeBateaux = Ordi.getMapDeBateauxOrdi();
        mapDeCases = Ordi.getMapDeCasesOrdi();
        boolean Flag = false;
        lesConditions(mapDeCases, choixX, choixY, Flag);

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
        lesConditions(mapDeCases, choixX, choixY, Flag);
    }

    void lesConditions(HashMap<Integer, Case> mapDeCases, int choixX, int choixY, boolean Flag) {
        for (Integer TY : mapDeCases.keySet()) {
            if (mapDeCases.get(TY).getX() == choixX + 1 && mapDeCases.get(TY).getY() == choixY && mapDeCases.get(TY).getGetID() != 1) {
                mapDeCases.get(TY).CaseTouche();
                Flag = true;
            }
            if (mapDeCases.get(TY).getX() == choixX + 1 && mapDeCases.get(TY).getY() == choixY - 1 && mapDeCases.get(TY).getGetID() != 1) {
                mapDeCases.get(TY).CaseTouche();
                Flag = true;
            }
            if ((mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY - 1 && mapDeCases.get(TY).getGetID() != 1)) {
                mapDeCases.get(TY).CaseTouche();
                 Flag = true;
            }
            if ((mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY && mapDeCases.get(TY).getGetID() != 1)) {
                mapDeCases.get(TY).CaseTouche();
                 Flag = true;
            }
            if ((mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY && mapDeCases.get(TY).getGetID() == 1)) {
                System.out.println("\nLa case de coordonnées X = " + mapDeCases.get(TY).getX() + " et Y = " + mapDeCases.get(TY).getY() + " est un sous-marin, il ne peut pas être attaqué par un croiseur. ");
                 Flag = true;
            }
            if ((mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY - 1 && mapDeCases.get(TY).getGetID() == 1)) {
                System.out.println("\nLa case de coordonnées X = " + mapDeCases.get(TY).getX() + " et Y = " + mapDeCases.get(TY).getY() + " est un sous-marin, il ne peut pas être attaqué par un croiseur. ");
                 Flag = true;
            }
            if ((mapDeCases.get(TY).getX() == choixX + 1 && mapDeCases.get(TY).getY() == choixY - 1 && mapDeCases.get(TY).getGetID() == 1)) {
                System.out.println("\nLa case de coordonnées X = " + mapDeCases.get(TY).getX() + " et Y = " + mapDeCases.get(TY).getY() + " est un sous-marin, il ne peut pas être attaqué par un croiseur. ");
                Flag = true;
            }
            if (mapDeCases.get(TY).getX() == choixX + 1 && mapDeCases.get(TY).getY() == choixY && mapDeCases.get(TY).getGetID() == 1) {
                System.out.println("\nLa case de coordonnées X = " + mapDeCases.get(TY).getX() + " et Y = " + mapDeCases.get(TY).getY() + " est un sous-marin, il ne peut pas être attaqué par un croiseur. ");
                Flag = true;
            }
        }

    }
}
