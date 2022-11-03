package org.example;
import java.util.Scanner;
public class Menu
{
    private int choix=0;
    private Scanner scan = new Scanner(System.in);
    private Scanner scan1 = new Scanner(System.in);
    private boolean test=false;
    private String pseudo;
    Jeu j= new Jeu('0', '0');

    public void MenuDebut()
    {
        System.out.println("Veuillez faire un choix");
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
                System.out.println("Votre plateau "+joueurH.getPseudo()+":\n");
                j.plateauHumain();
                System.out.println("Bonjour Joueur 2\n");
                System.out.println("Votre plateau Joueur 2:\n");
                j.plateauOrdi();
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
