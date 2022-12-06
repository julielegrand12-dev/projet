package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Menu
{
    private int choix=0;
    private Scanner scan = new Scanner(System.in);
    private boolean test=false;
    Jeu jeu= new Jeu('0', '0');
    private String pseudo;
    private Scanner scan1 = new Scanner(System.in);
    Bateau b=new Bateau();
    Plateau Ph = new Plateau();

    public Menu(int choix)
    {
        this.choix = choix;
    }
    public void MenuDebut()
    {
        JoueurHumain JoueurH = new JoueurHumain("Personne", 0);
        JoueurOrdi JoueurO = new JoueurOrdi("Ordinateur", 0);
        HashMap<Integer, Case> mapDeCasesHumain = new HashMap<Integer, Case>();
         HashMap<Integer, Bateau> mapDeBateauxHumain = new HashMap<>();
       HashMap<Integer, Case> mapDeCasesOrdi = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateauxOrdi = new HashMap<>();
        Plateau Ph = new Plateau();
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


        switch(choix)
        {
            case 1 :
                JoueurH.setMapDeCasesHumain(mapDeCasesHumain);
                JoueurH.setMapDeBateauxHumain(mapDeBateauxHumain);
                JoueurH.PlacementCasesHumain(mapDeCasesHumain, mapDeBateauxHumain);
                JoueurH.PlacementBateauxHumain(mapDeBateauxHumain);

                JoueurO.setMapDeCasesOrdi(mapDeCasesOrdi);
                JoueurO.setMapDeBateauxOrdi(mapDeBateauxOrdi);
                JoueurO.PlacementCasesOrdi(mapDeCasesOrdi, mapDeBateauxOrdi);
                JoueurO.PlacementBateauxOrdi(mapDeBateauxOrdi);
                System.out.println("Veuillez selectionner votre pseudo:\n");
                pseudo= scan1.nextLine();
                JoueurH.setPseudo(pseudo);
                System.out.println("Bonjour " + JoueurH.getPseudo() + "\n");
                System.out.println("Votre premier plateau "+JoueurH.getPseudo()+"(permet de positionner et visualiser les navires):\n");
                jeu.plateauHumainNavires(JoueurH,JoueurO);
                MenuBateau(JoueurH,JoueurO,Ph);
               // System.out.println("Votre deuxieme plateau plateau "+JoueurH.getPseudo()+"(pour visualiser les degats causes de l'adversaire):\n");
               // jeu.plateauHumainDommages(JoueurH,JoueurO);
               // MenuBateau(JoueurH,JoueurO);

                //System.out.println("Bonjour Joueur 2\n");
                //System.out.println("Votre premier plateau Joueur 2 (permet de positionner et visualiser les navires):\n");
                //jeu.plateauOrdiNavires(JoueurH,JoueurO);
               // System.out.println("Votre deuxieme plateau plateau Joueur 2 (pour visualiser les degats causes de l'adversaire):\n");
                //jeu.plateauOrdiDommages(JoueurH,JoueurO);
                //MenuBateau(JoueurH,JoueurO);
                break;
            case 2 : System.out.println("Redemarrer une partie\n");
                Sauvegarde S = new Sauvegarde();
                S.RecupererJeuHumain(JoueurH);
                S.RecupererJeuOrdi(JoueurO);
                jeu.plateauHumainNavires(JoueurH,JoueurO);
                MenuBateau(JoueurH,JoueurO,Ph);
                break;
            case 3 : System.out.println("Aide\n");
                break;
            case 4 : System.out.println("Quitter\n");
                return;

        }
    }

    public void MenuBateau(JoueurHumain JoueurH, JoueurOrdi JoueurO,Plateau Ph)
    {
        HashMap<Integer, Case> mapDeCasesHumain = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateauxHumain = new HashMap<>();
        HashMap<Integer, Case> mapDeCasesOrdi = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateauxOrdi = new HashMap<>();

        int x=6;
        int compteur=0;

        do
        {
        if(compteur%2==0)
        {
        System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles
        System.out.println("1- Tirer\n");
        System.out.println("2- Déplacer un bateau de sa flotte\n");

        do             //blindage exception pour le choix du menu bateau
        {do{try
        {choix = Integer.parseInt(scan.nextLine());
            x=0;} catch (Exception e) {System.out.println("L'entrée doit être un chiffre compris entre 1 et 3.");
            x=1;}
        }while(x!=0 ); }while(choix!=1 && choix!=2);

        mapDeBateauxHumain = JoueurH.getMapDeBateauxHumain();
        mapDeCasesHumain = JoueurH.getMapDeCasesHumain();
        mapDeBateauxOrdi = JoueurO.getMapDeBateauxOrdi();
        mapDeCasesOrdi = JoueurO.getMapDeCasesOrdi();

        switch(choix)
        {
            case 1:

                ArrayList<Case> mapdecaseseclairees = new ArrayList<Case>();
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

            if(choixbateau==3 || choixbateau==4 ||choixbateau==5 )
            {
                mapDeBateauxHumain.get(choixbateau).AttaqueHumainDestroyer(JoueurO,JoueurH,mapdecaseseclairees);
            }
            else
            {
                mapDeBateauxHumain.get(choixbateau).AttaqueHumain(JoueurO,JoueurH, 2, 2);
            }

                Ph.PlateauDommage(JoueurH,JoueurO,Ph);
                compteur++;
            break;

            case 2:

                JoueurH.DeplacerBateauHumain(mapDeBateauxHumain, mapDeCasesHumain);
                Ph.PlateauJoueur(JoueurH,JoueurO,Ph);
                compteur++;
                break;

        }
        }

        if(compteur%2==1)
        {
            mapDeBateauxHumain = JoueurH.getMapDeBateauxHumain();
            mapDeCasesHumain = JoueurH.getMapDeCasesHumain();
            mapDeBateauxOrdi = JoueurO.getMapDeBateauxOrdi();
            mapDeCasesOrdi = JoueurO.getMapDeCasesOrdi();

            Random r = new Random();
            //int n = r.nextInt(2);
            int n=0;

            System.out.println("Joueur Ordinateur - A votre tour"); //Nous affichons les choix possibles
        System.out.println("1- Tirer\n");
        System.out.println("2- Déplacer un bateau de sa flotte\n");

        //if(n==0) {System.out.println("L'odinateur a choisi: 1 - Tirer\n");}
        //else if(n==1) {System.out.println("L'odinateur a choisi: 2 - Deplacer un bateau de sa flotte\n");}

        switch(n)
        {
            case 0:

            ArrayList<Case> mapdecaseseclairees = new ArrayList<Case>();

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

                Random v = new Random();
                int j = v.nextInt(10);

            if(j==3 || j==4 ||j==5 )
            {
                mapDeBateauxOrdi.get(j).AttaqueOrdiDestroyer(JoueurO,JoueurH,mapdecaseseclairees);
            }
            else
            {
                mapDeBateauxOrdi.get(j).AttaqueOrdi(JoueurO,JoueurH);
            }

            Ph.PlateauDommage(JoueurH,JoueurO,Ph);
            compteur++;
            break;

            case 1:
            JoueurO.DeplacerBateauOrdi(mapDeBateauxOrdi, mapDeCasesOrdi);
            Ph.PlateauJoueur(JoueurH,JoueurO,Ph);
            compteur++;
            break;

        }
        }
    }while(b.flotteACouler(mapDeCasesHumain,mapDeBateauxHumain)!=true || b.flotteACouler(mapDeCasesOrdi, mapDeBateauxOrdi)!=true);


    }
}
