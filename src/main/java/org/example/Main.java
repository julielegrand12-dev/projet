package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //Appel objets d'une classe


        Menu M = new Menu('0');

        //Déclaration HashMap
        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();

        //Affichage du début
        System.out.println("JEU - BATAILLE NAVALE");
        System.out.println("Jeu réalisé par Julie Legrand - Ludivine Fulop - Sara Suleiman");

        //Appel de fonctions dans les classes
        /*J.setMapDeCases(mapDeCases);
        J.setMapDeBateaux(mapDeBateaux);
        J.PlacementCases(mapDeCases, mapDeBateaux);
        J.PlacementBateaux(mapDeBateaux);*/
        //J.DeplacerBateau(mapDeBateaux);
       /* for (Integer TY : mapDeBateaux.keySet()) {
            System.out.println("Bateau n." + TY + " de nom = " + mapDeBateaux.get(TY).getNom_navire() + " D'id : " + mapDeBateaux.get(TY).getId_navire() + " de taille = " + mapDeBateaux.get(TY).getTaille_navire() + "\n, de direction horizontale : " + mapDeBateaux.get(TY).isHorizontal() + "\n, de coordonnées debut x = " + mapDeBateaux.get(TY).getCoordonneeDebutX() + " et y = " + mapDeBateaux.get(TY).getCoordonneeDebutY() + "\n\n");


        }*/
        /*for(Integer i : mapDeCases.keySet()){
            System.out.println("Case n."+i+ " de Coordonnée X = "+ mapDeCases.get(i).getX() + " "  + " et coordonnée Y = " + mapDeCases.get(i).getY() + "   " + mapDeCases.get(i).getGetID());
        }*/

        //Appel des menus
        M.MenuDebut();
       // M.MenuBateau();
       // M.MenuDebut();
       //M.MenuBateau();
  }
}