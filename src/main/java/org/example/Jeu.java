package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Jeu {
    ArrayList<Integer> navires = new ArrayList<Integer>();
    int taille_1 = 7;
    int taille_2 = 5;
    int taille_3 = 3;
    int taille_4 = 1;
    int Joueur1=0;
    int Joueur2=0;

    //grille
    private int nbligne;
    private int nbcol;

    //Constructeur
    public Jeu(int nbligne, int nbcol) {
        this.nbligne = nbligne;
        this.nbcol = nbcol;
    }

    //Getters et Setters
    public ArrayList<Integer> getNavires() {
        return navires;
    }

    public void setNavires(ArrayList<Integer> navires) {
        this.navires = navires;
    }

    public void positionnement_navire()
    {
        int hori = 0;
        int verti = 1;
        //grille de 15 * 15 - placer 4 navires
        int tempo = 0;

    }

    public void plateauHumainNavires ()
    {


    Plateau Ph = new Plateau();


    Ph.PlateauJoueur();
    }

    public void plateauHumainDommages ()
    {
        Plateau Pd = new Plateau();
        Pd.PlateauDommage();

    }

    public void plateauOrdiNavires ()
    {

        Plateau Po = new Plateau();

        Po.PlateauJoueur();
    }

    public void plateauOrdiDommages ()
    {
        Plateau Pn = new Plateau();
        Pn.PlateauDommage();
      // Pn.gui();
    }

}
