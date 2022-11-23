package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        System.out.println("JEU - BATAILLE NAVALE");
        System.out.println("Jeu réalisé par Julie Legrand - Ludivine Fulop - Sara Suleiman");
        JoueurHumain J = new JoueurHumain("Sara",0);
        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();
        J.setMapDeCases(mapDeCases);
        J.PlacementCases(mapDeCases, mapDeBateaux);
        J.setMapDeBateaux(mapDeBateaux);
        J.PlacementBateaux(mapDeBateaux);


        /*for(Integer i : mapDeCases.keySet()){
            System.out.println("Case n."+i+ " de Coordonnée X = "+ mapDeCases.get(i).getX() + " "  + " et coordonnée Y = " + mapDeCases.get(i).getY() + "   " + mapDeCases.get(i).getGetID());
        }*/

        //Menu M = new Menu();
        //M.MenuDebut();

  }
}