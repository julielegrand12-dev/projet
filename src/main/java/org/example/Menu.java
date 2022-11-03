package org.example;
import java.util.Scanner;
public class Menu
{
    private int choix=0;
    private Scanner scan = new Scanner(System.in);
    private boolean test=false;
    Jeu j= new Jeu('0', '0');
    private String pseudo;
    private Scanner scan1 = new Scanner(System.in);

    public void MenuDebut()
    {
        System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles sur
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
}
