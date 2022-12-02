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


    //JoueurHumain J = new JoueurHumain("Sara",0);

    //Déclaration HashMap

   private HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
    private HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();



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

        JoueurHumain JoueurH = new JoueurHumain("Personne", 0);


        JoueurH.setMapDeCasesHumain(mapDeCases);
        JoueurH.setMapDeBateauxHumain(mapDeBateaux);
        JoueurH.PlacementCasesHumain(mapDeCases, mapDeBateaux);
        JoueurH.PlacementBateauxHumain(mapDeBateaux);

        JoueurOrdi JoueurO = new JoueurOrdi("Ordinateur", 0);


        JoueurO.setMapDeCasesOrdi(mapDeCases);
        JoueurO.setMapDeBateauxOrdi(mapDeBateaux);
        JoueurO.PlacementCasesOrdi(mapDeCases, mapDeBateaux);
        JoueurO.PlacementBateauxOrdi(mapDeBateaux);



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
        mapDeBateaux = JoueurH.getMapDeBateauxHumain();
        mapDeCases = JoueurH.getMapDeCasesHumain();
        mapDeBateaux = JoueurO.getMapDeBateauxOrdi();
        mapDeCases = JoueurO.getMapDeCasesOrdi();

        switch(choix)
        {


            case 1 :
                System.out.println(JoueurH.getMapDeCasesHumain());
                mapDeBateaux.get(9).AttaqueHumain(JoueurO,JoueurH);
                break;

            case 2:
                //Appel de fonctions dans les classes

                JoueurH.DeplacerBateau(mapDeBateaux, mapDeCases);
                break;

            case 3 : System.out.println("Quitter\n");
                return;

        }
    }

}
