package org.example;
import java.util.ArrayList;
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
    private HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
    private HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();

    public Menu(int choix)
    {
        this.choix = choix;
    }

    public void MenuDebut()
    {
        JoueurHumain JoueurH = new JoueurHumain("Personne", 0);
        JoueurOrdi JoueurO = new JoueurOrdi("Ordinateur", 0);
        int x=6;

        System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles
        System.out.println("1- Jouer une partie\n");
        System.out.println("2- Charger une partie\n");
        System.out.println("3- Aide\n");
        System.out.println("4- Quitter\n");

        do             //blindage exception pour le choix du premier menu
        {do{try
        {choix = Integer.parseInt(scan.nextLine());
            x=0;} catch (Exception e) {System.out.println("L'entrée doit être un chiffre compris entre 1 et 4.");
            x=1;}
        }while(x!=0 ); }while(choix!=1 && choix!=2 && choix!=3 && choix!=4);

        JoueurH.setMapDeCasesHumain(mapDeCases);
        JoueurH.setMapDeBateauxHumain(mapDeBateaux);
        JoueurH.PlacementCasesHumain(mapDeCases, mapDeBateaux);
        JoueurH.PlacementBateauxHumain(mapDeBateaux);

        JoueurO.setMapDeCasesOrdi(mapDeCases);
        JoueurO.setMapDeBateauxOrdi(mapDeBateaux);
        JoueurO.PlacementCasesOrdi(mapDeCases, mapDeBateaux);
        JoueurO.PlacementBateauxOrdi(mapDeBateaux);

        switch(choix)
        {
            case 1 :
                System.out.println("Veuillez selectionner votre pseudo:\n");
                pseudo= scan1.nextLine();
                JoueurH.setPseudo(pseudo);
                System.out.println("Bonjour " + JoueurH.getPseudo() + "\n");
                System.out.println("Votre premier plateau "+JoueurH.getPseudo()+"(permet de positionner et visualiser les navires):\n");
                j.plateauHumainNavires(JoueurH,JoueurO);
                System.out.println("Votre deuxieme plateau plateau "+JoueurH.getPseudo()+"(pour visualiser les degats causes de l'adversaire):\n");
                j.plateauHumainDommages(JoueurH,JoueurO);

                System.out.println("Bonjour Joueur 2\n");
                System.out.println("Votre premier plateau Joueur 2 (permet de positionner et visualiser les navires):\n");
                j.plateauOrdiNavires(JoueurH,JoueurO);
                System.out.println("Votre deuxieme plateau plateau Joueur 2 (pour visualiser les degats causes de l'adversaire):\n");
                j.plateauOrdiDommages(JoueurH,JoueurO);
                //MenuBateau(JoueurH,JoueurO);
                break;
            case 2 : System.out.println("Redemarrer une partie\n");
                Sauvegarde S = new Sauvegarde();
                S.RecupererJeuHumain();
                S.RecupererJeuOrdi();
                break;
            case 3 : System.out.println("Aide\n");
                break;
            case 4 : System.out.println("Quitter\n");
                return;

        }
    }

    public void MenuBateau(JoueurHumain JoueurH, JoueurOrdi JoueurO)
    {
        //Déclaration HashMap
        int x=6;

        System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles
        System.out.println("1- Tirer\n");
        System.out.println("2- Déplacer un bateau de sa flotte\n");
        System.out.println("3- Quitter\n");

        do             //blindage exception pour le choix du menu bateau
        {do{try
        {choix = Integer.parseInt(scan.nextLine());
            x=0;} catch (Exception e) {System.out.println("L'entrée doit être un chiffre compris entre 1 et 3.");
            x=1;}
        }while(x!=0 ); }while(choix!=1 && choix!=2 && choix!=3);

        mapDeBateaux = JoueurH.getMapDeBateauxHumain();
        mapDeCases = JoueurH.getMapDeCasesHumain();
        mapDeBateaux = JoueurO.getMapDeBateauxOrdi();
        mapDeCases = JoueurO.getMapDeCasesOrdi();
        ArrayList<Case> mapdecaseseclairees = new ArrayList<Case>();

        switch(choix)
        {case 1 :
            int choixbateau =12;
            System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles
            System.out.println("1- Tirer avec le cuirasse d'id 0\n");
            System.out.println("2- Tirer avec le croiseur d'id 1\n");
            System.out.println("3- Tirer avec le croiseur d'id 2\n");
            System.out.println("2- Tirer avec le destroyer d'id 3\n");
            System.out.println("3- Tirer avec le destroyer d'id 4\n");
            System.out.println("2- Tirer avec le destroyer d'id 5\n");
            System.out.println("3- Tirer avec le sous-marin d'id 6\n");
            System.out.println("3- Tirer avec le sous-marin d'id 7\n");
            System.out.println("3- Tirer avec le sous-marin d'id 8\n");
            System.out.println("3- Tirer avec le sous-marin d'id 9\n");

            do             //blindage exception pour le choix du menu bateau
            {do{try
            {choixbateau = Integer.parseInt(scan.nextLine());
                x=0;} catch (Exception e) {System.out.println("L'entrée doit être un chiffre compris entre 1 et 9.");
                x=1;}
            }while(x!=0 ); }while((choixbateau!= 1) && (choixbateau != 2) && (choixbateau != 3) && (choixbateau != 4) && (choixbateau != 5) && (choixbateau != 6) && (choixbateau != 7) && (choixbateau != 8) && (choixbateau != 9));

            System.out.println(JoueurH.getMapDeCasesHumain());

            if(choixbateau==3 || choixbateau==4 || choixbateau==5)
            {
                mapDeBateaux.get(choixbateau).AttaqueHumainDestroyer(JoueurO,JoueurH, mapdecaseseclairees);
            }

            else
            {
                mapDeBateaux.get(choixbateau).AttaqueHumain(JoueurO,JoueurH);
            }

            break;

            case 2:
                JoueurH.DeplacerBateauHumain(mapDeBateaux, mapDeCases);
                break;

            case 3 : System.out.println("Quitter\n");
                return;

        }
    }

}
