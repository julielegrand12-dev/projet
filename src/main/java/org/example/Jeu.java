package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Jeu {
    ArrayList<Integer> navires = new ArrayList<Integer>();


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

    public void plateauHumainNavires (JoueurHumain JoueurH,JoueurOrdi JoueurO)
    {
    Plateau Ph = new Plateau();
    Ph.PlateauDommage(JoueurH,JoueurO,Ph);
    Ph.PlateauJoueur(JoueurH,JoueurO,Ph);
    }

    public void plateauHumainDommages (JoueurHumain JoueurH,JoueurOrdi JoueurO)
    {
        Plateau Pd = new Plateau();
        //Pd.PlateauDommage(JoueurH,JoueurO);

    }

    public void plateauOrdiNavires (JoueurHumain JoueurH,JoueurOrdi JoueurO)
    {

        Plateau Po = new Plateau();
        //Po.PlateauJoueur(JoueurH,JoueurO);
    }

    public void plateauOrdiDommages (JoueurHumain JoueurH,JoueurOrdi JoueurO)
    {
        Plateau Pn = new Plateau();
        //Pn.PlateauDommage(JoueurH,JoueurO);

    }

}
