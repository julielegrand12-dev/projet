package org.example;

import java.util.*;

public class JoueurOrdi {

    private String pseudo;
    private int score;

    private HashMap<Integer, Case> mapDeCasesOrdi = new HashMap<Integer,Case>();
    private HashMap<Integer,Bateau> mapDeBateauxOrdi = new HashMap<Integer, Bateau>();

    public HashMap<Integer, Bateau> getMapDeBateauxOrdi() {
        return mapDeBateauxOrdi;
    }

    public void setMapDeBateauxOrdi(HashMap<Integer, Bateau> mapDeBateaux) {
        this.mapDeBateauxOrdi = mapDeBateaux;
    }

    public void setMapDeCasesOrdi(HashMap<Integer, Case> mapDeCases) {
        this.mapDeCasesOrdi = mapDeCases;
    }

    public HashMap<Integer, Case> getMapDeCasesOrdi() {
        return mapDeCasesOrdi;
    }

    //Déclaration du constructeur
    public JoueurOrdi(String pseudo, int score) {
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

    private Scanner scan1 = new Scanner(System.in);
    private Scanner scan = new Scanner(System.in);


    protected HashMap<Integer, Case> PlacementCasesOrdi(HashMap<Integer, Case>MapDeCases, HashMap<Integer, Bateau>MapDeBateaux) {

        //Initialisation de la fonction aléatoire
        Random alea = new Random();

        //On déclare des listes
        List<Integer> lesTailles = new ArrayList<>(List.of(7,5,5,3,3,3,1,1,1,1));
        // List<String> lesNoms = new ArrayList<>(List.of("Cuirasse","Croiseur","Croiseur", "Destroyer","Destroyer","Destroyer","Sous-marin","Sous-marin","Sous-marin","Sous-marin","Sous-marin"));
        ArrayList<Case> listeCases = new ArrayList<Case>();
        int y=0;
        int x=0;
        //On boucle 10 fois pour les 10 bateaux
        for (int i = 0; i< 10; i++) {
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
                x = (int) (Math.random()*(15-limite))+1;
                y = (int)(Math.random()*(15))+1;

                for (int a=0;a<=taille_bateau;a++){
                    for (int w=0;w<listeCases.size();w++){
                        while(listeCases.get(w).getX() == x  + a && listeCases.get(w).getY() == y){
                            x = (int) (Math.random()*(15-limite))+1;
                            y = (int)(Math.random()*(15))+1;
                            System.out.println("\n\nErreur");
                            a=0;
                            break;

                        }
                    }}
                if (lesTailles.get(i)== 7){

                    Bateau B = new Cuirasse(lesTailles.get(i), i,"Cuirasse", Horizontal, x+1,y);

                    MapDeBateaux.put(i,B);}
                if (lesTailles.get(i)== 5){

                    Bateau B = new Croiseur(lesTailles.get(i), i,"Croiseur", Horizontal, x+1, y);

                    MapDeBateaux.put(i,B);}
                if (lesTailles.get(i)== 3){

                    Bateau B = new Destroyer(lesTailles.get(i), i,"Destroyer", Horizontal, x+1, y);

                    MapDeBateaux.put(i,B);}
                if (lesTailles.get(i)== 1){

                    Bateau B = new SousMarin(lesTailles.get(i), i,"Sous-marin", Horizontal, x+1, y);

                    MapDeBateaux.put(i,B);}


                test = 1;
            }
            else {
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
            test = 1;

            //Case C  = new Case(x,y);
            int compte = i;
            compte = compte +1;
            if (lesTailles.get(i)== 7){
                System.out.println("\nPlacement du Cuirasse " + compte);
                for(int z=0; z<7;z++){
                    if(Horizontal == true){
                        Case c = new Case(x=x+1,y,lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());

                        listeCases.add(c);


                    }
                    if(Horizontal == false){
                        Case c = new Case(x,y=y+1,lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());

                        listeCases.add(c);

                    }
                    //NoDoublonX.add(x);
                    // NoDoublonY.add(y);
                }
            }
            if (lesTailles.get(i)== 5){
                System.out.println("\nPlacement du Croiseur " + compte++);
                for(int z=7; z<12;z++){
                    if(Horizontal == true){
                        Case c = new Case(x=x+1,y,lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);
                    }
                    if(Horizontal == false){
                        Case c = new Case(x,y=y+1,lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);
                    }
                }
            }
            if (lesTailles.get(i)== 3){
                System.out.println("\nPlacement du Destroyer " +compte++);
                for(int z=12; z<15;z++){
                    if(Horizontal == true){
                        Case c = new Case(x=x+1,y,lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);
                    }
                    if(Horizontal == false){
                        Case c = new Case(x,y=y+1,lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);
                    }
                }
            }
            if (lesTailles.get(i)== 1){
                System.out.println("\nPlacement du Sous-marin " +compte++);
                for(int z=15; z<16;z++){
                    if(Horizontal == true){
                        Case c = new Case(x=x+1,y,lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);
                    }
                    if(Horizontal == false){
                        Case c = new Case(x,y=y+1,lesTailles.get(i));
                        System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                        listeCases.add(c);
                    }
                }
            }


// continuer cette fonction pour bien prendre encompte l'absence de voisins et le non chevauchement
        }
        for (int i = 0; i<listeCases.size();i++){
            //System.out.println(i + " Avec X = " + listeCases.get(i).getX() + " et Y = " + listeCases.get(i).getY() + "\n et d'ID = " + listeCases.get(i).getGetID());
            MapDeCases.put(i, listeCases.get(i));


        }
        setMapDeBateauxOrdi(MapDeBateaux);
        setMapDeCasesOrdi(MapDeCases);
        return MapDeCases; }

    protected HashMap<Integer, Bateau> PlacementBateauxOrdi (HashMap<Integer, Bateau>MapDeBateaux) {
        MapDeBateaux  = getMapDeBateauxOrdi();
            for (Integer TY : MapDeBateaux.keySet()) {
                System.out.println("Bateau n." + TY + " de nom = " + MapDeBateaux.get(TY).getNom_navire()  +" D'id : " +  MapDeBateaux.get(TY).getId_navire() + " de taille = " + MapDeBateaux.get(TY).getTaille_navire()+  "\n, de direction horizontale : "  + MapDeBateaux.get(TY).isHorizontal() + "\n, de coordonnées debut x = " + MapDeBateaux.get(TY).getCoordonneeDebutX()+ " et y = " + MapDeBateaux.get(TY).getCoordonneeDebutY() + "\n\n" );

            }
        return MapDeBateaux;
    }



    void DeplacerBateauOrdi(HashMap<Integer, Bateau> MapDeBateaux, HashMap<Integer, Case> MapDeCases) {
        int choix = 0;
        int x = 0;
        int reponse = 0;
        Integer i = 0;
        boolean drapeau = false;

        //affichage de départ
        System.out.println("L'ordinateur a choisi de déplacer un navire\n");
        System.out.println("Il sélectionne le bateau souhaité\n");

        choix = (int) (Math.random() * (10)) ;
        //on blinde l'entrée pour que le choix reste compris entre 0 et 9
        while (choix < 0 || choix > 9) {
            System.out.print("Saisie incorrecte: Veulliez saisir un bon id :");
            choix = scan1.nextInt();
        }

        //on demande les coordonnées
        System.out.print("Lordinateur a choisi : " + MapDeBateaux.get(choix).getNom_navire() + "\n");

        if (MapDeBateaux.get(choix).isHorizontal() == true) //si le bateau est horizontal
        {

            reponse = (int) (Math.random() * (2)) ;

            if (reponse == 1) {
                System.out.print("L'ordinateur a décidé de déplacer vers la droite\n");
                boolean flag = true;

                if (choix == 0) //Cuirasse
                {
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(6).getX() + 1 >= 16 || MapDeCases.get(6).getX() + 1 == MapDeCases.get(a).getX()) {
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
                        setMapDeCasesOrdi(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() + 1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxOrdi(MapDeBateaux);
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
                        if (MapDeCases.get(z).getX() + 1 >= 16 || MapDeCases.get(z).getX() + 1 == MapDeCases.get(a).getX()) {
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
                        setMapDeCasesOrdi(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() + 1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxOrdi(MapDeBateaux);
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
                        if (MapDeCases.get(z).getX() + 1 >= 16 || MapDeCases.get(z).getX() + 1 == MapDeCases.get(a).getX()) {
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
                        setMapDeCasesOrdi(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() + 1,MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxOrdi(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }
            }

            if (reponse == 0) {
                System.out.print("L'ordinateur a décidé de déplacer vers la gauche\n");
                boolean flag = true;
                if (choix == 0) //Cuirasse
                {
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(0).getX() - 1 <= 0 || MapDeCases.get(0).getX() - 1 == MapDeCases.get(a).getX()) {
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
                        setMapDeCasesOrdi(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag ==false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() - 1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxOrdi(MapDeBateaux);
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
                        if (MapDeCases.get(w).getX() - 1 <= 0 || MapDeCases.get(w).getX() - 1 == MapDeCases.get(a).getX()) {
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
                        setMapDeCasesOrdi(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() - 1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxOrdi(MapDeBateaux);
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
                        if (MapDeCases.get(w).getX() - 1 <= 0 || MapDeCases.get(w).getX() - 1 == MapDeCases.get(a).getX()) {
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
                            setMapDeCasesOrdi(MapDeCases);
                        }
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX() - 1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxOrdi(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }

            if (MapDeBateaux.get(choix).isHorizontal() == false) {
                reponse = (int) (Math.random() * (2)) ;

                if (reponse == 1) {
                    System.out.print("L'ordinateur a décidé de déplacer vers le haut\n");
                     flag = true;

                    if (choix == 0) //Cuirasse
                    {
                        for (Integer a : MapDeCases.keySet()) {
                            if (MapDeCases.get(0).getY() - 1 <= 0 || MapDeCases.get(0).getY() - 1 == MapDeCases.get(a).getY()) {
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
                            setMapDeCasesOrdi(MapDeCases);
                        } else {
                            System.out.println("La coordonnée saisie est non disponible");
                        }

                        if (flag == false) {
                            Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() - 1);
                            MapDeBateaux.replace(choix, b);
                            setMapDeBateauxOrdi(MapDeBateaux);
                            System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                        } else {
                            System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                        }
                    }

                    if (choix == 1 || choix == 2) {int w = 0;int z = 0;
                        if (choix == 1) {w = 7;z = 11;}
                        if (choix == 2) {w = 12;z = 16;}
                        for (Integer a : MapDeCases.keySet()) {
                            if (MapDeCases.get(w).getY() - 1 <= 0 || MapDeCases.get(w).getY() - 1 == MapDeCases.get(a).getY()) {
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
                            setMapDeCasesOrdi(MapDeCases);
                        } else {
                            System.out.println("La coordonnée saisie est non disponible");
                        }

                        if (flag == false) {
                            Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() - 1);
                            MapDeBateaux.replace(choix, b);
                            setMapDeBateauxOrdi(MapDeBateaux);
                            System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                        } else {
                            System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                        }
                    }

                    if (choix == 3 || choix == 4 || choix == 5) {int w = 0;int z = 0;
                        if (choix == 3) {w = 17; z = 19;}
                        if (choix == 4) {w = 20;z = 22;}
                        if (choix == 5) {w = 23;z = 25;}
                        for (Integer a : MapDeCases.keySet()) {
                            if (MapDeCases.get(w).getY() - 1 <= 0 || MapDeCases.get(w).getY() - 1 == MapDeCases.get(a).getY()) {
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
                            setMapDeCasesOrdi(MapDeCases);
                        } else {
                            System.out.println("La coordonnée saisie est non disponible");
                        }

                        if (flag == false) {
                            Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() - 1);
                            MapDeBateaux.replace(choix, b);
                            setMapDeBateauxOrdi(MapDeBateaux);
                            System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                        } else {
                            System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                        }
                    }}
            }

            if (reponse == 0) {
                System.out.print("L'ordinateur a décidé de déplacer vers le bas\n");
                flag = true;

                if (choix == 0) //Cuirasse
                {
                    for (Integer a : MapDeCases.keySet()) {
                        if (MapDeCases.get(6).getY() + 1 >= 16 || MapDeCases.get(6).getY() + 1 == MapDeCases.get(a).getY()) {
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
                        setMapDeCasesOrdi(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() + 1);
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxOrdi(MapDeBateaux);
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
                        if (MapDeCases.get(z).getY() + 1 >= 16 || MapDeCases.get(z).getY() + 1 == MapDeCases.get(a).getY()) {
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
                        setMapDeCasesOrdi(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() + 1);
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxOrdi(MapDeBateaux);
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
                        if (MapDeCases.get(z).getY() + 1 >= 16 || MapDeCases.get(z).getY() + 1 == MapDeCases.get(a).getY()) {
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
                        setMapDeCasesOrdi(MapDeCases);
                    } else {
                        System.out.println("La coordonnée saisie est non disponible");
                    }

                    if (flag == false) {
                        Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() + 1);
                        MapDeBateaux.replace(choix, b);
                        setMapDeBateauxOrdi(MapDeBateaux);
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    } else {
                        System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                    }
                }
            }
        }}

        if (choix == 6 || choix == 7 || choix == 8 || choix == 9) { //Sous marin 1,2,3 et 4
            reponse = (int) (Math.random() * (4)) ;

            int w = 0;
            if (choix == 6) {w = 26;}
            if (choix == 7) {w = 27;}
            if (choix == 8) {w = 28;}
            if (choix == 9) {w = 29;}
            boolean flag =false;

            if(reponse == 0){
                System.out.print("L'ordinateur a choisi de déplacer vers le haut\n");
                for (Integer a : MapDeCases.keySet()) {
                    if (MapDeCases.get(w).getY() -1 <= 0 || MapDeCases.get(w).getY() -1 == MapDeCases.get(a).getY()) {
                        drapeau = true;
                        break;
                    }
                }
                if (drapeau == false) {
                    Case c = new Case(MapDeCases.get(w).getX(), MapDeCases.get(w).getY() -1, 1);
                    MapDeCases.replace(w, c);
                    System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                    flag = false;
                    setMapDeCasesOrdi(MapDeCases);
                } else {
                    System.out.println("La coordonnée saisie est non disponible");
                }

                if (flag == false) {
                    Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() -1);
                    MapDeBateaux.replace(choix, b);
                    setMapDeBateauxOrdi(MapDeBateaux);
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                } else {
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                }
            }
            if(reponse == 2){
                System.out.print("L'ordinateur a choisi de déplacer vers la droite\n");
                for (Integer a : MapDeCases.keySet()) {
                    if (MapDeCases.get(w).getX() +1 >= 16 || MapDeCases.get(w).getX() +1 == MapDeCases.get(a).getY()) {
                        drapeau = true;
                        break;
                    }
                }
                if (drapeau == false) {
                    Case c = new Case(MapDeCases.get(w).getX()+1, MapDeCases.get(w).getY() , 1);
                    MapDeCases.replace(w, c);
                    System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                    flag = false;
                    setMapDeCasesOrdi(MapDeCases);
                } else {
                    System.out.println("La coordonnée saisie est non disponible");
                }

                if (flag == false) {
                    Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX()+1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                    MapDeBateaux.replace(choix, b);
                    setMapDeBateauxOrdi(MapDeBateaux);
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                } else {
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                }
            }
            if(reponse == 1){
                System.out.print("L'ordinateur a choisi de déplacer vers le haut\n");
                for (Integer a : MapDeCases.keySet()) {
                    if (MapDeCases.get(w).getY() +1 >= 16 || MapDeCases.get(w).getY() +1 == MapDeCases.get(a).getY()) {
                        drapeau = true;
                        break;
                    }
                }
                if (drapeau == false) {
                    Case c = new Case(MapDeCases.get(w).getX(), MapDeCases.get(w).getY()+1 , 1);
                    MapDeCases.replace(w, c);
                    System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                    flag = false;
                    setMapDeCasesOrdi(MapDeCases);
                } else {
                    System.out.println("La coordonnée saisie est non disponible");
                }

                if (flag == false) {
                    Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX(), MapDeBateaux.get(choix).getCoordonneeDebutY() +1);
                    MapDeBateaux.replace(choix, b);
                    setMapDeBateauxOrdi(MapDeBateaux);
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                } else {
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                }
            }
            if(reponse == 3){
                System.out.print("L'ordinateur a choisi de déplacer vers la gauche\n");
                for (Integer a : MapDeCases.keySet()) {
                    if (MapDeCases.get(w).getX() -1 <= 0 || MapDeCases.get(w).getX() -1 == MapDeCases.get(a).getY()) {
                        drapeau = true;
                        break;
                    }
                }
                if (drapeau == false) {
                    Case c = new Case(MapDeCases.get(w).getX()-1, MapDeCases.get(w).getY() , 1);
                    MapDeCases.replace(w, c);
                    System.out.println("Coordonnée Case X:" + MapDeCases.get(w).getX() + " Y:" + MapDeCases.get(w).getY());
                    flag = false;
                    setMapDeCasesOrdi(MapDeCases);
                } else {
                    System.out.println("La coordonnée saisie est non disponible");
                }

                if (flag == false) {
                    Bateau b = new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(), MapDeBateaux.get(choix).isHorizontal(), MapDeBateaux.get(choix).getCoordonneeDebutX()-1, MapDeBateaux.get(choix).getCoordonneeDebutY());
                    MapDeBateaux.replace(choix, b);
                    setMapDeBateauxOrdi(MapDeBateaux);
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                } else {
                    System.out.println("Coordonnées bateau X:" + MapDeBateaux.get(choix).getCoordonneeDebutX() + " Y:" + MapDeBateaux.get(choix).getCoordonneeDebutY());
                }
            }
        }

}}

