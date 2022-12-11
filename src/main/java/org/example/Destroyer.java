package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Dans cette classe, nous implémentons les informations pour le destroyer avec la fonction attaque spécifique.
 */
public class Destroyer extends Bateau {

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

    public Destroyer(int taille_navire, int id_navire, String nom_navire, boolean Horizontal, int coordonneeDebutX, int coordonneeDebutY) {
        super(taille_navire, id_navire, nom_navire, Horizontal, coordonneeDebutX, coordonneeDebutY);
        this.premFois = true;
        this.premFoisordi = true;
    }

    public void AttaqueHumain(JoueurOrdi Ordi, JoueurHumain Joueur, int choixX, int choixY) {

        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();
        mapDeCases = Ordi.getMapDeCasesOrdi();
        boolean Flag = false;
        // REGLER ATTAQUE PARAMETRE
        boolean flag = true;

        System.out.println(premFois);
        if (premFois == true) {

            for (Integer TY : mapDeCases.keySet()) {
                if (mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY) {
                    mapDeCases.get(TY).ONCaseEclairee();
                    System.out.println(mapDeCases.get(TY).getX() + " " + mapDeCases.get(TY).getY() + " " + mapDeCases.get(TY).getCaseEclairee());
                }
                if (mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY - 1) {
                    mapDeCases.get(TY).ONCaseEclairee();
                    System.out.println(mapDeCases.get(TY).getX() + " " + mapDeCases.get(TY).getY() + " " + mapDeCases.get(TY).getCaseEclairee());

                }
                if (mapDeCases.get(TY).getX() == choixX + 1 && mapDeCases.get(TY).getY() == choixY - 1) {
                    mapDeCases.get(TY).ONCaseEclairee();
                    System.out.println(mapDeCases.get(TY).getX() + " " + mapDeCases.get(TY).getY() + " " + mapDeCases.get(TY).getCaseEclairee());

                }
                if (mapDeCases.get(TY).getX() == choixX + 1 && mapDeCases.get(TY).getY() == choixY) {
                    mapDeCases.get(TY).ONCaseEclairee();
                    System.out.println(mapDeCases.get(TY).getX() + " " + mapDeCases.get(TY).getY() + " " + mapDeCases.get(TY).getCaseEclairee());

                }
                setPremFois(premFois = false);
            }
        } else {

            lesCondtions(mapDeCases, choixX, choixY, Flag);
        }
    }


    public void AttaqueOrdi(JoueurOrdi Ordi, JoueurHumain Joueur) {

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

        if (premFoisordi == true) {
            for (Integer TY : mapDeCases.keySet()) {
                if (mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY) {
                    // Case c = new Case(mapDeCases.get(TY).getX(),mapDeCases.get(TY).getY(),mapDeCases.get(TY).getGetID());
                    //mapCasesEclairees.put(mapCasesEclairees.size()-1, c);
                    mapDeCases.get(TY).ONCaseEclairee();
                    System.out.println(mapDeCases.get(TY).getX() + " " + mapDeCases.get(TY).getCaseEclairee());
                }
                if (mapDeCases.get(TY).getX() == choixX && mapDeCases.get(TY).getY() == choixY - 1) {
                    mapDeCases.get(TY).ONCaseEclairee();
                    System.out.println(mapDeCases.get(TY).getX() + " " + mapDeCases.get(TY).getCaseEclairee());
                }
                if (mapDeCases.get(TY).getX() == choixX + 1 && mapDeCases.get(TY).getY() == choixY - 1) {
                    mapDeCases.get(TY).ONCaseEclairee();
                    System.out.println(mapDeCases.get(TY).getX() + " " + mapDeCases.get(TY).getCaseEclairee());
                }
                if (mapDeCases.get(TY).getX() == choixX + 1 && mapDeCases.get(TY).getY() == choixY) {
                    mapDeCases.get(TY).ONCaseEclairee();
                    System.out.println(mapDeCases.get(TY).getX() + " " + mapDeCases.get(TY).getCaseEclairee());
                }
                setPremFoisordi(premFoisordi = false);
            }

        } else {
            lesCondtions(mapDeCases, choixX, choixY, Flag);

        }
    }


    void lesCondtions(HashMap<Integer, Case> mapDeCases, int choixX, int choixY, boolean Flag) {


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


