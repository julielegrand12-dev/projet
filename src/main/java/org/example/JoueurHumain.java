package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.*;

public class JoueurHumain //initialisation de la classe joueur humain
{
    private String pseudo;
    private int score;
    private HashMap<Integer, Case> mapDeCasesHumain = new HashMap<>();
    private HashMap<Integer, Bateau> mapDeBateauxHumain = new HashMap<>();

    public HashMap<Integer, Bateau> getMapDeBateauxHumain() {
        return mapDeBateauxHumain;
    }

    public void setMapDeBateauxHumain(HashMap<Integer, Bateau> mapDeBateaux) {
        this.mapDeBateauxHumain = mapDeBateaux;
    }


    public void setMapDeCasesHumain(HashMap<Integer, Case> mapDeCases) {
        this.mapDeCasesHumain = mapDeCases;
    }

    public HashMap<Integer, Case> getMapDeCasesHumain() {
        return mapDeCasesHumain;
    }

    //Déclaration du constructeur
    public JoueurHumain(String pseudo, int score) {
        this.pseudo = pseudo;
        this.score = score;
    }

    //Déclaration des getters
    public String getPseudo() {
        return pseudo;
    }

    public int getScore() {
        return score;
    }

    //Déclaration des setters
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setScore(int score) {
        this.score = score;
    }

    void PlacementCasesHumain(HashMap<Integer, Case> MapDeCases, HashMap<Integer, Bateau> MapDeBateaux) {

        //Initialisation de la fonction aléatoire
        Random alea = new Random();


        //On déclare des listes
        List<Integer> lesTailles = new ArrayList<>(List.of(7, 5, 5, 3, 3, 3, 1, 1, 1, 1));
        ArrayList<Case> listeCases = new ArrayList<>();
        int y = 0;
        int x = 0;

        //On boucle 10 fois pour les 10 bateaux
        for (int i = 0; i < 10; i++) {
            int int_random = alea.nextInt(2);
            boolean Horizontal;
            int taille_bateau = lesTailles.get(i);
            int limite = 15 - taille_bateau;


            if (int_random == 0) {
                Horizontal = true;

                x = (int) (Math.random() * (15 - limite)) + 1;
                y = (int) (Math.random() * (15)) + 1;

                for (int a = 0; a <= taille_bateau; a++) {
                    for (int w = 0; w < listeCases.size(); w++) {
                        while (listeCases.get(w).getX() == x + a && listeCases.get(w).getY() == y) {
                            x = (int) (Math.random() * (15 - limite)) + 1;
                            y = (int) (Math.random() * (15)) + 1;
                            System.out.println("\n\nerrorororororororo");
                            a = 0;
                            break;

                        }
                    }
                }
                if (lesTailles.get(i) == 7) {

                    Bateau B = new Cuirasse(lesTailles.get(i), i, "Cuirasse", Horizontal, x + 1, y);

                    MapDeBateaux.put(i, B);
                }
                if (lesTailles.get(i) == 5) {

                    Bateau B = new Croiseur(lesTailles.get(i), i, "Croiseur", Horizontal, x + 1, y);

                    MapDeBateaux.put(i, B);
                }
                if (lesTailles.get(i) == 3) {

                    Bateau B = new Destroyer(lesTailles.get(i), i, "Destroyer", Horizontal, x + 1, y);

                    MapDeBateaux.put(i, B);
                }
                if (lesTailles.get(i) == 1) {

                    Bateau B = new SousMarin(lesTailles.get(i), i, "Sous-marin", Horizontal, x + 1, y);

                    MapDeBateaux.put(i, B);
                }

            } else {
                Horizontal = false;

                x = (int) (Math.random() * (15)) + 1;
                y = (int) (Math.random() * (15 - limite)) + 1;
                //System.out.println("X  : " + x + " Y : " + y);
                for (int a = 0; a <= taille_bateau; a++) {
                    for (int w = 0; w < listeCases.size(); w++) {
                        while (listeCases.get(w).getX() == x && listeCases.get(w).getY() == y + a) {

                            x = (int) (Math.random() * (15)) + 1;
                            y = (int) (Math.random() * (15 - limite)) + 1;
                            System.out.println("\n\nERRor");
                            a = 0;
                            break;


                        }
                    }
                }
                if (lesTailles.get(i) == 7) {

                    Bateau B = new Cuirasse(lesTailles.get(i), i, "Cuirasse", Horizontal, x, y + 1);

                    MapDeBateaux.put(i, B);
                }
                if (lesTailles.get(i) == 5) {

                    Bateau B = new Croiseur(lesTailles.get(i), i, "Croiseur", Horizontal, x, y + 1);

                    MapDeBateaux.put(i, B);
                }
                if (lesTailles.get(i) == 3) {

                    Bateau B = new Destroyer(lesTailles.get(i), i, "Destroyer", Horizontal, x, y + 1);

                    MapDeBateaux.put(i, B);
                }
                if (lesTailles.get(i) == 1) {

                    Bateau B = new SousMarin(lesTailles.get(i), i, "Sous-marin", Horizontal, x, y + 1);

                    MapDeBateaux.put(i, B);
                }

            }

            int compte = i;
            compte = compte + 1;
            if (lesTailles.get(i) == 7) {
                System.out.println("\nPlacement du Cuirasse " + compte);
                for (int z = 0; z < 7; z++) {
                    if (Horizontal) {
                        Case c = new Case(x = x + 1, y, lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);

                    }
                    if (!Horizontal) {
                        Case c = new Case(x, y = y + 1, lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);

                    }
                }
                }




            if (lesTailles.get(i) == 5) {
                System.out.println("\nPlacement du Croiseur " + compte++);
                for (int z = 7; z < 12; z++) {
                    if (Horizontal) {
                        Case c = new Case(x = x + 1, y, lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);

                    }
                    if (!Horizontal) {
                        Case c = new Case(x, y = y + 1, lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);

                    }

                }
            }

            if (lesTailles.get(i) == 3) {
                System.out.println("\nPlacement du Destroyer " + compte++);
                for (int z = 12; z < 15; z++) {
                    if (Horizontal == true) {
                        Case c = new Case(x = x + 1, y, lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);

                    }
                    if (Horizontal == false) {
                        Case c = new Case(x, y = y + 1, lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);

                    }

                }

            }
            if (lesTailles.get(i) == 1) {
                System.out.println("\nPlacement du Sous-marin " + compte++);
                for (int z = 15; z < 16; z++) {
                    if (Horizontal == true) {
                        Case c = new Case(x = x + 1, y, lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);

                    }
                    if (Horizontal == false) {
                        Case c = new Case(x, y = y + 1, lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);

                    }


                }

            }

        }
        for (int i = 0; i < listeCases.size(); i++) {

            MapDeCases.put(i, listeCases.get(i));
        }

        ArrayList<Case> liste0 = new ArrayList<Case>();
        ArrayList<Case> liste1 = new ArrayList<Case>();
        ArrayList<Case> liste2 = new ArrayList<Case>();
        ArrayList<Case> liste3 = new ArrayList<Case>();
        ArrayList<Case> liste4 = new ArrayList<Case>();
        ArrayList<Case> liste5 = new ArrayList<Case>();
        ArrayList<Case> liste6 = new ArrayList<Case>();
        ArrayList<Case> liste7 = new ArrayList<Case>();
        ArrayList<Case> liste8 = new ArrayList<Case>();
        ArrayList<Case> liste9 = new ArrayList<Case>();


        for(int z=0; z<MapDeBateaux.size(); z++)
        {
            if(z==0){
                for(int k=0; k<7;k++){
                    liste0.add(MapDeCases.get(k));
                }
                MapDeBateaux.get(z).setLesCases(liste0);
            }
            if(z==1){
                for(int k=7; k<12;k++){
                    liste1.add(MapDeCases.get(k));
                }
                MapDeBateaux.get(z).setLesCases(liste1);
            }
            if(z==2){
                for(int k=12; k<17;k++){
                    liste2.add(MapDeCases.get(k));
                }
                MapDeBateaux.get(z).setLesCases(liste2);
            }
            if(z==3){
                for(int k=17; k<20;k++){
                    liste3.add(MapDeCases.get(k));
                }
                MapDeBateaux.get(z).setLesCases(liste3);
            }
            if(z==4){
                for(int k=20; k<23;k++){
                    liste4.add(MapDeCases.get(k));
                }
                MapDeBateaux.get(z).setLesCases(liste4);
            }
            if(z==5){
                for(int k=23; k<26;k++){
                    liste5.add(MapDeCases.get(k));
                }
                MapDeBateaux.get(z).setLesCases(liste5);
            }
            if(z==6){
                liste6.add(MapDeCases.get(26));
                MapDeBateaux.get(z).setLesCases(liste6);
            }
            if(z==7){
                liste7.add(MapDeCases.get(27));
                MapDeBateaux.get(z).setLesCases(liste7);
            }
            if(z==8){
                liste8.add(MapDeCases.get(28));
                MapDeBateaux.get(z).setLesCases(liste8);
            }
            if(z==9){
                liste9.add(MapDeCases.get(29));
                MapDeBateaux.get(z).setLesCases(liste9);
            }
        }
        setMapDeBateauxHumain(MapDeBateaux);
        setMapDeCasesHumain(MapDeCases);

    }

   void PlacementBateauxHumain(HashMap<Integer, Bateau> MapDeBateaux) {
        MapDeBateaux = getMapDeBateauxHumain();
        for (Integer TY : MapDeBateaux.keySet()) {
            System.out.println("Bateau n." + TY + " de nom = " + MapDeBateaux.get(TY).getNom_navire() + " D'id : " + MapDeBateaux.get(TY).getId_navire() + " de taille = " + MapDeBateaux.get(TY).getTaille_navire() + "\n, de direction horizontale : " + MapDeBateaux.get(TY).isHorizontal() + "\n, de coordonnées debut x = " + MapDeBateaux.get(TY).getCoordonneeDebutX() + " et y = " + MapDeBateaux.get(TY).getCoordonneeDebutY() + "\n\n");

        }

    }


    void DeplacerBateauHumain(HashMap<Integer, Bateau> MapDeBateaux, HashMap<Integer, Case> MapDeCases) {
        Integer choix = 0;
        int x = 0;
        int reponse = 0;
        int i=0;
        boolean drapeau = false;
        ArrayList<Case> lesCases = new ArrayList<>();
        Scanner scan1 = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        boolean casetouche = false;

        //affichage de départ
        System.out.println("Vous avez choisi de déplacer votre bateau\n");
        System.out.println("Veuillez selectionner le bateau souhaite:\n");

        for (Integer n : MapDeBateaux.keySet()) {
            System.out.println(" " + MapDeBateaux.get(n).getNom_navire() + " et d'id : " + MapDeBateaux.get(n).getId_navire() + "decoordonnéee début =" + MapDeBateaux.get(n).getCoordonneeDebutX());
        }
        System.out.println("Veuillez selectionner le bateau souhaite dans la liste ci-dessus:\n");

        do             //blindage exception pour le choix du menu bateau
        {do{try
        {choix = Integer.parseInt(scan.nextLine());
            x=0;} catch (Exception e) {System.out.println("L'entrée doit être un chiffre compris entre 0 et 9.");
            x=1;}
        }while(x!=0 ); }while((choix!= 0) && (choix!= 1) && (choix != 2) && (choix != 3) && (choix != 4) && (choix != 5) && (choix != 6) && (choix != 7) && (choix != 8) && (choix != 9));

        //on blinde l'entrée pour que le choix reste compris entre 0 et 9
        while (choix < 0 || choix > 9) {
            System.out.print("Saisie incorrecte: Veulliez saisir un bon id :");
            choix = scan1.nextInt();
        }

        for(int da =0;da<MapDeBateaux.get(choix).getlesCases().size();da++){
                if(MapDeBateaux.get(choix).getlesCases().get(da).EtatCase() == true){
                    casetouche =true;
                    break;
                }
            }

        if(casetouche == true ){
            System.out.println("Vous avez choisis un bateau qui est touché, vous ne pouvez pas le déplacer\n Choisissez un autre bateau");
            DeplacerBateauHumain(MapDeBateaux,  MapDeCases);
        }

        //on demande les coordonnées
        System.out.print("Vous avez choisi le bateau : " + MapDeBateaux.get(choix).getNom_navire() + "\n");
        if(choix>=0 && choix<=5){
        if (MapDeBateaux.get(choix).isHorizontal() == true) //si le bateau est horizontal
        {
            System.out.print("Souhaitez vous deplacer le bateau vers la droite ou vers la gauche? Repondez pour droite 1 ou pour gauche 0\n");
            reponse = scan.nextInt();

            if (reponse == 1) {
                boolean flag = true;

                {
                    System.out.println(MapDeBateaux.get(choix).getlesCases().get(MapDeBateaux.get(choix).getlesCases().size()-1).getX());
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeBateaux.get(choix).getlesCases().get(MapDeBateaux.get(choix).getlesCases().size()-1).getX() + 1 >= 16 || (MapDeBateaux.get(choix).getlesCases().get(MapDeBateaux.get(choix).getlesCases().size()-1).getX()+1 == MapDeCases.get(a).getX() &&  MapDeBateaux.get(choix).getlesCases().get(MapDeBateaux.get(choix).getlesCases().size()-1).getY() == MapDeCases.get(a).getY())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (i =0; i<MapDeBateaux.get(choix).getlesCases().size() ; i++) {

                            MapDeBateaux.get(choix).getlesCases().get(i).setX(MapDeBateaux.get(choix).getlesCases().get(i).getX()+1);
                            lesCases.add(MapDeBateaux.get(choix).getlesCases().get(i));
                            System.out.println("Coordonnées Case X :" + MapDeCases.get(i).getX() + " Y:" + MapDeCases.get(i).getY());
                            flag = false;
                        }
                        setMapDeCasesHumain(MapDeCases);
                        MapDeBateaux.get(choix).setLesCases(lesCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible.\nVous pouvez recommencer :");
                        DeplacerBateauHumain(MapDeBateaux,  MapDeCases);
                    }

                    if (flag == false) {

                        MapDeBateaux.get(choix).setCoordonneeDebutX(MapDeBateaux.get(choix).getCoordonneeDebutX()+1);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }}}

            if (reponse == 0) {

               boolean flag = true;


                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeBateaux.get(choix).getlesCases().get(0).getX() - 1 <= 0 || (MapDeBateaux.get(choix).getlesCases().get(0).getX() - 1 == MapDeCases.get(a).getX() &&  MapDeBateaux.get(choix).getlesCases().get(0).getY() == MapDeCases.get(a).getY())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (i = 0; i < MapDeBateaux.get(choix).getlesCases().size(); i++) {

                            MapDeBateaux.get(choix).getlesCases().get(i).setX(MapDeBateaux.get(choix).getlesCases().get(i).getX()-1);
                            lesCases.add(MapDeBateaux.get(choix).getlesCases().get(i));
                            System.out.println("Coordonnées Case X :" + MapDeCases.get(i).getX() + " Y:" + MapDeCases.get(i).getY());
                            flag = false;
                        }
                        setMapDeCasesHumain(MapDeCases);
                        MapDeBateaux.get(choix).setLesCases(lesCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible.\nVous pouvez recommencer :");
                        DeplacerBateauHumain(MapDeBateaux,  MapDeCases);
                    }

                    if (flag ==false) {

                        MapDeBateaux.get(choix).setCoordonneeDebutX(MapDeBateaux.get(choix).getCoordonneeDebutX()-1);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }}

        if (MapDeBateaux.get(choix).isHorizontal() == false) {
            System.out.print("Souhaitez vous deplacer le bateau vers le haut ou vers le bas? Repondez pour haut 1 ou pour bas 0\n");
            reponse = scan.nextInt();

            if (reponse == 1) {
                boolean flag = true;

              //  if (choix == 0) //Cuirasse
               // {
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeBateaux.get(choix).getlesCases().get(0).getY() - 1 <= 0 || (MapDeBateaux.get(choix).getlesCases().get(0).getY() - 1 == MapDeCases.get(a).getY() &&  MapDeBateaux.get(choix).getlesCases().get(0).getX() == MapDeCases.get(a).getX()) ){
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (i = 0; i < MapDeBateaux.get(choix).getlesCases().size(); i++) {

                            MapDeBateaux.get(choix).getlesCases().get(i).setY(MapDeBateaux.get(choix).getlesCases().get(i).getY()-1);
                            lesCases.add(MapDeBateaux.get(choix).getlesCases().get(i));
                            System.out.println("Coordonnées Case X :" + MapDeCases.get(i).getX() + " Y:" + MapDeCases.get(i).getY());
                            flag = false;
                        }
                        setMapDeCasesHumain(MapDeCases);
                        MapDeBateaux.get(choix).setLesCases(lesCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible.\nVous pouvez recommencer :");
                        DeplacerBateauHumain(MapDeBateaux,  MapDeCases);
                    }

                    if (flag == false) {
                      // Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() - 1);
                      //  MapDeBateaux.replace(choix, b);
                        MapDeBateaux.get(choix).setCoordonneeDebutY(MapDeBateaux.get(choix).getCoordonneeDebutY()-1);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }

            if (reponse == 0) {
               boolean flag = true;

                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeBateaux.get(choix).getlesCases().get(MapDeBateaux.get(choix).getlesCases().size()-1).getY() + 1 >= 16 || (MapDeBateaux.get(choix).getlesCases().get(MapDeBateaux.get(choix).getlesCases().size()-1).getY() + 1 == MapDeCases.get(a).getY() &&  MapDeBateaux.get(choix).getlesCases().get(MapDeBateaux.get(choix).getlesCases().size()-1).getX() == MapDeCases.get(a).getX())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (i = 0; i < MapDeBateaux.get(choix).getlesCases().size(); i++) {
                            MapDeBateaux.get(choix).getlesCases().get(i).setY(MapDeBateaux.get(choix).getlesCases().get(i).getY()+1);
                           // Case c = new Case(MapDeBateaux.get(choix).getlesCases().get(i).getX(), MapDeBateaux.get(choix).getlesCases().get(i).getY() + 1, MapDeBateaux.get(choix).getlesCases().get(i).getGetID());
                           // MapDeCases.replace(i, c);
                            lesCases.add(MapDeBateaux.get(choix).getlesCases().get(i));
                            System.out.println("Coordonnées Case X :" + MapDeCases.get(i).getX() + " Y:" + MapDeCases.get(i).getY());
                            flag = false;
                        }
                        setMapDeCasesHumain(MapDeCases);
                        MapDeBateaux.get(choix).setLesCases(lesCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible.\nVous pouvez recommencer :");
                        DeplacerBateauHumain(MapDeBateaux,  MapDeCases);
                    }

                    if (flag == false) {
                       // Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() + 1);
                       // MapDeBateaux.replace(choix, b);
                        MapDeBateaux.get(choix).setCoordonneeDebutY(MapDeBateaux.get(choix).getCoordonneeDebutY()+1);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }}}


            if (choix == 6 || choix == 7 || choix == 8 || choix == 9) { //Sous marin 1,2,3 et 4
                System.out.print("Souhaitez vous deplacer le bateau vers le haut, le bas, à droite ou à gauche ? Repondez pour haut 1, pour bas 0, pour droite 2 et pour gauche 3\n");
                reponse = scan.nextInt();

                int w = 0;
                if (choix == 6) {w = 26;}
                if (choix == 7) {w = 27;}
                if (choix == 8) {w = 28;}
                if (choix == 9) {w = 29;}
               boolean flag =false;
                if(reponse == 1){
                for (Integer a : MapDeCases.keySet()) {
                    if (MapDeCases.get(w).getY() -1 <= 0||( MapDeCases.get(w).getY() -1 == MapDeCases.get(a).getY() &&  MapDeCases.get(w).getX() == MapDeCases.get(a).getX())) {
                        drapeau = true;
                        break;
                    }
                }
                if (drapeau == false) {
                   // Case c = new Case(MapDeCases.get(w).getX(), MapDeCases.get(w).getY() -1, 1);

                   // MapDeCases.replace(w, c);
                    MapDeBateaux.get(choix).getlesCases().get(0).setY(MapDeBateaux.get(choix).getlesCases().get(i).getY()-1);
                    lesCases.add(MapDeBateaux.get(choix).getlesCases().get(i));
                    System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                    flag = false;
                    setMapDeCasesHumain(MapDeCases);

                } else {
                    System.out.println("La coordonnée saisie est non disponible.\nVous pouvez recommencer :");
                    DeplacerBateauHumain(MapDeBateaux,  MapDeCases);
                }

                if (flag == false) {
                  //  Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() -1);
                 //   MapDeBateaux.replace(choix, b);
                    MapDeBateaux.get(choix).setCoordonneeDebutY(MapDeBateaux.get(choix).getCoordonneeDebutY()-1);
                    setMapDeBateauxHumain(MapDeBateaux);
                    MapDeBateaux.get(choix).setLesCases(lesCases);
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                } else {
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                }
            }
            if(reponse == 2){
                for (Integer a : MapDeCases.keySet()) {
                    if (MapDeCases.get(w).getX() +1 >= 16 || (MapDeCases.get(w).getX() +1 == MapDeCases.get(a).getX() &&  MapDeCases.get(w).getY() == MapDeCases.get(a).getY())) {
                        drapeau = true;
                        break;
                    }
                }
                if (drapeau == false) {
                  //  Case c = new Case(MapDeCases.get(w).getX()+1, MapDeCases.get(w).getY() , 1);
                  //  MapDeCases.replace(w, c);
                    MapDeBateaux.get(choix).getlesCases().get(0).setX(MapDeBateaux.get(choix).getlesCases().get(i).getX()+1);
                    lesCases.add(MapDeBateaux.get(choix).getlesCases().get(i));
                    System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                    flag = false;
                    setMapDeCasesHumain(MapDeCases);

                } else {
                    System.out.println("La coordonnée saisie est non disponible.\nVous pouvez recommencer :");
                    DeplacerBateauHumain(MapDeBateaux,  MapDeCases);
                }

                if (flag == false) {
                   // Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX()+1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                    MapDeBateaux.get(choix).setCoordonneeDebutX(MapDeBateaux.get(choix).getCoordonneeDebutX()+1);
                    setMapDeBateauxHumain(MapDeBateaux);
                    MapDeBateaux.get(choix).setLesCases(lesCases);
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                } else {
                    System.out.println("false Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                }
            }
                if(reponse == 0){
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(w).getY() +1 >= 16 || (MapDeCases.get(w).getY() +1 == MapDeCases.get(a).getY() &&  MapDeCases.get(w).getX() == MapDeCases.get(a).getX())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                      //  Case c = new Case(MapDeCases.get(w).getX(), MapDeCases.get(w).getY() +1, 1);
                       // MapDeCases.replace(w, c);
                        MapDeBateaux.get(choix).getlesCases().get(0).setY(MapDeBateaux.get(choix).getlesCases().get(i).getY()+1);
                        lesCases.add(MapDeBateaux.get(choix).getlesCases().get(i));
                        System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                        flag = false;
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible.\nVous pouvez recommencer :");
                        DeplacerBateauHumain(MapDeBateaux,  MapDeCases);
                    }

                    if (flag == false) {
                       // Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() +1);
                       // MapDeBateaux.replace(choix, b);
                        MapDeBateaux.get(choix).setCoordonneeDebutY(MapDeBateaux.get(choix).getCoordonneeDebutY()+1);
                        setMapDeBateauxHumain(MapDeBateaux);
                        MapDeBateaux.get(choix).setLesCases(lesCases);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }
                if(reponse == 3){
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(w).getX() -1 <= 0 || (MapDeCases.get(w).getX() -1 == MapDeCases.get(a).getX() &&  MapDeCases.get(w).getY() == MapDeCases.get(a).getY())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                       // Case c = new Case(MapDeCases.get(w).getX()-1, MapDeCases.get(w).getY() , 1);
                       // MapDeCases.replace(w, c);
                        MapDeBateaux.get(choix).getlesCases().get(0).setX(MapDeBateaux.get(choix).getlesCases().get(i).getX()-1);
                        lesCases.add(MapDeBateaux.get(choix).getlesCases().get(i));
                        System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                        flag = false;
                        setMapDeCasesHumain(MapDeCases);
                        System.out.println(lesCases.size());

                    } else {
                        System.out.println("La coordonnée saisie est non disponible.\nVous pouvez recommencer :");
                        DeplacerBateauHumain(MapDeBateaux,  MapDeCases);
                    }

                    if (flag == false) {
                        //Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX()-1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        //MapDeBateaux.replace(choix, b);
                        MapDeBateaux.get(choix).setCoordonneeDebutX(MapDeBateaux.get(choix).getCoordonneeDebutX()-1);
                        setMapDeBateauxHumain(MapDeBateaux);
                        MapDeBateaux.get(choix).setLesCases(lesCases);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }
            }
}}






