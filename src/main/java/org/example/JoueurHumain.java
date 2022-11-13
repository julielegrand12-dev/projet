package org.example;

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
        int int_random = alea.nextInt(2);

        for (int i = 0; i< 10; i++) {
            int taille_bateau = Integer.valueOf(Bateau.getconfigbateau(i)[2]);
            int limite = 15 - taille_bateau;
            int test = 0;
            do {
                boolean Horizontal;
                int y;
                int x;
                if (int_random == 0) {
                    Horizontal = true;
                    // dans ce cas y reste le meme et x varie
                    // il faut s'assurer que la taille du bateau ne dépasse pas de la  grille
                    x = alea.nextInt(limite++);
                    y = alea.nextInt(16);
                    test = 1;
                } else {
                    Horizontal = false;
                    // x reste la meme et y varie
                    x = alea.nextInt(16);
                    y = alea.nextInt(limite++);
                    test = 1;
                }
            } while (test == 0);

// continuer cette fonction pour bien prendre encompte l'absence de voisins et le non chevauchement
        }
}

