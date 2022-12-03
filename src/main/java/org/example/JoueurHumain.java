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
    private HashMap<Integer, Case> mapDeCasesHumain = new HashMap<Integer, Case>();
    private HashMap<Integer, Bateau> mapDeBateauxHumain = new HashMap<Integer, Bateau>();

    public HashMap<Integer, Bateau> getMapDeBateauxHumain() {
        return mapDeBateauxHumain;
    }

    public void setMapDeBateauxHumain(HashMap<Integer, Bateau> mapDeBateaux) {
        this.mapDeBateauxHumain = mapDeBateaux;
    }

    private Scanner scan1 = new Scanner(System.in);
    private Scanner scan = new Scanner(System.in);


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

    protected HashMap<Integer, Case> PlacementCasesHumain(HashMap<Integer, Case> MapDeCases, HashMap<Integer, Bateau> MapDeBateaux) {

        //Initialisation de la fonction aléatoire
        Random alea = new Random();

        //On déclare des listes
        List<Integer> lesTailles = new ArrayList<>(List.of(7, 5, 5, 3, 3, 3, 1, 1, 1, 1));
        // List<String> lesNoms = new ArrayList<>(List.of("Cuirasse","Croiseur","Croiseur", "Destroyer","Destroyer","Destroyer","Sous-marin","Sous-marin","Sous-marin","Sous-marin","Sous-marin"));
        ArrayList<Case> listeCases = new ArrayList<Case>();
        List<Integer> NoDoublonX = new ArrayList<>();
        List<Integer> NoDoublonY = new ArrayList<>();
        int y = 0;
        int x = 0;
        int compx = x;
        int compy = y;
        NoDoublonX.add(0);
        NoDoublonY.add(0);
        //On boucle 10 fois pour les 10 bateaux
        for (int i = 0; i < 10; i++) {
            int int_random = alea.nextInt(2);
            boolean Horizontal;
            int taille_bateau = lesTailles.get(i);
            int limite = 15 - taille_bateau;
            int test = 0;
           /* Bateau B = new Bateau(lesTailles.get(i), i,lesNoms.get(i));
            B.setNom_navire(lesNoms.get(i));
            mapDeBateaux.put(i,B);*/

            if (int_random == 0) {
                Horizontal = true;
                // dans ce cas y reste le meme et x varie
                // il faut s'assurer que la taille du bateau ne dépasse pas de la  grille
                // x = alea.nextInt(limite++) +1;
                // y = alea.nextInt(16)+1;
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


                test = 1;
            } else {
                Horizontal = false;
                // x reste la meme et y varie
                //x = alea.nextInt(16)+1;
                //y = alea.nextInt(limite++)+1;

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
            //Case C  = new Case(x,y);
            int compte = i;
            compte = compte + 1;
            if (lesTailles.get(i) == 7) {
                System.out.println("\nPlacement du Cuirasse " + compte);
                for (int z = 0; z < 7; z++) {
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
                    //NoDoublonX.add(x);
                    // NoDoublonY.add(y);
                }
            }
            if (lesTailles.get(i) == 5) {
                System.out.println("\nPlacement du Croiseur " + compte++);
                for (int z = 7; z < 12; z++) {
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
                    //NoDoublonX.add(x);
                    //NoDoublonY.add(y);


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
                    //NoDoublonX.add(x);
                    //NoDoublonY.add(y);
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
                    //NoDoublonX.add(x);
                    //NoDoublonY.add(y);

                }
            }

        }
        for (int i = 0; i < listeCases.size(); i++) {
            //System.out.println(i + " Avec X = " + listeCases.get(i).getX() + " et Y = " + listeCases.get(i).getY() + "\n et d'ID = " + listeCases.get(i).getGetID());
            MapDeCases.put(i, listeCases.get(i));
        }
        setMapDeBateauxHumain(MapDeBateaux);
        setMapDeCasesHumain(MapDeCases);
        return MapDeCases;
    }

    protected HashMap<Integer, Bateau> PlacementBateauxHumain(HashMap<Integer, Bateau> MapDeBateaux) {
        MapDeBateaux = getMapDeBateauxHumain();
        for (Integer TY : mapDeBateauxHumain.keySet()) {
            System.out.println("Bateau n." + TY + " de nom = " + mapDeBateauxHumain.get(TY).getNom_navire() + " D'id : " + mapDeBateauxHumain.get(TY).getId_navire() + " de taille = " + mapDeBateauxHumain.get(TY).getTaille_navire() + "\n, de direction horizontale : " + mapDeBateauxHumain.get(TY).isHorizontal() + "\n, de coordonnées debut x = " + mapDeBateauxHumain.get(TY).getCoordonneeDebutX() + " et y = " + mapDeBateauxHumain.get(TY).getCoordonneeDebutY() + "\n\n");

        }
        return MapDeBateaux;
    }


    void DeplacerBateauHumain(HashMap<Integer, Bateau> MapDeBateaux, HashMap<Integer, Case> MapDeCases) {
        Integer choix = 0;
        int x = 0;
        int reponse = 0;
        Integer i = 0;
        boolean drapeau = false;

        //affichage de départ
        System.out.println("Vous avez choisi de déplacer votre bateau\n");
        System.out.println("Veuillez selectionner le bateau souhaite:\n");

        for (Integer n : MapDeBateaux.keySet()) {
            System.out.println(" " + MapDeBateaux.get(n).getNom_navire() + " et d'id : " + MapDeBateaux.get(n).getId_navire() + "decoordonnéee début =" + MapDeBateaux.get(n).getCoordonneeDebutX());
        }
        System.out.println("Veuillez selectionner le bateau souhaite dans la liste ci-dessus:\n");

        choix = scan1.nextInt();

        //on blinde l'entrée pour que le choix reste compris entre 0 et 9
        while (choix < 0 || choix > 9) {
            System.out.print("Saisie incorrecte: Veulliez saisir un bon id :");
            choix = scan1.nextInt();
        }

        //on demande les coordonnées
        System.out.print("Vous avez choisi le bateau : " + MapDeBateaux.get(choix).getNom_navire() + "\n");

        if (MapDeBateaux.get(choix).isHorizontal() == true) //si le bateau est horizontal
        {
            System.out.print("Souhaitez vous deplacer le bateau vers la droite ou vers la gauche? Repondez pour droite 1 ou pour gauche 0\n");
            reponse = scan.nextInt();

            if (reponse == 1) {
                boolean flag = true;

                if (choix == 0) //Cuirasse
                {
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(6).getX() + 1 >= 16 || (MapDeCases.get(6).getX() + 1 == MapDeCases.get(a).getX() &&  MapDeCases.get(6).getY() == MapDeCases.get(a).getY())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (i = 0; i < 7; i++) {
                            Case c = new Case(MapDeCases.get(i).getX() + 1, MapDeCases.get(i).getY(), 7);
                            MapDeCases.replace(i, c);
                            System.out.println("Coordonnées Case X :" + MapDeCases.get(i).getX() + " Y:" + MapDeCases.get(i).getY());
                            flag = false;
                        }
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() + 1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }

                if (choix == 1 || choix == 2) { //Croiseur 1 et 2
                    int w = 0, z = 0;
                    if (choix == 1) {w = 7; z = 11;}
                    if (choix == 2) {w = 12;z = 16;}
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(z).getX() + 1 >= 16 || (MapDeCases.get(z).getX() + 1 == MapDeCases.get(a).getX() &&  MapDeCases.get(z).getY() == MapDeCases.get(a).getY())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (int compte = w; compte <= z; compte++) {
                            {
                                Case c = new Case(MapDeCases.get(compte).getX() + 1, MapDeCases.get(compte).getY(), 5);
                                MapDeCases.replace(compte, c);
                                System.out.println("Coordonnée Case X:" + MapDeCases.get(compte).getX() + " Y:" + MapDeCases.get(compte).getY());
                                flag = false;
                            }
                        }
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() + 1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }

                if (choix == 3 || choix == 4 || choix == 5) {
                    int w = 0;
                    int z = 0;
                    if (choix == 3) {w = 17; z = 19;}
                    if (choix == 4) {w = 20;z = 22;}
                    if (choix == 5) {w = 23;z = 25;}
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(z).getX() + 1 >= 16|| (MapDeCases.get(z).getX() + 1 == MapDeCases.get(a).getX() &&  MapDeCases.get(z).getY() == MapDeCases.get(a).getY())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (int compte = w; compte <= z; compte++) {
                            {
                                Case c = new Case(MapDeCases.get(compte).getX() + 1, MapDeCases.get(compte).getY(), 3);
                                MapDeCases.replace(compte, c);
                                System.out.println("Coordonnée Case X:" + MapDeCases.get(compte).getX() + " Y:" + MapDeCases.get(compte).getY());
                                flag = false;
                            }
                        }
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() + 1,MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }
            }

            if (reponse == 0) {

                boolean flag = true;

                if (choix == 0) //Cuirasse
                {
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(0).getX() - 1 <= 0 || (MapDeCases.get(0).getX() - 1 == MapDeCases.get(a).getX() &&  MapDeCases.get(0).getY() == MapDeCases.get(a).getY())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (i = 0; i < 7; i++) {
                            Case c = new Case(MapDeCases.get(i).getX() - 1, MapDeCases.get(i).getY(), 7);
                            MapDeCases.replace(i, c);
                            System.out.println("Coordonnées Case X :" + MapDeCases.get(i).getX() + " Y:" + MapDeCases.get(i).getY());
                            flag = false;
                        }
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag ==false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() - 1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }

                if (choix == 1 || choix == 2) { //Croiseur 1 et 2
                    int w = 0;
                    int z = 0;
                    if (choix == 1) {w = 7;z = 11;}
                    if (choix == 2) {w = 12;z = 16;}
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(w).getX() - 1 <= 0 || ( MapDeCases.get(w).getX() - 1 == MapDeCases.get(a).getX()&&  MapDeCases.get(w).getY() == MapDeCases.get(a).getY())  ) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (int compte = w; compte <= z; compte++) {
                            {
                                Case c = new Case(MapDeCases.get(compte).getX() - 1, MapDeCases.get(compte).getY(), 5);
                                MapDeCases.replace(compte, c);
                                System.out.println("Coordonnée Case X:" + MapDeCases.get(compte).getX() + " Y:" + MapDeCases.get(compte).getY());
                                flag = false;
                            }
                        }
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() - 1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }

                if (choix == 3 || choix == 4 || choix == 5) {
                    int w = 0;
                    int z = 0;
                    if (choix == 3) {w = 17;z = 19;}
                    if (choix == 4) {w = 20;z = 22;}
                    if (choix == 5) {w = 23;z = 25;}
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(w).getX() - 1 <= 0 || (MapDeCases.get(w).getX() - 1 == MapDeCases.get(a).getX() &&  MapDeCases.get(w).getY() == MapDeCases.get(a).getY())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (int compte = w; compte <= z; compte++) {
                            {
                                Case c = new Case(MapDeCases.get(compte).getX() - 1, MapDeCases.get(compte).getY(), 3);
                                MapDeCases.replace(compte, c);
                                System.out.println("Coordonnée Case X:" + MapDeCases.get(compte).getX() + " Y:" + MapDeCases.get(compte).getY());
                                flag = false;
                            }
                            setMapDeCasesHumain(MapDeCases);
                        }
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() - 1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }
        }}

        if (MapDeBateaux.get(choix).isHorizontal() == false) {
            System.out.print("Souhaitez vous deplacer le bateau vers le haut ou vers le bas? Repondez pour haut 1 ou pour bas 0\n");
            reponse = scan.nextInt();

            if (reponse == 1) {
                boolean flag = true;

                if (choix == 0) //Cuirasse
                {
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(0).getY() - 1 <= 0 || (MapDeCases.get(0).getY() - 1 == MapDeCases.get(a).getY() &&  MapDeCases.get(0).getX() == MapDeCases.get(a).getX()) ){
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (i = 0; i < 7; i++) {
                            Case c = new Case(MapDeCases.get(i).getX(), MapDeCases.get(i).getY() - 1, 7);
                            MapDeCases.replace(i, c);
                            System.out.println("Coordonnées Case X :" + MapDeCases.get(i).getX() + " Y:" + MapDeCases.get(i).getY());
                            flag = false;
                        }
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() - 1);
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }

                if (choix == 1 || choix == 2) {int w = 0;int z = 0;
                    if (choix == 1) {w = 7;z = 11;}
                    if (choix == 2) {w = 12;z = 16;}
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(w).getY() - 1 <= 0 || ( MapDeCases.get(w).getY() - 1 == MapDeCases.get(a).getY() &&  MapDeCases.get(w).getX() == MapDeCases.get(a).getX())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (int compte = w; compte <= z; compte++) {
                            {
                                Case c = new Case(MapDeCases.get(compte).getX(), MapDeCases.get(compte).getY() - 1, 5);
                                MapDeCases.replace(compte, c);
                                System.out.println("Coordonnée Case X:" + MapDeCases.get(compte).getX() + " Y:" + MapDeCases.get(compte).getY());
                                flag = false;
                            }
                        }
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() - 1);
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }

                if (choix == 3 || choix == 4 || choix == 5) {
                    int w = 0;
                    int z = 0;
                    if (choix == 3) {w = 17; z = 19;}
                    if (choix == 4) {w = 20;z = 22;}
                    if (choix == 5) {w = 23;z = 25;}
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(w).getY() - 1 <= 0 || (MapDeCases.get(w).getY() - 1 == MapDeCases.get(a).getY() &&  MapDeCases.get(w).getX() == MapDeCases.get(a).getX())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (int compte = w; compte <= z; compte++) {
                            {
                                Case c = new Case(MapDeCases.get(compte).getX(), MapDeCases.get(compte).getY() - 1, 3);
                                MapDeCases.replace(compte, c);
                                System.out.println("Coordonnée Case X:" + MapDeCases.get(compte).getX() + " Y:" + MapDeCases.get(compte).getY());
                                flag = false;
                            }
                        }
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() - 1);
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }}

            if (reponse == 0) {
                boolean flag = true;

                if (choix == 0) //Cuirasse
                {
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(6).getY() + 1 >= 16 || (MapDeCases.get(6).getY() + 1 == MapDeCases.get(a).getY() &&  MapDeCases.get(6).getX() == MapDeCases.get(a).getX())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (i = 0; i < 7; i++) {
                            Case c = new Case(MapDeCases.get(i).getX(), MapDeCases.get(i).getY() + 1, 7);
                            MapDeCases.replace(i, c);
                            System.out.println("Coordonnées Case X :" + MapDeCases.get(i).getX() + " Y:" + MapDeCases.get(i).getY());
                            flag = false;
                        }
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() + 1);
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }

                if (choix == 1 || choix == 2) { //Croiseur 1 et 2
                    int w = 0;
                    int z = 0;
                    if (choix == 1) {w = 7;z = 11;}
                    if (choix == 2) {w = 12;z = 16;}
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(z).getY() + 1 >= 16 || (MapDeCases.get(z).getY() + 1 == MapDeCases.get(a).getY() &&  MapDeCases.get(z).getX() == MapDeCases.get(a).getX())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (int compte = w; compte <= z; compte++) {
                            {
                                Case c = new Case(MapDeCases.get(compte).getX(), MapDeCases.get(compte).getY() + 1, 5);
                                MapDeCases.replace(compte, c);
                                System.out.println("Coordonnée Case X:" + MapDeCases.get(compte).getX() + " Y:" + MapDeCases.get(compte).getY());
                                flag = false;
                            }
                        }
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() + 1);
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }

                if (choix == 3 || choix == 4 || choix == 5) { //Destroyer 1,2 et 3
                    int w = 0;
                    int z = 0;
                    if (choix == 3) {w = 17;z = 19;}
                    if (choix == 4) {w = 20;z = 22;}
                    if (choix == 5) {w = 23;z = 25;}
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(z).getY() + 1 >= 16 || (MapDeCases.get(z).getY() + 1 == MapDeCases.get(a).getY()&&  MapDeCases.get(z).getX() == MapDeCases.get(a).getX())) {
                            drapeau = true;
                            break;
                        }
                    }
                    if (drapeau == false) {
                        for (int compte = w; compte <= z; compte++) {
                            {
                                Case c = new Case(MapDeCases.get(compte).getX(), MapDeCases.get(compte).getY() + 1, 3);
                                MapDeCases.replace(compte, c);
                                System.out.println("Coordonnée Case X:" + MapDeCases.get(compte).getX() + " Y:" + MapDeCases.get(compte).getY());
                                flag = false;
                            }
                        }
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() + 1);
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }
            }}



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
                    if (MapDeCases.get(w).getY() -1 <= 1 ||( MapDeCases.get(w).getY() -1 == MapDeCases.get(a).getY() &&  MapDeCases.get(w).getX() == MapDeCases.get(a).getX())) {
                        drapeau = true;
                        break;
                    }
                }
                if (drapeau == false) {
                    Case c = new Case(MapDeCases.get(w).getX(), MapDeCases.get(w).getY() -1, 1);
                    MapDeCases.replace(w, c);
                    System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                    flag = false;
                    setMapDeCasesHumain(MapDeCases);
                } else {
                    System.out.println("La coordonnée saisie est non disponible");
                }

                if (flag == false) {
                    Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() -1);
                    MapDeBateaux.replace(choix, b);
                    setMapDeBateauxHumain(MapDeBateaux);
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
                    Case c = new Case(MapDeCases.get(w).getX()+1, MapDeCases.get(w).getY() , 1);
                    MapDeCases.replace(w, c);
                    System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                    flag = false;
                    setMapDeCasesHumain(MapDeCases);
                } else {
                    System.out.println("La coordonnée saisie est non disponible");
                }

                if (flag == false) {
                    Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX()+1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                    MapDeBateaux.replace(choix, b);
                    setMapDeBateauxHumain(MapDeBateaux);
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                } else {
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
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
                        Case c = new Case(MapDeCases.get(w).getX(), MapDeCases.get(w).getY() +1, 1);
                        MapDeCases.replace(w, c);
                        System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                        flag = false;
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() +1);
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
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
                        Case c = new Case(MapDeCases.get(w).getX()-1, MapDeCases.get(w).getY() , 1);
                        MapDeCases.replace(w, c);
                        System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                        flag = false;
                        setMapDeCasesHumain(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX()-1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxHumain(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }
            }
    }

}






