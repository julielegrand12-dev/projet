package org.example;
import java.util.Scanner;
public class Menu
{
    Plateau P = new Plateau();
    private int choix=0;
    private Scanner scan = new Scanner(System.in);
    private boolean test=false;

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
            case 1 : System.out.println("Nouvelle partie\n");
                P.plateau(15,15);
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
