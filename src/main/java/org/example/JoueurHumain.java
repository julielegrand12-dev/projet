package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JoueurHumain //initialisation de la classe joueur humain
{
    private String pseudo;
    private int score;

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

    protected void PlacementBateau() {

        Random alea = new Random();
        List<Integer> lesTailles = new ArrayList<>(List.of(7,5,5,3,3,3,1,1,1,1));
        List<String> lesNoms = new ArrayList<>(List.of("Cruisarde","Croiseur","Croiseur", "Destroyer","Destroyer","Destroyer","Destroyer","Sous-marrin","Sous-marin","Sous-marin","Sous-marin"));

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
            do {

                if (int_random == 0) {
                    Horizontal = true;
                    // dans ce cas y reste le meme et x varie
                    // il faut s'assurer que la taille du bateau ne dépasse pas de la  grille
                    x = alea.nextInt(limite++);
                    y = alea.nextInt(16);
                    for (int w=0;w<NoDoublonX.size();w++){
                        if(NoDoublonX.get(w) == x || NoDoublonY.get(w)== y){
                            x = alea.nextInt(limite++);
                            y = alea.nextInt(16);
                        }
                    }


                    test = 1;
                } else {
                    Horizontal = false;
                    // x reste la meme et y varie
                    x = alea.nextInt(16);
                    y = alea.nextInt(limite++);

                for (int w=0;w<NoDoublonX.size();w++){
                    if(NoDoublonX.get(w) == x && NoDoublonY.get(w)== y){
                        x = alea.nextInt(limite++);
                        y = alea.nextInt(16);
                    }
                }
                    }
                    test = 1;

                Bateau B = new Bateau(lesTailles.get(i), i,lesNoms.get(i));
                Case C  = new Case(x,y);
                int compte = i;
                compte = compte +1;
                if (lesTailles.get(i)== 7){
                    System.out.println("\nPlacement du " + lesNoms.get(i)+ " " + compte);
                    for(int z=0; z<7;z++){
                        if(Horizontal == true){
                            new Case(x++,y);
                        }
                        if(Horizontal == false){
                            new Case(x,y++);
                        }
                        System.out.println("Nouvelle case de coordonnée: X :" + x + " & Y:" + y);
                    }
                }
                if (lesTailles.get(i)== 5){
                    System.out.println("\nPlacement du " + lesNoms.get(i) + " " + compte++);
                    for(int z=0; z<5;z++){
                        if(Horizontal == true){
                            new Case(x++,y);
                        }
                        if(Horizontal == false){
                            new Case(x,y++);
                        }
                        System.out.println("Nouvelle case de coordonnée :  X : " + x + " & Y : " + y);
                    }
                }
                if (lesTailles.get(i)== 3){
                    System.out.println("\nPlacement du " + lesNoms.get(i) + " " +compte++);
                    for(int z=0; z<3;z++){
                        if(Horizontal == true){
                            new Case(x++,y);
                        }
                        if(Horizontal == false){
                            new Case(x,y++);
                        }
                        System.out.println("Nouvelle case de coordonnée : X : " + x + " & Y: " + y);
                    }
                }
                if (lesTailles.get(i)== 1){
                    System.out.println("\nPlacement du " + lesNoms.get(i) + " " +compte++);
                    for(int z=0; z<1;z++){
                        if(Horizontal == true){
                            new Case(x++,y);
                        }
                        if(Horizontal == false){
                            new Case(x,y++);
                        }
                        System.out.println("Nouvelle case de coordonnée : X : " + x + " & Y: " + y);
                    }
                }

            } while (test == 0);

// continuer cette fonction pour bien prendre encompte l'absence de voisins et le non chevauchement
        }
}}

