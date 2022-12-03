package org.example;
import java.util.HashMap;
import java.util.Scanner;

public class Menu
{
    private int choix=0;
    private Scanner scan = new Scanner(System.in);
    private boolean test=false;
    Jeu jeu= new Jeu('0', '0');
    private String pseudo;
    private Scanner scan1 = new Scanner(System.in);

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

        JoueurH.setMapDeCasesHumain(mapDeCasesHumain);
        JoueurH.setMapDeBateauxHumain(mapDeBateauxHumain);
        JoueurH.PlacementCasesHumain(mapDeCasesHumain, mapDeBateauxHumain);
        JoueurH.PlacementBateauxHumain(mapDeBateauxHumain);

        JoueurO.setMapDeCasesOrdi(mapDeCasesOrdi);
        JoueurO.setMapDeBateauxOrdi(mapDeBateauxOrdi);
        JoueurO.PlacementCasesOrdi(mapDeCasesOrdi, mapDeBateauxOrdi);
        JoueurO.PlacementBateauxOrdi(mapDeBateauxOrdi);

        switch(choix)
        {
            case 1 :
                System.out.println("Veuillez selectionner votre pseudo:\n");
                pseudo= scan1.nextLine();
                JoueurH.setPseudo(pseudo);
                System.out.println("Bonjour " + JoueurH.getPseudo() + "\n");
                System.out.println("Votre premier plateau "+JoueurH.getPseudo()+"(permet de positionner et visualiser les navires):\n");
                jeu.plateauHumainNavires(JoueurH,JoueurO);

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
                S.RecupererJeuHumain();
                S.RecupererJeuOrdi();
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

        mapDeBateauxHumain = JoueurH.getMapDeBateauxHumain();
        mapDeCasesHumain = JoueurH.getMapDeCasesHumain();
        mapDeBateauxOrdi = JoueurO.getMapDeBateauxOrdi();
        mapDeCasesOrdi = JoueurO.getMapDeCasesOrdi();

        switch(choix)
        {case 1 :
                System.out.println(JoueurH.getMapDeCasesHumain());
                Ph.PlateauDommage(JoueurH,JoueurO,Ph);
                mapDeBateauxHumain.get(9).AttaqueHumain(JoueurO,JoueurH);
                break;

            case 2:
                JoueurH.DeplacerBateauHumain(mapDeBateauxHumain, mapDeCasesHumain);
                Ph.PlateauJoueur(JoueurH,JoueurO,Ph);
                break;

            case 3 : System.out.println("Quitter\n");
                return;

        }
    }

}
