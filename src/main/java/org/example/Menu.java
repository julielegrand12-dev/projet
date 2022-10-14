package org.example;
import java.util.Scanner;
public class Menu
{

         int choix=0;
        boolean test=false;
        System.out.println("Veuillez faire un choix");
        System.out.println("1- Jouer une partie\n");
        System.out.println("2- Charger une partie\n");
        System.out.println("3- Aide\n");
        System.out.println("4- Quitter\n");

    private Scanner scan = new Scanner(System.in);
        do{

            choix= scan.nextInt();
            if(choix>0 && choix<5)
                test=true;
            else
                System.out.println("Erreur ");
        }

    }while(!test);


}
