package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //Appel objets d'une classe

        JoueurHumain J = new JoueurHumain("Sara",0);
        Menu M = new Menu('0');

        //Déclaration HashMap
        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();

        //Affichage du début
        System.out.println("JEU - BATAILLE NAVALE");
        System.out.println("Jeu réalisé par Julie Legrand - Ludivine Fulop - Sara Suleiman");

        //Appel de fonctions dans les classes

        J.setMapDeBateaux(mapDeBateaux);
        J.PlacementBateaux(mapDeBateaux);

        /*for(Integer i : mapDeCases.keySet()){
            System.out.println("Case n."+i+ " de Coordonnée X = "+ mapDeCases.get(i).getX() + " "  + " et coordonnée Y = " + mapDeCases.get(i).getY() + "   " + mapDeCases.get(i).getGetID());
        }*/

        //Appel des menus
        //M.MenuDebut();
        M.MenuBateau();

  }
}