package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * Dans cette classe, nous avons les règles du jeu.
 */
public class Aide extends JPanel  {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PINK = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public void AideReglesJeu()
    {

        System.out.println(ANSI_BLUE + "AIDE\n\n" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Jeu de la bataille navale - Regle du jeu\n" + ANSI_RESET);
        System.out.println(ANSI_PINK + "MISE EN SITUATION" + ANSI_RESET);
        System.out.println(ANSI_PINK + "Vous possedez plusieurs bâteaux dont :" + ANSI_RESET);
        System.out.println("1- Les cuirassés - puissance de tir de 9 cases - couleur rouge");
        System.out.println("2- Les croiseurs - puissance de tir de 4 cases - couleur rose");
        System.out.println("3- Les destroyers - puissance de tir de 1 cases - couleur orange");
        System.out.println("4- Les sous-marins - puissance de tir de 1 cases - couleur jaune\n\n");

        System.out.println( ANSI_YELLOW+"ACTIONS A REALISER DURANT LA PARTIE"+ ANSI_RESET);
        System.out.println("1- Tirer sur une case du plateau de l'adversaire - cliquez sur la case que vous souhaitez attaquer");
        System.out.println("2- Déplacer un de vos bateaux d'une case - vous ne pouvez pas déplacer un bateau qui a deja été touché");
        System.out.println("3- Sauvegarder la partie pour continuer de jouer plus tard : cliquez sur le bouton de sauvegarde\n");
        System.out.println("L'objectif est de couler tous les bateaux de votre adversaire\n");
        System.out.println(ANSI_BLUE + "Bonne chance !" + ANSI_RESET);

    }
}