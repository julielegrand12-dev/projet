package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * Dans cette classe, nous avons les règles du jeu.
 */
public class Aide extends JPanel {
    private JFrame fen;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel lab;
    private JLabel l1;
    private JTextField l3;
    private JLabel l2;

    public void AideReglesJeu() {
        System.out.println("INITIALISATION\n");
        System.out.println("Vous possedez plusieurs bâteaux dont des :");
        System.out.println("1- Les cuirassés - puissance de tir de 9 cases - couleur rouge");
        System.out.println("2- Les croiseurs - puissance de tir de 4 cases - couleur rose");
        System.out.println("3- Les destroyers - puissance de tir de 1 cases - couleur orange");
        System.out.println("4- Les sous-marins - puissance de tir de 1 cases - couleur jaune\n\n");
        System.out.println("ACTIONS A REALISER DURANT LA PARTIE\n");
        System.out.println("1- Déplacer un de vos bateaux d'une case");
        System.out.println("2- Tirer sur une case du plateau de l'adversaire");
        System.out.println("3- Sauvegarder la partie pour continuer de jouer plus tard : cliquez sur le bouton de sauvegarde\n");
        System.out.println("L'objectif est de couler tous les bateaux de votre adversaire\n");
        System.out.println("Bonne chance !");
    }
//k


}

