package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //Appel objets d'une classe

        ArrayList<Case> mapdecaseseclairees = new ArrayList<Case>();
        Menu M = new Menu('0');


        //Déclaration HashMap
        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();

        //Affichage du début
        System.out.println("JEU - BATAILLE NAVALE");
        System.out.println("Jeu réalisé par Julie Legrand - Ludivine Fulop - Sara Suleiman");

        //Appel de fonctions dans les classes

     /*  O.PlacementCasesHumain(mapDeCases,mapDeBateaux);
        O.PlacementBateauxHumain(mapDeBateaux);
       O.setMapDeBateauxOrdi(mapDeBateaux);
        O.setMapDeCasesOrdi(mapDeCases);*/

        //System.out.print(Cuirasse.getCoordonneeDebutX());
       //mapDeBateaux.get(0).AttaqueHumain(O,J);
       // System.out.println(mapDeBateaux.get(1).getNom_navire());
       // mapDeBateaux.get(1).AttaqueHumain(O,J);
      //  mapDeBateaux.get(5).AttaqueHumainDestroyer(O,J, mapdecaseseclairees);

       // mapDeBateaux.get(5).AttaqueOrdiDestroyer(O,J,mapdecaseseclairees);
       // mapDeBateaux.get(5).AttaqueOrdiDestroyer(O,J, mapdecaseseclairees);
      /*  for (Integer  TY : mapDeCases.keySet()){
        System.out.println(mapDeCases.get(mapDeCases.get(TY)));}
        //J.DeplacerBateau(mapDeBateaux);
       /* for (Integer TY : mapDeBateaux.keySet()) {
            System.out.println("Bateau n." + TY + " de nom = " + mapDeBateaux.get(TY).getNom_navire() + " D'id : " + mapDeBateaux.get(TY).getId_navire() + " de taille = " + mapDeBateaux.get(TY).getTaille_navire() + "\n, de direction horizontale : " + mapDeBateaux.get(TY).isHorizontal() + "\n, de coordonnées debut x = " + mapDeBateaux.get(TY).getCoordonneeDebutX() + " et y = " + mapDeBateaux.get(TY).getCoordonneeDebutY() + "\n\n");

        }*/
        /*for(Integer i : mapDeCases.keySet()){
            System.out.println("Case n."+i+ " de Coordonnée X = "+ mapDeCases.get(i).getX() + " "  + " et coordonnée Y = " + mapDeCases.get(i).getY() + "   " + mapDeCases.get(i).getGetID());
        }*/
      /*  JoueurHumain JoueurH = new JoueurHumain("Personne", 0);
        JoueurOrdi JoueurO = new JoueurOrdi("Ordinateur", 0);
        JoueurH.setMapDeCasesHumain(mapDeCases);
        JoueurH.setMapDeBateauxHumain(mapDeBateaux);
        JoueurH.PlacementCasesHumain(mapDeCases, mapDeBateaux);
        JoueurH.PlacementBateauxHumain(mapDeBateaux);*/
        //Appel des menus
      M.MenuDebut();
        //M.MenuBateau(JoueurH,JoueurO);
  }
}