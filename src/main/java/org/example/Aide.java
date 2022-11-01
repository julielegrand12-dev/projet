package org.example;

public class Aide {

    public void AideReglesJeu()
    {
        System.out.println("REGLES DU JEU");
        System.out.println("Vous possédez 10 navires");
        //recuperer les types navires dans la classe jeu avec les taille pour les afficher
        System.out.println("ACTIONS A REALISER DURANT LA PARTIE\n");

        System.out.println("Les navires sont : \n");
        System.out.println("1- Les cuirassés - puissance de tir de 9 cases - symbole &\n");
        System.out.println("2- Les croiseurs - puissance de tir de 4 cases - symbole *\n");
        System.out.println("3- Les destroyers - puissance de tir de 1 cases - symbole +\n");
        System.out.println("4- Les sous-marins - puissance de tir de 1 cases - symbole %\n");
        System.out.println("Bonne chance !");
    }
}
