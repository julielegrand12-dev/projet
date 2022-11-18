package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class JoueurHumain //initialisation de la classe joueur humain
{
    private String pseudo;
    private int score;
    private HashMap<Integer, Case> mapDeCases = new HashMap<Integer,Case>();
    private HashMap<Integer,Bateau> mapDeBateaux = new HashMap<Integer, Bateau>();

    public void setMapDeCases(HashMap<Integer, Case> mapDeCases) {
        this.mapDeCases = mapDeCases;
    }


    public HashMap<Integer, Case> getMapDeCases() {
        return mapDeCases;
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

    protected HashMap<Integer, Case> PlacementBateau(HashMap<Integer, Case>MapDeCases) {

        Random alea = new Random();
        List<Integer> lesTailles = new ArrayList<>(List.of(7,5,5,3,3,3,1,1,1,1));
        List<String> lesNoms = new ArrayList<>(List.of("Cruisarde","Croiseur","Croiseur", "Destroyer","Destroyer","Destroyer","Destroyer","Sous-marrin","Sous-marin","Sous-marin","Sous-marin"));
        ArrayList<Case> listeCases = new ArrayList<Case>();
        for (int i = 0; i< 10; i++) {
            int int_random = alea.nextInt(2);
            boolean Horizontal;
            int taille_bateau = lesTailles.get(i);
            int limite = 15 - taille_bateau;
            int test = 0;
            List<Integer> NoDoublonX = new ArrayList<>();
            List<Integer> NoDoublonY = new ArrayList<>();
            int y=0;
            int x=0;
            int compx = x;
            int compy = y;
            NoDoublonX.add(x);
            NoDoublonY.add(y);
            Bateau B = new Bateau(lesTailles.get(i), i,lesNoms.get(i));
            B.setNom_navire(lesNoms.get(i));
            mapDeBateaux.put(i,B);
            do {

                if (int_random == 0) {
                    Horizontal = true;
                    // dans ce cas y reste le meme et x varie
                    // il faut s'assurer que la taille du bateau ne dépasse pas de la  grille
                    x = alea.nextInt(limite++) +1;
                    y = alea.nextInt(16)+1;
                    for (int w=0;w<NoDoublonX.size();w++){
                        if(NoDoublonX.get(w) == x || NoDoublonY.get(w)== y){
                            x = alea.nextInt(limite++)+1;
                            y = alea.nextInt(16)+1;
                        }
                    }


                    test = 1;
                } else {
                    Horizontal = false;
                    // x reste la meme et y varie
                    x = alea.nextInt(16)+1;
                    y = alea.nextInt(limite++)+1;

                for (int w=0;w<NoDoublonX.size();w++){
                    if(NoDoublonX.get(w) == x && NoDoublonY.get(w)== y){
                        x = alea.nextInt(limite++)+1;
                        y = alea.nextInt(16)+1;
                    }
                }
                    }
                    test = 1;



                //Case C  = new Case(x,y);
                int compte = i;
                compte = compte +1;
                if (lesTailles.get(i)== 7){
                    System.out.println("\nPlacement du " + lesNoms.get(i)+ " " + compte);
                    for(int z=0; z<7;z++){
                        if(Horizontal == true){
                            Case c = new Case(x++,y,i);

                            listeCases.add(c);


                        }
                        if(Horizontal == false){
                            Case c = new Case(x,y++,i);

                            listeCases.add(c);

                        }
                        NoDoublonX.add(x);
                        NoDoublonY.add(y);
                        System.out.println("Nouvelle case de coordonnée: X :" + x + " & Y:" + y);



                    }
                }
                if (lesTailles.get(i)== 5){
                    System.out.println("\nPlacement du " + lesNoms.get(i) + " " + compte++);
                    for(int z=7; z<12;z++){
                        if(Horizontal == true){
                            Case c = new Case(x++,y,i);
                            listeCases.add(c);
                        }
                        if(Horizontal == false){
                            Case c = new Case(x,y++,i);
                            listeCases.add(c);
                        }
                        NoDoublonX.add(x);
                        NoDoublonY.add(y);
                        System.out.println("Nouvelle case de coordonnée :  X : " + x + " & Y : " + y);

                    }
                }
                if (lesTailles.get(i)== 3){
                    System.out.println("\nPlacement du " + lesNoms.get(i) + " " +compte++);
                    for(int z=12; z<15;z++){
                        if(Horizontal == true){
                            Case c = new Case(x++,y,i);
                            listeCases.add(c);
                        }
                        if(Horizontal == false){
                            Case c = new Case(x,y++,i);
                            listeCases.add(c);
                        }
                        NoDoublonX.add(x);
                        NoDoublonY.add(y);
                        System.out.println("Nouvelle case de coordonnée : X : " + x + " & Y: " + y);
                    }
                }
                if (lesTailles.get(i)== 1){
                    System.out.println("\nPlacement du " + lesNoms.get(i) + " " +compte++);
                    for(int z=15; z<16;z++){
                        if(Horizontal == true){
                            Case c = new Case(x++,y,i);
                            listeCases.add(c);
                        }
                        if(Horizontal == false){
                            Case c = new Case(x,y++,i);
                            listeCases.add(c);
                        }
                        NoDoublonX.add(x);
                        NoDoublonY.add(y);
                        System.out.println("Nouvelle case de coordonnée : X : " + x + " & Y: " + y);
                    }
                }

            } while (test == 0);

// continuer cette fonction pour bien prendre encompte l'absence de voisins et le non chevauchement
        }
        for (int i = 0; i<listeCases.size();i++){
            //System.out.println(i + " Avec X = " + listeCases.get(i).getX() + " et Y = " + listeCases.get(i).getY() + "\n et d'ID = " + listeCases.get(i).getGetID());
            MapDeCases.put(i, listeCases.get(i));




// Ajouter les bateaux dans les hashmappp !
            // donner case de départ pour chaque bateau

} for(Integer TY : mapDeBateaux.keySet()){
            System.out.println("Bateau n."+TY+ " de nom = "+ mapDeBateaux.get(TY).getNom_navire() );
        }
        return MapDeCases; }}

