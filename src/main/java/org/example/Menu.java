package org.example;
import java.util.Scanner;
public class Menu {

    int choix=0;
    boolean test=false;
        System.out.print("Veuillez faire un choix");
    Scanner sc = new Scanner(System.in);
        do{

            choix= sc.nextInt();
            if(choix>0)
                test=true;
            else
                System.out.println("Erreur ");
        }

    }while(!test);


}
