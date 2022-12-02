package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Destroyer extends Bateau{

    //attribut
    private boolean premFois;
    private boolean premFoisordi;

    public boolean isPremFoisordi() {
        return premFoisordi;
    }

    public boolean isPremFois() {
        return premFois;
    }
    public void setPremFoisordi(boolean premFois) {
        this.premFoisordi = premFois;
    }
    public void setPremFois(boolean premFois) {
        this.premFois = premFois;
    }

    public Destroyer(int taille_navire, int id_navire, String nom_navire, boolean Horizontal, int coordonneeDebutX, int coordonneeDebutY){
        super(taille_navire,id_navire,nom_navire,Horizontal,coordonneeDebutX,coordonneeDebutY);
        this.premFois = true;
        this.premFoisordi = true;
    }
    public ArrayList<Case> AttaqueHumainDestroyer(JoueurOrdi Ordi, JoueurHumain Joueur, ArrayList<Case>mapCasesEclairees) {

        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();
        mapDeCases = Ordi.getMapDeCasesOrdi();
        boolean Flag = false;
        System.out.println(premFois);
        if (premFois == true){
            System.out.println("Saisissez la coordonnée que vous souhaitez afficher");
            Scanner scan = new Scanner(System.in);
            System.out.println("Saisissez X:");
            int choixX = scan.nextInt();
            System.out.println("Saisissez Y:");
            int choixY = scan.nextInt();
            for (Integer TY : mapDeCases.keySet()) {
                if (mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY) {
                    Case c = new Case(mapDeCases.get(TY).getX(),mapDeCases.get(TY).getY(),mapDeCases.get(TY).getGetID());
                    mapCasesEclairees.add(c);
                    System.out.println(c.getX() +" " + c.getY() + " "  + c.getGetID());
                }
                if (mapDeCases.get(TY).getX() == choixX  && mapDeCases.get(TY).getY() == choixY -1) {
                    Case c = new Case(mapDeCases.get(TY).getX(),mapDeCases.get(TY).getY(),mapDeCases.get(TY).getGetID());
                    mapCasesEclairees.add(c);
                    System.out.println(c.getX() +" " + c.getY() + " "  + c.getGetID());
                } if (mapDeCases.get(TY).getX() == choixX +1 && mapDeCases.get(TY).getY() == choixY -1) {
                    Case c = new Case(mapDeCases.get(TY).getX(),mapDeCases.get(TY).getY(),mapDeCases.get(TY).getGetID());
                    mapCasesEclairees.add(c);
                    System.out.println(c.getX() +" " + c.getY() + " "  + c.getGetID());
                }
                if (mapDeCases.get(TY).getX() == choixX +1 && mapDeCases.get(TY).getY() == choixY) {
                    Case c = new Case(mapDeCases.get(TY).getX(),mapDeCases.get(TY).getY(),mapDeCases.get(TY).getGetID());
                    mapCasesEclairees.add(c);
                    System.out.println(c.getX() +" " + c.getY() + " "  + c.getGetID());
                }
                setPremFois(premFois = false);
            }}
        else{
            System.out.println("Saisissez la coordonnée que vous souhaitez attaquer");
            Scanner scan = new Scanner(System.in);
            System.out.println("Saisissez X:");
            int choixX = scan.nextInt();
            System.out.println("Saisissez Y:");
            int choixY = scan.nextInt();
            lesCondtions(mapDeCases,choixX,choixY,Flag);
        }


    return mapCasesEclairees;}


    public ArrayList<Case> AttaqueOrdiDestroyer(JoueurOrdi Ordi, JoueurHumain Joueur, ArrayList<Case>mapCasesEclairees) {

        /*System.out.println("Avec quelle bateau souhaitez-vous attaquer ? \n Saisissez son numéro : ");
        Scanner scan = new Scanner(System.in);
        int choix = scan.nextInt();

        switch(choix){
            case 0:

        }*/
        int choixX = (int) (Math.random() * (15)) + 1;
        int choixY = (int) (Math.random() * (15)) + 1;
        System.out.println("L'ordinateur a choisit les coordonnées : X = " + choixX + "et Y = " + choixY);
        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();
        mapDeBateaux = Joueur.getMapDeBateauxHumain();
        mapDeCases = Joueur.getMapDeCasesHumain();
        boolean Flag = false;
        System.out.println(premFoisordi);

        if (premFoisordi == true){
            for (Integer TY : mapDeCases.keySet()) {
                if (mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY) {
                    Case c = new Case(mapDeCases.get(TY).getX(),mapDeCases.get(TY).getY(),mapDeCases.get(TY).getGetID());
                    mapCasesEclairees.add(c);
                    System.out.println(c.getX() +" " + c.getY() + " "  + c.getGetID());
                }
                if (mapDeCases.get(TY).getX() == choixX  && mapDeCases.get(TY).getY() == choixY -1) {
                    Case c = new Case(mapDeCases.get(TY).getX(),mapDeCases.get(TY).getY(),mapDeCases.get(TY).getGetID());
                    mapCasesEclairees.add(c);
                    System.out.println(c.getX() +" " + c.getY() + " "  + c.getGetID());
                } if (mapDeCases.get(TY).getX() == choixX +1 && mapDeCases.get(TY).getY() == choixY -1) {
                    Case c = new Case(mapDeCases.get(TY).getX(),mapDeCases.get(TY).getY(),mapDeCases.get(TY).getGetID());
                    mapCasesEclairees.add(c);
                    System.out.println(c.getX() +" " + c.getY() + " "  + c.getGetID());
                }
                if (mapDeCases.get(TY).getX() == choixX +1 && mapDeCases.get(TY).getY() == choixY) {
                    Case c = new Case(mapDeCases.get(TY).getX(),mapDeCases.get(TY).getY(),mapDeCases.get(TY).getGetID());
                    mapCasesEclairees.add(c);
                    System.out.println(c.getX() +" " + c.getY() + " "  + c.getGetID());
                }
                setPremFoisordi(premFoisordi = false);
            }}
            else{
                lesCondtions(mapDeCases,choixX,choixY,Flag);

            }

        return mapCasesEclairees;}

    void lesCondtions(HashMap<Integer, Case> mapDeCases,int choixX, int choixY,boolean Flag){


            for (Integer TY : mapDeCases.keySet()) {
                if (mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY && mapDeCases.get(TY).getGetID() != 1) {
                    mapDeCases.get(TY).CaseTouche();
                    System.out.println("\nLa case de coordonnées X = " + mapDeCases.get(TY).getX() + " et Y = " + mapDeCases.get(TY).getY() + " a bien été touché");
                    System.out.println("Etat Case Touché = " + mapDeCases.get(TY).EtatCase());
                    Flag = true;
                }
                if (mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY && mapDeCases.get(TY).getGetID() == 1) {
                    System.out.println("\nLa case de coordonnées X = " + mapDeCases.get(TY).getX() + " et Y = " + mapDeCases.get(TY).getY() + " est un sous-marin, il ne peut pas être attaqué par un Destroyer. ");
                    System.out.println("Etat Case Touché = " + mapDeCases.get(TY).EtatCase());
                    Flag = true;
                }
            }
            if (Flag == false) {
                System.out.print("Pas de bateau à cette coordonnée");
            }

       }
}


