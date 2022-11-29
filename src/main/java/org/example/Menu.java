package org.example;
import java.util.HashMap;
import java.util.Scanner;

public class Menu
{


    private int choix=0;
    private Scanner scan = new Scanner(System.in);
    private boolean test=false;
    Jeu j= new Jeu('0', '0');

    private String pseudo;
    private Scanner scan1 = new Scanner(System.in);

    JoueurHumain J = new JoueurHumain("Sara",0);

    //Déclaration HashMap
    HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
    HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();


    public Menu(int choix)
    {
        this.choix = choix;
    }

    public void MenuDebut()
    {
        System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles
        System.out.println("1- Jouer une partie\n");
        System.out.println("2- Charger une partie\n");
        System.out.println("3- Aide\n");
        System.out.println("4- Quitter\n");

        do{
            choix= scan.nextInt();
            if(choix>0 && choix<5)
                test=true;
            else
                System.out.println("Erreur ");
        }while(!test);

        switch(choix)
        {
            case 1 :
                System.out.println("Veuillez selectionner votre pseudo:\n");
                pseudo= scan1.nextLine();
                JoueurHumain joueurH= new JoueurHumain(pseudo, '0'); //nous inserons le pseudo choisi dans le constructeur
                System.out.println("Bonjour " + joueurH.getPseudo() + "\n");
                System.out.println("Votre premier plateau "+joueurH.getPseudo()+"(permet de positionner et visualiser les navires):\n");
                j.plateauHumainNavires();
                System.out.println("Votre deuxieme plateau plateau "+joueurH.getPseudo()+"(pour visualiser les degats causes de l'adversaire):\n");
                j.plateauHumainDommages();
                System.out.println("Bonjour Joueur 2\n");
                System.out.println("Votre premier plateau Joueur 2 (permet de positionner et visualiser les navires):\n");
                j.plateauOrdiNavires();
                System.out.println("Votre deuxieme plateau plateau Joueur 2 (pour visualiser les degats causes de l'adversaire):\n");
                j.plateauOrdiDommages();
                break;
            case 2 : System.out.println("Redemarrer une partie\n");
                break;
            case 3 : System.out.println("Aide\n");
                break;
            case 4 : System.out.println("Quitter\n");
                return;

        }
    }

    public void MenuBateau()
    {
        //Déclaration HashMap
        HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();

        //Appel de fonctions dans les classes
        J.setMapDeCases(mapDeCases);
        J.setMapDeBateaux(mapDeBateaux);

        System.out.println("Veuillez faire un choix");
        //Nous affichons les choix possibles
        System.out.println("1- Tirer\n");
        System.out.println("2- Déplacer un bateau de sa flotte\n");
        System.out.println("3- Quitter\n");

        do{
            choix= scan.nextInt();
            if(choix>0 && choix<4)
                test=true;
            else
                System.out.println("Erreur ");
        }while(!test);

        switch(choix)
        {
            case 1 :
                break;

            case 2:
                //Appel de fonctions dans les classes
J.PlacementCases(mapDeCases, mapDeBateaux);
                J.setMapDeBateaux(mapDeBateaux);
                J.PlacementBateaux(mapDeBateaux);

                J.DeplacerBateau(mapDeBateaux);
                break;

            case 3 : System.out.println("Quitter\n");
                return;

        }
    }

}
