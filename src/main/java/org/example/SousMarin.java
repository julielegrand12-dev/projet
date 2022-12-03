package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class SousMarin extends Bateau{

    // attribut

    //méthodes et  constrcteurs 
    public SousMarin( int taille_navire,int id_navire, String nom_navire, boolean Horizontal, int coordonneeDebutX, int coordonneeDebutY){
        super(taille_navire,id_navire,nom_navire,Horizontal,coordonneeDebutX,coordonneeDebutY);
    }

    public void AttaqueHumain(JoueurOrdi Ordi, JoueurHumain Joueur){
        System.out.println("Saisissez la coordonnée que vous souhaitez attaquer");
        Scanner scan = new Scanner(System.in);
        System.out.println("Saisissez X:");
        int choixX = scan.nextInt();
        System.out.println("Saisissez Y:");
        int choixY = scan.nextInt();
        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();
        mapDeCases = Ordi.getMapDeCasesOrdi();
        boolean Flag = false;

        for (Integer TY : mapDeCases.keySet()) {
            if(mapDeCases.get(TY).getX() == choixX  && mapDeCases.get(TY).getY() == choixY ){
                mapDeCases.get(TY).CaseTouche();
                System.out.println("\nLa case de coordonnées X = " + mapDeCases.get(TY).getX() + " et Y = " + mapDeCases.get(TY).getY() + " a bien été touché");
                System.out.println("Etat Case Touché = " + mapDeCases.get(TY).EtatCase());
                Flag = true;
            }}

        if(Flag == false){System.out.print("Pas de bateau à cette coordonnée");}


    }
    public void AttaqueOrdi(JoueurOrdi Ordi, JoueurHumain Humain) {

        int choixX = (int) (Math.random() * (15)) + 1;
        int choixY = (int) (Math.random() * (15)) + 1;
        System.out.println("L'ordinateur a choisit les coordonnées : X = " + choixX + "et Y = " + choixY );
        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();
        mapDeBateaux = Humain.getMapDeBateauxHumain();
        mapDeCases = Humain.getMapDeCasesHumain();
        boolean Flag = false;

        for (Integer TY : mapDeCases.keySet()) {
                if (mapDeCases.get(TY).getX() == choixX  && mapDeCases.get(TY).getY() == choixY ) {
                    mapDeCases.get(TY).CaseTouche();
                    System.out.println("\nLa case de coordonnées X = " + mapDeCases.get(TY).getX() + " et Y = " + mapDeCases.get(TY).getY() + " a bien été touché");
                    System.out.println("Etat Case Touché = " + mapDeCases.get(TY).EtatCase());
                    Flag = true;
                }}
            if(Flag == false){System.out.print("Pas de bateau à cette coordonnée");}
}
}